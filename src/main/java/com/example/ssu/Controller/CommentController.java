package com.example.ssu.Controller;

import com.example.ssu.Entity.Comment;
import com.example.ssu.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public Iterable<Comment> index()
    {
        return commentService.index();
    }

    @GetMapping("{news:\\d+}")
    public Comment show(@PathVariable Comment comment)
    {
        return comment;
    }

    @PostMapping("/new")
    public Comment create(@RequestParam String text, @RequestParam Integer idNews)
    {
        return commentService.create(text, idNews);
    }

    @PutMapping()
    public Comment edit(@RequestBody String request)
    {
        return commentService.edit(request);
    }

    @DeleteMapping("{news:\\d+}")
    public void delete(@PathVariable Comment comment)
    {
        commentService.delete(comment);
    }
}
