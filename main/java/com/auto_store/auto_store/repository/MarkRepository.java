package com.auto_store.auto_store.repository;

import com.auto_store.auto_store.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    List<Mark> findAll();
}
