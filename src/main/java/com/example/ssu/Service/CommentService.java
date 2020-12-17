package com.example.ssu.Service;

import com.example.ssu.Entity.Comment;
import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Repository.CommentRepository;
import com.example.ssu.Repository.NewsRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
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
        Comment comment = new Comment(text, newsRepository.findById(newsId).get());
        commentRepository.save(comment);
        return comment;
    }

    public Comment edit(@RequestBody String request) {
        JsonObject jsonObject = new Gson().fromJson(request, JsonObject.class);
        Integer id = jsonObject.get("id").getAsInt();
        JsonElement text = jsonObject.get("text");

        Optional<Comment> comment = commentRepository.findById(id);
        if (text != null) {
            comment.get().setText(text.isJsonNull() ? null : text.getAsString());
            comment.get().setUpdateAp(new Date());
        } else //ошибка;
            commentRepository.save(comment.get());
        return comment.get();
    }

    public void delete(Comment comment) {
        comment.setStatus(AbstractStatus.ARCHIVE);
        commentRepository.save(comment);
    }
}
