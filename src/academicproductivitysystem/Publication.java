
package academicproductivitysystem;

import java.util.ArrayList;

public class Publication {
    String title;
    String conference;
    Project associatedProject = null;
    int year;
    public ArrayList<Student> stdAuthors = new ArrayList<Student>();
    public ArrayList<Professor> profAuthors = new ArrayList<Professor>();
    public ArrayList<Researcher> resAuthors = new ArrayList<Researcher>();

    public Publication() {
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public Project getAssociatedProject() {
        return associatedProject;
    }

    public void setAssociatedProject(Project associatedProject) {
        this.associatedProject = associatedProject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    
}
