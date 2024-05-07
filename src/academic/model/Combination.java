package academic.model;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class Combination{
    
    protected String id;
    protected String name;

    public Combination(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.id + "|" + this.name;
    }
} 
