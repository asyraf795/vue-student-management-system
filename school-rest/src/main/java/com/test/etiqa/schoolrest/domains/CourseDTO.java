package com.test.etiqa.schoolrest.domains;

import java.util.List;

public class CourseDTO {
    private int id;

    private String title;

    private String abbreviation;

    List<Integer> studentIDs;

    public CourseDTO() {
    }

    public CourseDTO(int id, String title, String abbreviation) {
        this.id = id;
        this.title = title;
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Integer> getStudentIDs() {
        return studentIDs;
    }

    public void setStudentIDs(List<Integer> studentIDs) {
        this.studentIDs = studentIDs;
    }
}
