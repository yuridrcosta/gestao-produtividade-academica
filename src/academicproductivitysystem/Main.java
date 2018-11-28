
package academicproductivitysystem;

import static academicproductivitysystem.AcademicProductivitySystem.addOrientation;
import static academicproductivitysystem.AcademicProductivitySystem.addPublication;
import static academicproductivitysystem.AcademicProductivitySystem.generalReport;
import static academicproductivitysystem.AcademicProductivitySystem.listPublications;
import static academicproductivitysystem.AcademicProductivitySystem.manageCollaborators;
import static academicproductivitysystem.AcademicProductivitySystem.manageProjects;
import static academicproductivitysystem.AcademicProductivitySystem.publications;
import static academicproductivitysystem.AcademicProductivitySystem.readMenuOption;
import static academicproductivitysystem.AcademicProductivitySystem.showMainMenu;

public class Main {
    public static void main(String[] args) {
        
        int menuOpt;
        
        System.out.println("-> Bem-vindo ao sistema de gestão de produtividade acadêmica!");
        showMainMenu();
        menuOpt = readMenuOption();
        
        
        while(menuOpt != 0){
            switch(menuOpt){
                case 1:
                    manageCollaborators();
                    break;
                case 2:
                    manageProjects();
                    break;
                case 3:
                    addPublication();
                    break;
                case 5:
                    addOrientation();
                    break;
                case 6:
                    generalReport();
                    break;
                case 4:
                    listPublications(publications);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
            
            showMainMenu();
            menuOpt = readMenuOption();
        }
    }
}
