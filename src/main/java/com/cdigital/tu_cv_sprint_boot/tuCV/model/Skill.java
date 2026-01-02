package com.cdigital.tu_cv_sprint_boot.tuCV.model;

import lombok.Data;

@Data
public class Skill {
    private String name;
    private String level;//Optional: could be "Basic", "Intermediate", "Advanced" or a percentage
}
