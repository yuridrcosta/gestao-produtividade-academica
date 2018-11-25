
package academicproductivitysystem;

import java.util.ArrayList;

public class Researcher {
    
    String name;
    String email;
    public ArrayList<Publication> publications = new ArrayList<Publication>();
    public ArrayList<Project> projects = new ArrayList<Project>();

    public Researcher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Researcher() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addPublication(Publication p){
        this.publications.add(p);
    }
    
    public void addProject(Project proj){
        this.projects.add(proj);
    }
    
}
