package com.cdigital.tu_cv_sprint_boot.tuCV.model;

import lombok.Data;

import java.util.List;

@Data
public class CvData {
    private PersonalDetails personalDetails;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Skill> skills;
}