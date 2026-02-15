package com.keniding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectInfoDTo {
    private String name;
    private String language;
    private int year;
}
