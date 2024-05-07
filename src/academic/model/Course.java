package academic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String passinggrade;
    private String academicyear;
    private String semester;
    private String Initial;
    private String grade;
   
    public Course(String code, String name, int credits, String passinggrade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.passinggrade = passinggrade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getPassingGrade() {
        return passinggrade;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public String getSemester() {
        return semester;
    }

    public String getInitial() {
        return Initial;}

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return this.code + "|" + this.name + "|" + this.credits + "|" + this.passinggrade;
    }
}