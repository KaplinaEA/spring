package com.example.ssu.Service;

import com.example.ssu.Entity.Comment;
import com.example.ssu.Entity.News;
import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Repository.CommentRepository;
import com.example.ssu.Repository.NewsRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private NewsRepository newsRepository;

    public Iterable<Comment> index() {
        Iterable<Comment> tegs = commentRepository.findByStatus(AbstractStatus.ACTIVE);
        return tegs;
    }

    public Comment create(String text, Integer newsId) {
        Comment comment = new Comment(text);
        commentRepository.save(comment);
        News news = newsRepository.findById(newsId).get();
        news.addComments(comment);
        newsRepository.save(news);
        return comment;
    }

    public ResponseEntity<Comment> edit(@RequestBody String request) {
        JsonObject jsonObject = new Gson().fromJson(request, JsonObject.class);
        Integer id = jsonObject.get("id").getAsInt();
        JsonElement text = jsonObject.get("text");

        Optional<Comment> comment = commentRepository.findById(id);
        if(!comment.isPresent()) return ResponseEntity.notFound().build();
        if (text != null) {
            comment.get().setText(text.isJsonNull() ? null : text.getAsString());
            comment.get().setUpdateAt();
        } else return ResponseEntity.badRequest().build();
        commentRepository.save(comment.get());
        return ResponseEntity.ok().body(comment.get());
    }

    public void delete(Comment comment) {
        comment.setStatus(AbstractStatus.ARCHIVE);
        commentRepository.save(comment);
    }
}
