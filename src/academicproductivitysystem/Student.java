
package academicproductivitysystem;

import java.util.ArrayList;

public class Student extends Person{

    int type;//1 == Aluno de graduação, 2 == Aluno de Mestrado e 3 == Aluno de Doutorado
    public int projs = 0; //Projetos em andamento
    public ArrayList<Publication> publications = new ArrayList<Publication>();

    public Student(String name, String email, int type) {
        super(name,email);
        this.type = type;
    }
    

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setProjs(int projs) {
        this.projs = projs;
    }

    public int getProjs() {
        return projs;
    }
     
    public void addPublication(Publication p){
        this.publications.add(p);
    }      
    
}
