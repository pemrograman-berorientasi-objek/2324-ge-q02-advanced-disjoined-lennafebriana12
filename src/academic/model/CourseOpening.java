package academic.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class CourseOpening {
    
    private String course_code;
    private String academicyear;
    private String semester;
    private String string;
  
    
    public CourseOpening(String course_code,String academicyear,String semester, String string) {
        this.course_code = course_code;
        this.academicyear = academicyear;
        this.semester = semester;
        this.string = string;
    }
   
    public String getCourse_Code() {
        return course_code;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public String getSemester() {
        return semester;
    }

    public String getString() {
        return string;
    }

    public String string(String string) {
        return this.string;
    }

    public void setCourseCode(String course_code) {
        this.course_code = course_code;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return this.course_code + "|" + this.academicyear + "|" + this.semester +  "|" + this.string;
    }
}