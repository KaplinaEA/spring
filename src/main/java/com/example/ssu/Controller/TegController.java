package com.example.ssu.Controller;

import com.example.ssu.Entity.Tegs;
import com.example.ssu.Service.TegsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teg")
public class TegController {
    @Autowired
    private TegsService tegsService;

    @GetMapping
    public Iterable<Tegs> index() {
        return tegsService.index();
    }

    @GetMapping("{tegs:\\d+}")
    public Tegs show(@PathVariable Tegs tegs) {
        return tegs;
    }

    @PostMapping("/new")
    public Tegs create(@RequestParam String name) {
        return tegsService.create(name);
    }

    @PutMapping()
    public Tegs edit(@RequestBody String request) {
        return tegsService.edit(request);
    }

    @DeleteMapping("{tegs:\\d+}")
    public void delete(@PathVariable Tegs tegs) {
        tegsService.delete(tegs);
    }
}
