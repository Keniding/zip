package com.keniding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInfoDTo {
    private String name;
    private String language;
    private int year;
}
