package com.keniding.controller;

import com.keniding.dto.ProjectInfoDTo;
import com.keniding.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ProjectInfoDTo createProject(@RequestBody ProjectInfoDTo projectInfo) {
        return projectService.createProject(projectInfo);
    }

    @GetMapping
    public List<ProjectInfoDTo> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectInfoDTo getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public ProjectInfoDTo updateProject(@PathVariable Long id, @RequestBody ProjectInfoDTo projectInfo) {
        return projectService.updateProject(id, projectInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Proyecto eliminado correctamente";
    }
}
