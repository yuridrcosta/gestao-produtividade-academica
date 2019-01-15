
package academicproductivitysystem;

import java.util.ArrayList;

public class Researcher extends Person{
    
    public ArrayList<Publication> publications = new ArrayList<Publication>();

    public Researcher(String name, String email) {
        super(name,email);
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }
    
    public void addPublication(Publication p){
        this.publications.add(p);
    } 
    
}
