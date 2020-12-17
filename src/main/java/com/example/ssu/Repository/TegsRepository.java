package com.example.ssu.Repository;

import com.example.ssu.Entity.Tegs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TegsRepository extends JpaRepository<Tegs, Integer>{
    Iterable<Tegs> findByStatus(Integer status);
}
