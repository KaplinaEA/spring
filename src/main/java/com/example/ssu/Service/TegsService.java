package com.example.ssu.Service;

import com.example.ssu.Entity.Tegs;
import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Helper.StatusRepository;
import com.example.ssu.Repository.TegsRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@Transactional
public class TegsService {

    @Autowired
    StatusRepository statusRepository;

    private final TegsRepository tegsRepository;
    public TegsService(TegsRepository tegsRepository)
    {
        this.tegsRepository = tegsRepository;
    }

    public Iterable<Tegs> index(){
        Iterable<Tegs> tegs = tegsRepository.findByStatus(statusRepository.findById(AbstractStatus.ACTIVE).get());
        return tegs;
    }

    public Tegs create(String name){
        Tegs tegs = new Tegs(name);
        tegs.setStatus(statusRepository.findById(AbstractStatus.ACTIVE).get());
        tegsRepository.save(tegs);
        return tegs;
    }

    public Tegs edit(@RequestBody String request){
        JsonObject jsonObject = new Gson().fromJson(request, JsonObject.class);
        Integer id = jsonObject.get("id").getAsInt();
        JsonElement name = jsonObject.get("name");

        Optional<Tegs> teg = tegsRepository.findById(id);
        if (name != null)
            teg.get().setName(name.isJsonNull()?null:name.getAsString());
        tegsRepository.save(teg.get());
        return teg.get();
    }

    public void delete(Tegs tegs)
    {
        tegs.setStatus(statusRepository.findById(AbstractStatus.ARCHIVE).get());
        tegsRepository.save(tegs);
    }
}