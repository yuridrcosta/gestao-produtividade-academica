
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
        System.out.println("        [4]- Listar publicações");
        System.out.println("        [5]- Adicionar orientação");
        System.out.println("        [6]- Relatório geral");
        System.out.println("        [0]- Sair");
        
    }
    
    public static int readMenuOption(){
        
        int menuOpt;
       
        menuOpt = read.nextInt();
        
        return menuOpt;
       
    }
    /* INÍCIO do menu de gerenciamento de Colaboradores*/
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
                        System.out.println("ERRO: Desculpe, comando não identificado!");
                    }
                    
                    break;
                case 5:
                    listStudents(students,true);
                    break;
                case 6:
                    listProfessors(professors,true);
                    break;
                case 7:
                    listResearchers(researchers,true);
                    break;
        }            
        
    }
    /* FIM do menu de gerenciamento de Colaboradores*/
    /* INÍCIO do menu de gerenciamento de Projetos*/
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
                    tt = read.nextLine();
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
                            System.out.println("Professor não encontrado! Antes de alterar o status de andamento do projeto, adicione um professor responsável");
                        }
                    }
                    
                    System.out.println("[+] Digite 1 se deseja adicionar mais professores, 0 caso não deseje:");
                    iaux1 = read.nextInt();
                    if(iaux1 == 1){
                        
                        tt = read.nextLine();
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
                            tt = read.nextLine();
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
                                        System.out.println("ERRO: O aluno não pode entrar no projeto pois já está em 2 projetos em andamento");
                                    }
                                }
                            }else{
                                System.out.println("ERRO: Estudante não encontrado!");
                            }
                            
                        }else if(iaux1 == 2){
                            tt = read.nextLine();
                            System.out.println("[+] Digite o nome do professor:");
                            tt = read.nextLine();
                            Professor foundProfessor = findProfessor(tt);
                            
                            if(foundProfessor != null){
                                foundProject.professors.add(foundProfessor);
                                foundProfessor.projects.add(foundProject);
                            }else{
                                System.out.println("ERRO: Professor não encontrado!");
                            }
                            
                        }else if(iaux1 == 3){
                            tt = read.nextLine();
                            System.out.println("[+] Digite o nome do pesquisador:");
                            tt = read.nextLine();
                            Researcher foundResearcher = findResearcher(tt);
                            
                            foundProject.researchers.add(foundResearcher);
                            foundResearcher.projects.add(foundProject);
                            
                        }else{
                            System.out.println("ERRO: Desculpe, código inválido");
                        }
                        
                    }else{
                        System.out.println("ERRO: Projeto não encontrado");
                    }
                    
                    break;
                case 3:
                        tt = read.nextLine();
                        System.out.println("[+] Digite o título do projeto:");
                        tt = read.nextLine();
                        foundProject = findProject(tt);
                        
                        if(foundProject != null && foundProject.getStatus() == 1){
                            foundProject.setStatus(2);
                            //Aqui iremos retirar os alunos inaptos a continuar no projeto após setar para em andamento
                            if(foundProject.professors.size()>0){
                                Student st = null;
                                for (Iterator<Student> it = foundProject.students.iterator(); it.hasNext();) {
                                    st = it.next();
                                    if(st.getProjs() == 2){
                                        foundProject.students.remove(st);
                                    }else{
                                        st.projs++;
                                    }
                                }
                            }else{
                                System.out.println("ERRO: Você deve cadastrar pelo menos um professor responsável pelo projeto");
                            }
                        }else if(foundProject!= null && foundProject.getStatus() == 2){
                            if(foundProject.publications.size()>0){
                                foundProject.setStatus(3);
                            }else{
                                System.out.println("ERRO: O projeto deve ter pelo menos uma publicação associada para passar ao status de concluído");
                            }
                        }else{
                            System.out.println("ERRO: O projeto foi finalizado");
                        }
                               
                    break;
                case 4:
                    //Busca detalhada do projeto
                    tt = read.nextLine();
                    System.out.println("[+] Digite o título do projeto:");                   
                    tt = read.nextLine();
                    foundProject = findProject(tt);
                    int[] dates = new int[3];
                    
                    if(foundProject != null){
                        String status;
                        System.out.println("        Título: " + foundProject.getTitle());
                        System.out.println("        Objetivos: " + foundProject.getObjective());
                        System.out.println("        Descrição: " + foundProject.getDescription());
                        System.out.println("        Agência Financiadora: " + foundProject.getFundingAgency());
                        System.out.println("        Financiamento recebido: R$" + foundProject.getFunds());
                        if(foundProject.getStatus() == 1){
                            status = "Em elaboração";
                        }else if(foundProject.getStatus() == 2){
                            status = "Em andamento";
                        }else{
                            status = "Concluído";
                        }
                        System.out.println("        Estado do projeto: " + status);
                        dates = foundProject.getStartDate();
                        System.out.println("        Data de início: " + dates[0] +"/"+dates[1]+"/"+dates[2]);
                        dates = foundProject.getFinishDate();
                        System.out.println("        Data de término: " + dates[0] +"/"+dates[1]+"/"+dates[2]);
                        System.out.println("        Estudantes associados:");
                        listStudents(foundProject.students,false);
                        System.out.println("        Professores associados:");
                        listProfessors(foundProject.professors,false);
                        System.out.println("        Pesquisadores associados:");
                        listResearchers(foundProject.researchers,false);
                        System.out.println("        Publicações associadas:");
                        listPublications(foundProject.publications);
                        
                    }else{
                        System.out.println("ERRO: Desculpe, projeto não encontrado");
                    }
                    
                    
                    break;
        }            
        
    }
    /* FIM do menu de gerenciamento de Projetos*/
    /* INÍCIO do método de adicionar publicações*/
    public static void addPublication(){
        
            String saux;//Auxiliar para strings
            int iaux;
            Publication newPub = new Publication();
            
            saux = read.nextLine();
            System.out.println("[+] Digite o nome do título da publicação:");
            saux = read.nextLine();
            newPub.setTitle(saux);
            System.out.println("[+] Digite o nome da conferência onde foi publicado:");
            saux = read.nextLine();
            newPub.setConference(saux);
            System.out.println("[+] Digite o ano da publicação:");
            iaux = read.nextInt();
            newPub.setYear(iaux);
            saux = read.nextLine();
            System.out.println("[+] Digite o nome do projeto associado, se não houver projeto associado, digite 0:");
            saux = read.nextLine();
            
            Project foundProject = findProject(saux);
            
            if(foundProject != null){
                
                if(foundProject.getStatus() == 2){
                    newPub.setAssociatedProject(foundProject);
                    foundProject.publications.add(newPub);
                }else{
                    System.out.println("ERRO: O projeto está em fase de elaboração e portanto não pode ter publicações associadas");
                }
                
            }else{
                System.out.println("ERRO: Projeto não encontrado!");
            }
            
            System.out.println("[+] Digite 1 para adicionar um autor ESTUDANTE, 2 para um autor PROFESSOR e 3 para um autor PESQUISADOR:");
            iaux = read.nextInt();
            
            while(iaux != 0){
                saux = read.nextLine();
                if(iaux == 1){
                    System.out.println("[+] Digite o nome do estudante:");
                    saux = read.nextLine();
                    Student foundStudent = findStudent(saux);
                    
                    if(foundStudent != null){
                        newPub.stdAuthors.add(foundStudent);
                        foundStudent.publications.add(newPub);
                    }else{
                        System.out.println("ERRO: Estudante não encontrado");
                    }
                }else if(iaux == 2){
                    System.out.println("[+] Digite o nome do professor:");
                    saux = read.nextLine();
                    Professor foundProfessor = findProfessor(saux);
                    
                    if(foundProfessor != null){
                        newPub.profAuthors.add(foundProfessor);
                        foundProfessor.publications.add(newPub);
                    }else{
                        System.out.println("ERRO: Professor não encontrado");
                    }
                }else{
                    System.out.println("[+] Digite o nome do pesquisador:");
                    saux = read.nextLine();
                    Researcher foundResearcher = findResearcher(saux);
                    
                    if(foundResearcher != null){
                        newPub.resAuthors.add(foundResearcher);
                        foundResearcher.publications.add(newPub);
                    }else{
                        System.out.println("ERRO: Pesquisador não encontrado");
                    }
                }
                
                
                System.out.println("[+] Se desejar adicionar mais autores, digite o número correspondente ao tipo de autor, se não, digite 0:");
                iaux = read.nextInt();
            }
            publications.add(newPub);
    }
    /* FIM do método de adicionar publicações*/
    /* INÍCIO do método de adicionar orientações*/
    
    public static void addOrientation(){
        
        String saux; //Auxiliar para strings
        String saux2;
        saux = read.nextLine();
        System.out.println("[+] Digite o nome do professor orientador:");
        saux = read.nextLine();
        Professor foundProfessor = findProfessor(saux);
        
        if(foundProfessor != null){
            System.out.println("[+] Digite o nome do estudante orientado:");
            saux2 = read.nextLine();
            Student foundStudent = findStudent(saux2);
            if(foundStudent != null){
                foundProfessor.orientations.add(foundStudent);
            }else{
                System.out.println("ERRO: Estudante não encontrado!");
            }
        }else{
            System.out.println("ERRO: Professor não encontrado!");
        }
        
    }
    /* FIM do método de adicionar orientações*/
    /* INÍCIO do método de gerar relatórios gerais*/
    public static void generalReport(){
        System.out.printf("    ->Número de colaboradores: %d",(students.size()+professors.size()+researchers.size()));
        int inPrep = 0;
        int inProg = 0;
        int finished = 0;
        int totalOri = 0;
        for(Iterator<Project> it = projects.iterator(); it.hasNext();){
            Project proj = it.next();
            if(proj.getStatus() == 1){
                inPrep++;
            }else if(proj.getStatus() == 2){
                inProg++;
            }else{
                finished++;
            }
        }
        System.out.println("    ->Número de projetos em elaboração: "+inPrep);
        System.out.println("    ->Número de projetos em andamento: "+inProg);
        System.out.println("    ->Número de projetos concluídos: "+finished);
        System.out.println("    ->Número total de projetos: "+projects.size());
        System.out.println("    ->Número de produção acadêmica por tipo de produção: ");
        System.out.println("        Publicações:"+publications.size());
        for(Iterator<Professor> it = professors.iterator(); it.hasNext();){
            Professor prof = it.next();
            totalOri += prof.orientations.size();
        }
        System.out.println("        Orientações:"+totalOri);
    }
    /* FIM do método de gerar relatórios gerais*/
    public static void showCollMenu(){
        
        System.out.println("[+] Digite o número referente a operação a ser feita:");
        System.out.println("        [1]- Adicionar estudante");//OK
        System.out.println("        [2]- Adicionar professor");//OK
        System.out.println("        [3]- Adicionar pesquisador");//OK
        System.out.println("        [4]- Remover colaborador");//OK
        System.out.println("        [5]- Listar estudantes");//TODO Detalhar mais
        System.out.println("        [6]- Listar professores");//TODO Detalhar
        System.out.println("        [7]- Listar pesquisadores");//TODO Detalhar
        System.out.println("        [0]- Sair");
        
    }
    
    public static void showProjMenu(){
        
        System.out.println("[+] Digite o número referente a operação a ser feita:");
        System.out.println("        [1]- Registrar novo projeto");
        System.out.println("        [2]- Alocar participante");
        System.out.println("        [3]- Alterar status");
        System.out.println("        [4]- Busca detalhada em projeto");
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
    
    public static void listStudents(ArrayList<Student> sts, boolean details)
    {
        String nm;
        String tp;
        
        for (Iterator<Student> it = sts.iterator(); it.hasNext();) {
            Student st = it.next();
            nm = st.getName();
            if(st.getType() == 1){
                tp = "Aluno de Graduação";
            } else if(st.getType()== 2){
                tp = "Aluno de Mestrado";
            }else{
                tp = "Aluno de Doutorado";
            }
           System.out.println("     [*]Nome: " + nm + " Email: " + st.getEmail() + " [" + tp + "]");
           
           if(details == true){
               System.out.println("     Projetos: ");
               listProjects(st.projects,false);
               System.out.println("     Publicações: ");
               listPublications(st.publications);
           }
        }
    }
    
    public static void listProfessors(ArrayList<Professor> prof, boolean details)
    {
        String nm;
        for (Iterator<Professor> it = prof.iterator(); it.hasNext();) {
            Professor st = it.next();
            nm = st.getName();
           System.out.println("     [*]Nome: " + nm + " Email: " + st.getEmail());
           
           if(details == true){
               System.out.println("     Projetos: ");
               listProjects(st.projects,false);
               System.out.println("     Publicações: ");
               listPublications(st.publications);
               System.out.println("     Orientações: ");
               listStudents(st.orientations,false);
           }
        }
    }
    
    public static void listResearchers(ArrayList<Researcher> res,boolean details)
    {
        String nm;
        for (Iterator<Researcher> it = res.iterator(); it.hasNext();) {
            Researcher st = it.next();
            nm = st.getName();
           System.out.println("     [*]Nome: " + nm + " Email: " + st.getEmail());
           if(details == true){
               System.out.println("     Projetos: ");
               listProjects(st.projects,false);
               System.out.println("     Publicações: ");
               listPublications(st.publications);
           }
        }
    }
    
    public static void listProjects(ArrayList<Project> projs,boolean details){
        for (Iterator<Project> it = projs.iterator(); it.hasNext();){
            Project pj = it.next();
            
            System.out.println("        ->Título: "+ pj.getTitle());
            
            if(details == true){
                System.out.println("        Alunos associados:");
                listStudents(pj.students,false);
                System.out.println("        Professores associados:");
                listProfessors(pj.professors,false);
                System.out.println("        Pesquisadores associados:");
                listResearchers(pj.researchers,false);
                System.out.println("        Publicações associadas:");
                listPublications(pj.publications);
            }
        }
    }
    
    public static void listPublications(ArrayList<Publication> publ){
        for (Iterator<Publication> it = publ.iterator(); it.hasNext();){
            Publication pj = it.next();
            
            System.out.println("        ->Título: "+ pj.getTitle());
            System.out.println("        ->Conferência: "+pj.getConference());
            System.out.println("        ->Ano: "+ pj.getYear());
            System.out.print("        ->Autores:");
            for (Iterator<Student> it2 = pj.stdAuthors.iterator(); it2.hasNext();){
                Student std = it2.next();
            
                System.out.print(" "+ std.getName()+",");
            
            }
            for (Iterator<Professor> it3 = pj.profAuthors.iterator(); it3.hasNext();){
                Professor prof = it3.next();
            
                System.out.print(" "+ prof.getName()+",");
            
            } 
            for (Iterator<Researcher> it4 = pj.resAuthors.iterator(); it4.hasNext();){
                Researcher res = it4.next();
            
                System.out.print(" "+ res.getName()+",");
            
            } 
            System.out.println("");
        }
    }
            
}
