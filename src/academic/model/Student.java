package academic.model;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

 public class Student extends Combination{
    private String id;
    private String name; 
    private String angkatan;
    private String initial;
    
public Student(String id, String name, String angkatan, String initial){
    super(id, name);
    this.id = id;
    this.name = name;
    this.angkatan = angkatan;
    this.initial = initial;
} 

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public String getInitial() {
        return initial;
    }
     
    @Override
    public String toString() {
        return super.toString() + "|" + this.angkatan + "|" + this.initial;
    }
}