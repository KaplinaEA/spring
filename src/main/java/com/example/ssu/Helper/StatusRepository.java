package com.example.ssu.Helper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
//public interface StatusRepository<T extends Status> extends JpaRepository<T, Integer> {
public interface StatusRepository extends JpaRepository<Status, Integer> {

//    @Query("select s from #{#entityName} as s where s.status =:status")
//    Iterable<T> findByStatus(@Param("status") Integer status);
}
