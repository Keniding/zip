package com.keniding.service;

import com.keniding.dto.ProjectInfoDTo;
import com.keniding.model.Project;
import com.keniding.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectInfoDTo createProject(ProjectInfoDTo dto) {
        Project entity = new Project(
                null, dto.getName(), dto.getLanguage(), dto.getYear()
        );

        Project savedEntity = repository.save(entity);

        return new ProjectInfoDTo(
                savedEntity.getName(), savedEntity.getLanguage(), savedEntity.getCreationYear()
        );
    }

    public List<ProjectInfoDTo> getAllProjects() {
        return repository.findAll().stream()
                .map(
                        entity -> new ProjectInfoDTo(
                                entity.getName(), entity.getLanguage(), entity.getCreationYear()
                        )
                ).toList();
    }

    public ProjectInfoDTo getProjectById(Long id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        return new ProjectInfoDTo(project.getName(), project.getLanguage(), project.getCreationYear());

    }

    public ProjectInfoDTo updateProject(Long id, ProjectInfoDTo projectData) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        project.setName(projectData.getName());
        project.setLanguage(projectData.getLanguage());
        project.setCreationYear(projectData.getYear());

        Project updatedProject = repository.save(project);
        return new ProjectInfoDTo(updatedProject.getName(), updatedProject.getLanguage(), updatedProject.getCreationYear());
    }

    public void deleteProject(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Project not found");
        }

        repository.deleteById(id);
    }
}

