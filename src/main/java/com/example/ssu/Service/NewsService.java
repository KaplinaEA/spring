package com.example.ssu.Service;

import com.example.ssu.Entity.News;
import com.example.ssu.Entity.Tegs;
import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Helper.StatusRepository;
import com.example.ssu.Repository.NewsRepository;
import com.example.ssu.Repository.TegsRepository;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
@Transactional
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private TegsRepository tegsRepository;
    @Autowired
    private StatusRepository statusRepository;

    public Iterable<News> index(){
        Iterable<News> news = newsRepository.findByStatus(statusRepository.findById(AbstractStatus.ACTIVE).get());
        //findAll();
        return news;
    }

    public News create(String name, String description, Set<Integer> tegs){
        News news = new News(name, description);
        Map<Integer, Tegs> map = new HashMap<Integer, Tegs>(){};
        for (Integer item:tegs) {
            map.put(item, tegsRepository.findById(item).get());
        }
        news.setTegsSet(new HashSet<Tegs>(map.values()));
        news.setStatus(statusRepository.findById(AbstractStatus.ACTIVE).get());
        newsRepository.save(news);
        return news;
    }

    public News edit(@RequestBody String request){
        JsonObject jsonObject = new Gson().fromJson(request, JsonObject.class);
        JsonElement description = jsonObject.get("description");
        Integer id = jsonObject.get("id").getAsInt();
        JsonElement name = jsonObject.get("name");

        Optional<News> newsIdb = newsRepository.findById(id);
        if (description != null)
            newsIdb.get().setDescription(description.isJsonNull()?null:description.getAsString());
        if (name != null && !name.isJsonNull())
            newsIdb.get().setName(name.getAsString());
        newsRepository.save(newsIdb.get());
        return newsIdb.get();
    }

    public News addTegs(News news, Set<Integer> tegs){
        Map<Integer, Tegs> map = new HashMap<Integer, Tegs>(){};
        for (Integer item:tegs) {
            map.put(item, tegsRepository.findById(item).get());
        }
        news.setTegsSet(new HashSet<Tegs>(map.values()));
        newsRepository.save(news);
        return news;
    }

    public void delete(News news)
    {
//        news.setStatus(AbstractStatus.ARCHIVE);
        news.setStatus(statusRepository.findById(AbstractStatus.ARCHIVE).get());
        newsRepository.save(news);
//        newsRepository.delete(news);
    }
}
