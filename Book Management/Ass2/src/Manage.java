
import LMS.Book;
import LMS.Reader;
import LMS.Lending;
import BTree.*;
import ListL.*;
import ListR.*;
import java.io.IOException;

public class Manage {
    BookTree bt = new BookTree();
    ReaderList rl = new ReaderList();
    LenderList ll = new LenderList();
//Book-------------------------------------------------------------------------
    //(1)-------------------------------
    void loadFileB() throws IOException{
        bt.clear();
        System.out.print("Enter file name: ");
        String fname = Validate.checkInputPathFile();
        bt.loadFile(fname);
    }
    //(2)-------------------------------
    void input(){      
        System.out.print("Enter book code: ");
        String bcode = Validate.checkInputString();
        NodeB p = bt.search(bcode);
        if(p!=null){
            System.err.println("This code is duplicate");
            return;
        }
        System.out.print("Enter book name: ");
        String bname = Validate.checkInputString();
        System.out.print("Enter quantity: ");
        int quantity = Validate.checkInputInt();
        System.out.print("Enter price: ");
        double price = Validate.checkInputDouble();
        
        bt.insert(new Book(bcode, bname, quantity, 0, price));
//        bt.traverse();
    }
    //(3)-------------------------------
    void inOrder(){
        bt.inOrder(bt.root);
    }
    //(4)-------------------------------
    void Breadth(){
        bt.breadth(bt.root);
    }
    //(5)-------------------------------
    void saveInOrder() throws IOException{
        bt.saveFileInOrder("Book_re.txt");
    }
    //(6)-------------------------------
    void searchByBCode() {
        System.out.print("Enter Bcode: ");
        String code = Validate.checkInputString();
        NodeB p = bt.search(code);
        if(p!=null){  
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }
    //(7)-------------------------------
    void deleByBCode(){
        System.out.print("Enter Bcode: ");
        String code = Validate.checkInputString();
        bt.deleByCopy(code);
    }     
    //(8)-------------------------------
    void simplyBalance(){
        bt.simpBalance(bt.root);
    }
    //(9)-------------------------------
    void numberOfBook() {
        System.out.print("Number of books: "+bt.count(bt.root));  
    }

//Reader-----------------------------------------------------------------------
    void loadFileR() throws IOException{
        rl.clear();
        System.out.print("Enter file name: ");
        String fname = Validate.checkInputString();
        rl.loadFileReader(fname);
    }
    //(2)-------------------------------
    void addEnd(){
        System.out.print("Enter rcode: ");
        String rcode = Validate.checkInputString();
        NodeR p = rl.search(rcode);
        if(p!=null){
            System.err.println("This code is duplicate");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter byear: ");
        int byear = Validate.checkInputInt();
        
        rl.addLast(new Reader(rcode, name, byear));
        rl.traverse();
    }
    //(3)-------------------------------
    void display(){
        rl.traverse();
    }
    //(4)-------------------------------
    void saveList() throws IOException{
        rl.saveFileReader("Reader_rep.txt");
    }
    //(5)-------------------------------
    void searchByRCode() {
        NodeR p = rl.search(Validate.checkInputString());
        if(p==null){
            System.out.println("not found");
        }else{
            System.out.println("found");
        }
    }
    //(6)-------------------------------
    void deleByRCode(){
        rl.dele(Validate.checkInputString());
    } 
    
//Lending----------------------------------------------------------------------
    Book b = new Book();
//(1)-------------------------------
    void inputData() throws IOException{ 
        ll.clear();
        bt.loadFile("Book.txt");     
        // check bcode in the books list
        System.out.print("Enter book code: ");
        String bcode = Validate.checkInputString();
        if(bt.search(bcode)==null){
            System.err.println("not accepted");
            return;
        }
        rl.loadFileReader("Reader.txt");
        // check bcode in the books list
        System.out.print("Enter reader code: ");
        String rcode = Validate.checkInputString();
        if(rl.search(rcode)==null){
            System.err.println("not accepted");
            return;
        }
        System.out.print("Enter state: ");
        int state = Validate.checkInputInt();
        if(state == 1){
            System.err.println("not accepted");
            return;
        }
        if(b.getLended()== b.getQuantity() && state == 0){
            ll.addLast(new Lending(bcode, rcode, state));
        }
        if(b.getLended()== b.getQuantity() && state == 1){
//            b.lended+=1;
            ll.addLast(new Lending(bcode, rcode, state));
        }  
    }
//(2)-------------------------------
    void printData() {
        ll.traverse();
    }
//(3)-------------------------------
    void sort() {   
        System.out.println("1. Sort by bcode");
        System.out.println("2. Sort by rcode");
//        int choice = Validate.checkInputInt();
//        switch(choice){
//            case 1:                   
//                bt.sortByBCode();
//                bt.traverse();
//                break;
//            case 2:                   
//                rl.sortByRCode();
//                rl.traverse();
//                break;           
//        }
    } 
}
