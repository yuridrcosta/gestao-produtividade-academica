
package academicproductivitysystem;

import java.util.ArrayList;

public class Project {
    
    String title;
    int[] startDate = new int[3];
    int[] finishDate = new int [3];
    String fundingAgency;
    float funds;
    String objective;
    String description;
    int status;//1 para "Em elaboração", 2 para "Em andamento" e 3 para "Concluído"
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Professor> professors = new ArrayList<Professor>();
    ArrayList<Researcher> researchers = new ArrayList<Researcher>();
    ArrayList<Publication> publications = new ArrayList<Publication>();
    
    //Obs.: Sempre setar a data de início e de término.
    public Project(String title, String fundingAgency, float funds, String objective, String description) {
        
        this.title = title;
        this.fundingAgency = fundingAgency;
        this.funds = funds;
        this.objective = objective;
        this.description = description;
        
    }

    public Project() {
    }
    
    public String getDescription() {
        return description;
    }

    public float getFunds() {
        return funds;
    }

    public int[] getFinishDate() {
        return finishDate;
    }

    public String getFundingAgency() {
        return fundingAgency;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Researcher> getResearchers() {
        return researchers;
    }

    public String getObjective() {
        return objective;
    }

    public int[] getStartDate() {
        return startDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getTitle() {
        return title;
    }

    public void setFinishDate(int[] finishDate) {
        this.finishDate = finishDate;
    }

    public void setFundingAgency(String fundingAgency) {
        this.fundingAgency = fundingAgency;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setStartDate(int[] startDate) {
        this.startDate = startDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void addPublication(Publication p){
        this.publications.add(p);
    }
    
    public void addStudent(Student st){
        this.students.add(st);
    }
    
    public void addProfessor(Professor prof){
        this.professors.add(prof);
    }
    
    public void addResearcher(Researcher res){
        this.researchers.add(res);
    }
    
    
}
