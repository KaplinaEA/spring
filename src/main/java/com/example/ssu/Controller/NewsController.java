package com.example.ssu.Controller;

import com.example.ssu.Entity.News;
import com.example.ssu.Entity.Tegs;
import com.example.ssu.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public Iterable<News> index() {
        return newsService.index();
    }

    @GetMapping("{news:\\d+}")
    public News show(@PathVariable News news) {
        return news;
    }

    @PostMapping("/new")
    public News create(@RequestParam String name,
                       @RequestParam(required = false) String description,
                       @RequestBody Set<Integer> tegs) {
        return newsService.create(name, description, tegs);
    }

    @PostMapping("{news:\\d+}/tegs")
    public News addTegs(@PathVariable News news,
                        @RequestParam Set<Integer> tegs) {
        return newsService.addTegs(news, tegs);
    }

    @PutMapping()
    public News edit(@RequestBody String request) {
        return newsService.edit(request);
    }

    @DeleteMapping("{news:\\d+}")
    public void delete(@PathVariable News news) {
        newsService.delete(news);
    }

    @GetMapping("/teg/{tegs:\\d+}")
    public Iterable<News> getForTeg(@PathVariable Tegs tegs) {
        return newsService.getForTeg(tegs);
    }
}
