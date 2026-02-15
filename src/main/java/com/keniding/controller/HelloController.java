package com.keniding.controller;

import com.keniding.dto.ProjectInfoDTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/project-info")
    public ProjectInfoDTo getProjectInfo() {
        return new ProjectInfoDTo("Demo Spring Boot", "Java 17", 2026);
    }

    @PostMapping("/projects")
    public ProjectInfoDTo createProject(@RequestBody ProjectInfoDTo newProject) {
        log.info("Nuevo proyecto recibido: {}", newProject.getName());
        return newProject;
    }

    @PutMapping("/projects/{id}")
    public String updateProject(@PathVariable int id, @RequestBody ProjectInfoDTo projectData) {
        return "El proyecto con ID " + id + " ha sido actualizado con el nombre: " + projectData.getName();
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
        return "Proyecto " + id + " eliminado correctamente";
    }
}
