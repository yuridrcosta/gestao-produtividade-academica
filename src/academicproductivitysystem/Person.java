package academicproductivitysystem;

import java.util.ArrayList;

public class Person {
    private String name;
    private String email;
    ArrayList<Project> projects = new ArrayList<Project>();

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
    
    public void addProject(Project proj){
        this.projects.add(proj);
    }
    
}
