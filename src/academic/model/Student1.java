package academic.model;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class Student1 {
    private String id;
    private String name;
    private String angkatan;
    private String initial;
    private double gpa;
    private int totalCredits;

public Student1(String id, String name, String angkatan, String initial, double gpa, int totalCredits) {
    this.id = id;
    this.name = name;
    this.angkatan = angkatan;
    this.initial = initial;
    this.gpa = gpa;
    this.totalCredits = totalCredits;
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAngkatan() {
        return angkatan;
    }
    

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.name + "|" + this.angkatan + "|" + this.initial + "|" + String.format("%.2f", this.gpa) + "|" + this.totalCredits;
    }
}
