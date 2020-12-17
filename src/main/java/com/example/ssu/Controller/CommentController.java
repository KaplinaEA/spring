package com.example.ssu.Controller;

import com.example.ssu.Entity.Comment;
import com.example.ssu.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public Iterable<Comment> index() {
        return commentService.index();
    }

    @GetMapping("/{comment:\\d+}")
    public Comment show(@PathVariable Comment comment) {
        return comment;
    }

    @PostMapping("/new")
    public Comment create(@RequestParam String text, @RequestParam Integer idNews) {
        return commentService.create(text, idNews);
    }

    @PutMapping()
    public ResponseEntity<Comment> edit(@RequestBody String request) {
        return commentService.edit(request);
    }

    @DeleteMapping("/{comment:\\d+}")
    public ResponseEntity<String> delete(@PathVariable Comment comment) {
        commentService.delete(comment);
        return new ResponseEntity<>("Comment deleted", HttpStatus.OK);
    }
}
