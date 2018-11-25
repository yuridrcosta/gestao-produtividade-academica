
package academicproductivitysystem;

import java.util.ArrayList;


public class Professor {
    
    String name;
    String email;
    public ArrayList<Publication> publications = new ArrayList<Publication>();
    public ArrayList<Student> orientations = new ArrayList<Student>();
    public ArrayList<Project> projects = new ArrayList<Project>();

    public Professor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Professor() {
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

    public ArrayList<Student> getOrientations() {
        return orientations;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addPublication(Publication p){
        this.publications.add(p);
    }
    
    public void addOrientation(Student st){
        this.orientations.add(st);
    }
    
    public void addProject(Project proj){
        this.projects.add(proj);
    }
    
}
