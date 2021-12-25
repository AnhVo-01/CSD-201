
// file:///C:/Users/anhvo/Desktop/Daily%20work/CSD201/CSD201_learning_website/assignments/1.1.book.html

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu m = new Menu();
        Manage mn = new Manage();
        while (true) {
            int choice = m.mainMenu();

            if (choice == 0) {
                System.out.println("EXITING THE PROGRAM . . .");
                System.exit(0);
                break;
            }
            switch (choice) {
            //Book-------------------------------------------------------
                case 1:
                    while (true) {
                        int choiceB = m.Book();

                        if (choiceB == 0) {
                            break;
                        }
                        switch (choiceB) {
                            case 1:
                                mn.loadFileB();
                                break;
                            case 2:
                                mn.input();
                                break;
                            case 3:
                                mn.inOrder();
                                break;
                            case 4:
                                mn.Breadth();
                                break;
                            case 5:
                                mn.saveInOrder();
                                break;
                            case 6:
                                mn.searchByBCode();
                                break;
                            case 7:
                                mn.deleByBCode();
                                break;
                            case 8:
                                mn.simplyBalance();  
                                break;
                            case 9:
                                mn.numberOfBook();
                                break;
                        }
                    }
                    break;
            //Reader-----------------------------------------------------  
                case 2:
                    while (true) {
                        int choiseR = m.Reader();

                        if (choiseR == 0) {
                            break;
                        }
                        switch(choiseR) {
                            case 1:
                                mn.loadFileR();
                                break;
                            case 2:
                                mn.addEnd(); 
                                break;
                            case 3:
                                mn.display();
                                break;
                            case 4:
                                mn.saveList();
                                break;
                            case 5:
                                mn.searchByRCode();    
                                break;
                            case 6: 
                                mn.deleByRCode();
                                break;
                        }
                    }
                    break;
                //Order---------------------------------------------------------
                case 3:
                    while (true) {
                        int choiseL = m.Lending();

                        if (choiseL == 0) {
                            break;
                        }
                        switch (choiseL) {
                            case 1:
                                mn.inputData();
                                break;
                            case 2:
                                mn.printData();
                                break;
                            case 3:
                                mn.sort();
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
