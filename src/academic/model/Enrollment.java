package academic.model;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class Enrollment {
    private String courseId;
    private String studentId;
    private String academicyear;
    private String semester;
    private String grade;
    private String back;
    private String remedial;
    private int remedialCount;

    public Enrollment(String courseId, String studentId,String academicyear, String semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicyear = academicyear;
        this.semester = semester;
        this.grade = grade ;
        this.back = "";
        this.remedial = null;
        this.remedialCount = 0;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public void setGradeValue(String grade) {
        this.grade = grade;
    }

    public String getGradeValue() {
        return this.grade;
    }

    public String getPreviousGrade() {
        return this.grade;
    }
    public void setPreviousGrade(String grade) {
        this.grade = grade;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getRemedial() {
        return remedial;
    }

    public void setRemedial(String remedial) {
        this.remedial = remedial;
    }

    public int getRemedialCount() {
        return remedialCount;
    }

    public void setRemedialCount() {
        this.remedialCount += 1;
    }

    public void addRemedialCount() {
        this.remedialCount++;
    }

    public void resetRemedialCount() {
        this.remedialCount = 0;
    }

    public void resetRemedial() {
        this.remedial = null;
    }

    public void resetBack() {
        String temp = "";
        temp = this.grade;
        this.grade = this.back;
        this.back = temp;
    }   
}