package com.keniding.repository;

import com.keniding.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // JpaRepository ya nos da métodos como
// save(), findAll(), findById(), deleteById()
public interface ProjectRepository extends JpaRepository<Project, Long> { }
