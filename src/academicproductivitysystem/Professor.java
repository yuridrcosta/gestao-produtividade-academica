
package academicproductivitysystem;

import java.util.ArrayList;


public class Professor extends Person{
    
    public ArrayList<Publication> publications = new ArrayList<Publication>();
    public ArrayList<Student> orientations = new ArrayList<Student>();

    public Professor(String name, String email) {
        super(name,email);
    }
    
    public ArrayList<Student> getOrientations() {
        return orientations;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    
    public void addPublication(Publication p){
        this.publications.add(p);
    }
    
    public void addOrientation(Student st){
        this.orientations.add(st);
    }    
}
