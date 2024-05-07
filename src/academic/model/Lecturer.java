package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

 
public class Lecturer extends Combination{
    private String email;
    private String initial;
    private String studyProgram;

public Lecturer(String id, String name, String initial, String email, String studyProgram) {
    super(id, name);
    this.initial = initial;
    this.email = email;
    this.studyProgram = studyProgram;
}
    

    public String getId() {
        return id;
    }

    public String getInitial() {
        return initial;
    }

    public String getEmail() {
        return email;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.initial + "|" + this.email + "|" + this.studyProgram;
    }
}