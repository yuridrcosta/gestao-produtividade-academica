
package academicproductivitysystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class AcademicProductivitySystem {
    
    public static Scanner read = new Scanner(System.in);
    
    /* Lists of members*/
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Professor> professors = new ArrayList<Professor>();
    public static ArrayList<Researcher> researchers = new ArrayList<Researcher>();
    
    /*Lists of Academic Activities*/
    public static ArrayList<Project> projects = new ArrayList<Project>();
    public static ArrayList<Publication> publications = new ArrayList<Publication>();
    
    public static void showMainMenu(){
        
        System.out.println("[+] Digite o número referente a operação a ser feita:");
        System.out.println("        [1]- Gerenciar colaboradores");
        System.out.println("        [2]- Gerenciar projetos");
        System.out.println("        [3]- Adicionar publicação");
        System.out.println("        [4]- Adicionar orientação");
        System.out.println("        [0]- Sair");
        
    }
    
    public static int readMenuOption(){
        
        int menuOpt;
       
        menuOpt = read.nextInt();
        
        return menuOpt;
       
    }
    
    public static void manageCollaborators(){
        
        String nm;
        String ad;
        int tp;
        int menuOpt;
        
        showCollMenu();
        
        menuOpt = readMenuOption();
        
        switch(menuOpt){
                case 1:
                    
                    nm = read.nextLine();
                    System.out.println("[+] Digite o nome do estudante:");
                    nm = read.nextLine();
                    System.out.println("[+] Digite o email do estudante:");
                    ad = read.nextLine();
                    System.out.println("[+] Digite o tipo do estudante: (inteiro) (1 para ALUNO DE GRADUAÇÃO, 2 para ALUNO DE MESTRADO e 3 para ALUNO DE DOUTORADO)");
                    tp = read.nextInt();
                    
                    Student n = new Student(nm,ad,tp);
                    
                    students.add(n);
                    
                    break;
                case 2:
                    
                    nm = read.nextLine();
                    System.out.println("[+] Digite o nome do professor:");
                    nm = read.nextLine();
                    System.out.println("[+] Digite o email do professor:");
                    ad = read.nextLine();
                    
                    Professor p = new Professor(nm,ad);
                    
                    professors.add(p);
                    
                    break;
                case 3:
                    
                    nm = read.nextLine();
                    System.out.println("[+] Digite o nome do pesquisador:");
                    nm = read.nextLine();
                    System.out.println("[+] Digite o email do pesquisador:");
                    ad = read.nextLine();
                    
                    Researcher r = new Researcher(nm,ad);
                    
                    researchers.add(r);
                    
                    break;
                case 4:
                    
                    System.out.println("[+] Qual o tipo de colaborador? (Digite 1 para ESTUDANTE, 2 para PROFESSOR e 3 para PESQUISADOR");
                    tp = read.nextInt();
                    
                    if(tp == 1){
                        
                        nm = read.nextLine();
                        System.out.println("[+] Digite o nome do estudante:");
                        nm = read.nextLine();
                        
                        Student found = findStudent(nm);
                        
                        students.remove(found);
                        
                    }else if(tp == 2){
                        
                        nm = read.nextLine();
                        System.out.println("[+] Digite o nome do professor:");
                        nm = read.nextLine();
                        
                        Professor prof = findProfessor(nm);
                        
                        professors.remove(prof);
                        
                    }else if(tp == 3){
                        
                        nm = read.nextLine();
                        System.out.println("[+] Digite o nome do pesquisador:");
                        nm = read.nextLine();
                        
                        Researcher res = findResearcher(nm);
                        
                        researchers.remove(res);
                        
                    }else{
                        System.out.println("Desculpe, comando não identificado!");
                    }
                    
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    listProfessors();
                    break;
                case 7:
                    listResearchers();
                    break;
                case 8:
                    System.out.println("Função não disponível");
                    break;
        }            
        
    }
    
    public static void manageProjects(){
        
        int iaux1;
        int menuOpt;
        float faux;
        int[] iaux = new int[3];
        String tt;
        Project foundProject;
        
        showProjMenu();
        
        menuOpt = readMenuOption();
        
        switch(menuOpt){
                case 1:
                    
                    Project proj = new Project();
                    
                    tt = read.nextLine();
                    System.out.println("[+] Digite o título do projeto:");
                    tt = read.nextLine();
                    proj.setTitle(tt);
                    System.out.println("[+] Digite o nome da agência financiadora:");
                    tt = read.nextLine();
                    proj.setFundingAgency(tt);
                    System.out.println("[+] Digite os objetivos:");
                    tt = read.nextLine();
                    proj.setObjective(tt);
                    System.out.println("[+] Digite a descrição:");
                    tt = read.nextLine();
                    proj.setDescription(tt);
                    proj.setStatus(1);
                    System.out.println("[+] Digite a data de início: (FORMATO: dd mm aaaa)");
                    iaux[0] = read.nextInt();
                    iaux[1] = read.nextInt();
                    iaux[2] = read.nextInt();
                    proj.setStartDate(iaux);
                    System.out.println("[+] Digite a data de término: (FORMATO: dd mm aaaa)");
                    iaux[0] = read.nextInt();
                    iaux[1] = read.nextInt();
                    iaux[2] = read.nextInt();
                    proj.setFinishDate(iaux);
                    System.out.println("[+] Digite o valor do financiamento recebido:");
                    faux = read.nextFloat();
                    proj.setFunds(faux);
                    System.out.println("[+] Digite o nome de um professor responsável:");
                    tt = read.nextLine();
                    Professor foundProf = findProfessor(tt);
                    
                    if(foundProf != null){
                        proj.addProfessor(foundProf);
                        foundProf.projects.add(proj);
                    }else{
                        System.out.println("Professor não encontrado! Tente novamente...");
                        tt = read.nextLine();
                        foundProf = findProfessor(tt);
                        if(foundProf != null){
                            proj.addProfessor(foundProf);
                            foundProf.projects.add(proj);
                        }else{
                            System.out.println("Antes de alterar o status de andamento do projeto, adicione um professor responsável");
                        }
                    }
                    
                    System.out.println("[+] Digite 1 se deseja adicionar mais professores:");
                    iaux1 = read.nextInt();
                    if(iaux1 == 1){
                        System.out.println("[+] Digite o nome do professor:");
                        tt = read.nextLine();
                        foundProf = findProfessor(tt);
                        
                        if(foundProf != null){
                            proj.addProfessor(foundProf);
                            foundProf.projects.add(proj);
                        }else{
                            System.out.println("Professor não encontrado");
                        }
                    }
                    
                    projects.add(proj);
                    
                    break;
                case 2:
                    
                    tt = read.nextLine();
                    System.out.println("[+] Digite o título do projeto:");
                    tt = read.nextLine();
                    foundProject = findProject(tt);
                    
                    if(foundProject != null){
                        System.out.println("[+] Digite o número referente ao tipo de colaborador a ser adicionado: (1 para ESTUDANTE, 2 para PROFESSOR e 3 para PESQUISADOR)");
                        iaux1 = read.nextInt();
                        
                        if(iaux1 == 1){
                            System.out.println("[+] Digite o nome do estudante:");
                            tt = read.nextLine();
                            Student foundStudent = findStudent(tt);
                            
                            if(foundStudent != null){
                                if(foundStudent.projs < 2){
                                    foundProject.students.add(foundStudent);
                                    foundStudent.projects.add(foundProject);
                                    if(foundProject.status == 1) foundStudent.projs++;
                                }else if(foundStudent.projs == 2){
                                    if(foundProject.status == 1){
                                        foundProject.students.add(foundStudent);
                                        foundStudent.projects.add(foundProject);
                                    }else{
                                        System.out.println("O aluno não pode entrar no projeto pois já está em 2 projetos em andamento");
                                    }
                                }
                            }else{
                                System.out.println("Estudante não encontrado!");
                            }
                            
                        }else if(iaux1 == 2){
                            System.out.println("[+] Digite o nome do professor:");
                            tt = read.nextLine();
                            Professor foundProfessor = findProfessor(tt);
                            
                            foundProject.professors.add(foundProfessor);
                            foundProfessor.projects.add(foundProject);
                            
                        }else if(iaux1 == 3){
                            System.out.println("[+] Digite o nome do pesquisador:");
                            tt = read.nextLine();
                            Researcher foundResearcher = findResearcher(tt);
                            
                            foundProject.researchers.add(foundResearcher);
                            foundResearcher.projects.add(foundProject);
                            
                        }else{
                            System.out.println("Desculpe, código inválido");
                        }
                        
                    }else{
                        System.out.println("Projeto não encontrado");
                    }
                    
                    break;
                case 3:
                        tt = read.nextLine();
                        System.out.println("[+] Digite o título do projeto:");
                        tt = read.nextLine();
                        foundProject = findProject(tt);
                        
                        if(foundProject.getStatus() == 1){
                            foundProject.setStatus(2);
                            //Aqui iremos retirar os alunos inaptos a continuar no projeto após setar para em andamento
                            Student st = null;
                            for (Iterator<Student> it = foundProject.students.iterator(); it.hasNext();) {
                                st = it.next();
                                if(st.getProjs() == 2){
                                    foundProject.students.remove(st);
                                }else{
                                    st.projs++;
                                }
                            }
                            
                        }else if(foundProject.getStatus() == 2){
                            foundProject.setStatus(3);
                        }else{
                            System.out.println("O projeto foi finalizado");
                        }
                               
                    break;
                case 4:
                    //TODO
                    break;
        }            
        
    }
    
    public static void showCollMenu(){
        
        System.out.println("[+] Digite o número referente a operação a ser feita:");
        System.out.println("        [1]- Adicionar estudante");
        System.out.println("        [2]- Adicionar professor");
        System.out.println("        [3]- Adicionar pesquisador");
        System.out.println("        [4]- Remover colaborador");
        System.out.println("        [5]- Listar estudantes");
        System.out.println("        [6]- Listar professores");
        System.out.println("        [7]- Listar pesquisadores");
        System.out.println("        [8]- Busca detalhada");
        System.out.println("        [0]- Sair");
        
    }
    
    public static void showProjMenu(){
        
        System.out.println("[+] Digite o número referente a operação a ser feita:");
        System.out.println("        [1]- Registrar novo projeto");
        System.out.println("        [2]- Alocar participante");
        System.out.println("        [3]- Alterar status");
        System.out.println("        [4]- Visualizar informações de um projeto");
        System.out.println("        [0]- Sair");
        
    }
    
    
    public static Student findStudent(String name){
        String nm;
        Student st = null;
        int exit = 0;
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {
            st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }
        
        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
    
    public static Professor findProfessor(String name){
        String nm;
        Professor st = null;
        int exit = 0;
        for (Iterator<Professor> it = professors.iterator(); it.hasNext();) {
            st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }
        
        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
    
    public static Researcher findResearcher(String name){
        String nm;
        Researcher st = null;
        int exit = 0;
        for (Iterator<Researcher> it = researchers.iterator(); it.hasNext();) {
            st = it.next();
            nm = st.getName();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }
        
        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
    
    public static Project findProject(String name){
        String nm;
        Project st = null;
        int exit = 0;
        for (Iterator<Project> it = projects.iterator(); it.hasNext();) {
            st = it.next();
            nm = st.getTitle();
            if(nm.equals(name)){
                exit = 1;
                break;
            }
        }
        
        if(exit == 1){
            return st;
        }
        else{
            return null;
        }
    }
    
    public static void listStudents()
    {
        String nm;
        String tp;
        
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {
            Student st = it.next();
            nm = st.getName();
            if(st.getType() == 1){
                tp = "Aluno de Graduação";
            } else if(st.getType()== 2){
                tp = "Aluno de Mestrado";
            }else{
                tp = "Aluno de Doutorado";
            }
           System.out.println("-Nome: " + nm + " Email: " + st.getEmail() + " [" + tp + "]");
        }
    }
    
    public static void listProfessors()
    {
        String nm;
        for (Iterator<Professor> it = professors.iterator(); it.hasNext();) {
            Professor st = it.next();
            nm = st.getName();
           System.out.println("-Nome: " + nm + " Email: " + st.getEmail());
        }
    }
    
    public static void listResearchers()
    {
        String nm;
        for (Iterator<Researcher> it = researchers.iterator(); it.hasNext();) {
            Researcher st = it.next();
            nm = st.getName();
           System.out.println("-Nome: " + nm + " Email: " + st.getEmail());
        }
    }
}

//TODO Consulta específica por colaborador e por projeto
