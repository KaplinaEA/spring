package com.example.ssu;

import com.example.ssu.Service.NewsService;
import com.example.ssu.Service.TegsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SsuApplication implements CommandLineRunner {

    @Autowired
    private TegsService tegsService;

    @Autowired
    private NewsService newsService;

    public static void main(String[] args) {
        SpringApplication.run(SsuApplication.class, args);
    }

    @Override
    public void run(String... args) {
        tegsService.create("#covid-19");
        tegsService.create("#сгу");
        tegsService.create("#смерть");

        newsService.create("Скоро умрет 20000000 человек!!!!",
                "По подсчетом ученных .....",
                new HashSet<>(Arrays.asList(1,3))
                );
        newsService.create("Начало сессии",
                "Внимание! С 1 декабря начинается сессия.",
                new HashSet<>(Arrays.asList(2))
                );
    }
}
