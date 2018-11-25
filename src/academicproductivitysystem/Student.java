
package academicproductivitysystem;

import java.util.ArrayList;

public class Student {
    String name;
    String email;
    int type;//1 == Aluno de graduação, 2 == Aluno de Mestrado e 3 == Aluno de Doutorado
    public int projs = 0; //Projetos em andamento
    public ArrayList<Project> projects = new ArrayList<Project>();
    public ArrayList<Publication> publications = new ArrayList<Publication>();

    public Student(String name, String email, int type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public Student() {
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public void addProject(Project proj){
        this.projects.add(proj);
    }
    
    
}
