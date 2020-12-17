package com.example.ssu.Repository;

import com.example.ssu.Entity.News;
import com.example.ssu.Entity.Tegs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Integer> {
    Iterable<News> findByStatus(Integer status);

    @Query("select n from news as n inner join n.tegsSet t where t = :teg")
    Iterable<News> findByTeg(@Param("teg") Tegs teg);
}
