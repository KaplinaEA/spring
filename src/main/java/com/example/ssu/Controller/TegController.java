package com.example.ssu.Controller;

import com.example.ssu.Entity.Tegs;
import com.example.ssu.Service.TegsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teg")
public class TegController {
    @Autowired
    private TegsService tegsService;

    @GetMapping
    public ResponseEntity<Iterable<Tegs>> index(){
        return ResponseEntity.ok().body(tegsService.index());
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
    public ResponseEntity<Tegs> edit(@RequestBody String request) {
        return tegsService.edit(request);
    }

    @DeleteMapping("{tegs:\\d+}")
    public ResponseEntity<String> delete(@PathVariable Tegs tegs) {
        tegsService.delete(tegs);
        return new ResponseEntity<>("Teg deleted", HttpStatus.OK);
    }
}
