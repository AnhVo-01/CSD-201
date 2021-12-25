public class Menu {
    public int mainMenu(){
        System.out.println("===== MAIN MENU =====");
        System.out.println(" 1. Book list\n"
                         + " 2. Reader list\n"
                         + " 3. Lending list\n"
                         + " 0. Exit program");
        System.out.println("---------------------");
        System.out.print("Enter your choice: ");       
        int choise = Validate.checkInputLimited(0, 3);
        return choise;
    }
//--------------------------------------------------------------- 
    
    public int Book() {
        System.out.println("\n---------- Book List ----------");
        System.out.print(" 1.  Load data from file\n"
                       + " 2.  Input & add to the end\n"
                       + " 3.  Display data\n"
                       + " 4.  Save book list to file\n"
                       + " 5.  Search by bcode\n"
                       + " 6.  Delete by bcode\n"
                       + " 7.  Sort by bcode\n"
                       + " 8.  Input & add to beginning\n"
                       + " 9.  Add after position k\n"
                       + " 10. Delete position k\n"
                       + " 0.  Exit to main menu\n");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");
        int choise = Validate.checkInputLimited(0, 10);
        return choise;
    }
//---------------------------------------------------------------
    
    public int Reader() {
        System.out.println("\n--------- Reader List ---------");
        System.out.print(" 1.  Load data from file\n"
                       + " 2.  Input & add to the end\n"
                       + " 3.  Display data\n"
                       + " 4.  Save reader list to file\n"
                       + " 5.  Search by rcode\n"
                       + " 6.  Delete by rcode\n"
                       + " 0.  Exit to main menu\n");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");
        int choise = Validate.checkInputLimited(0, 6);
        return choise;
    }
//---------------------------------------------------------------
    
    public int Lending() {
        System.out.println("\n------ Lending List ------");
        System.out.print(" 1. Input data\n"
                       + " 2. Display data\n"
                       + " 3. Sort by bcode + rcode\n"
                       + " 0. Exit to main menu\n");
        System.out.println("--------------------------");
        System.out.print("Enter your choice: ");
        int choise = Validate.checkInputLimited(0, 3);
        return choise;
    }
}
