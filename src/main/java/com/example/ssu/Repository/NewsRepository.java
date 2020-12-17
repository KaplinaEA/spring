package com.example.ssu.Repository;

import com.example.ssu.Entity.News;
import com.example.ssu.Entity.Tegs;
import com.example.ssu.Helper.Status;
import com.example.ssu.Helper.StatusRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NewsRepository extends //StatusRepository<News> {
    JpaRepository<News, Integer>{
    Iterable<News> findByStatus (Status status);
}
