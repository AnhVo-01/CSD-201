package BList;
    
import LMS.Book;
import java.io.*;

public class BookList {
    NodeB head, tail, sorted;
    public BookList(){
        head=tail=null;
    }
    public void clear(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    
    // Add to head of lineked list
    public void addFirst(Book x) {
        if (isEmpty()) {
            head = tail = new NodeB(x);
        } else {
            NodeB q = new NodeB(x);
            q.next = head;
            head = q;
        }
    }
    public void addLast(Book x) {
        NodeB q = new NodeB(x);
        if(isEmpty()) {
            head=tail=q;
            return;
        }
        tail.next=q;
        tail=q;
    }
    
    public void traverse(){
        NodeB p=head;
        while(p!=null){
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println();
    }
    
    public void printData(){
        NodeB p=head;  
        while(p!=null){
            Book b = p.info;
            b.display();
            p = p.next;    
        }
        System.out.println();
    }
    
    void removeFirst(){
        if(isEmpty()) return;
        head=head.next;
        //DSLK co 1 phan tu va da bi xoa
        if(head==null)
            tail=null;
    }
    
    void remove(NodeB q) {
         if(q==null) return;
         if(q==head){
             removeFirst();
             return;
        } 
        NodeB p=head;
        while(p!=null && p.next!=q) 
            p=p.next;
        if(p==null) return;
        NodeB q1=q.next;
        p.next=q1;
        if (p.next == null) tail = p;
    }
    public void insertAfter(NodeB q, Book x){
        if(q==null) return;
        //phan tu sau q
        NodeB q1=q.next;
        NodeB p=new NodeB(x, q1);
        //noi q vao p
        q.next = p;
        //neu q la duoi
        if(q==tail)
            tail=p;
    }
    public NodeB pos(int k) {
        int i=0;
        NodeB p=head;
        while(p!=null){
            if(i==k) return(p);
            p=p.next;
            i++;
        }
        return(null);
    }
    public void removePos(int k){
        NodeB p=pos(k);
        remove(p);
    }
    
    public void loadFileBook(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s; 
        String []a;
        String bcode; 
        String title;
        int quantity; double price;
        while(true) {
            s = br.readLine();
            if(s == null || s.trim().length()<4) break;
            a = s.split("[|]");
            bcode = a[0].trim();
            title = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());
            price = Double.parseDouble(a[3].trim());
            addLast(new Book (bcode, title, quantity, 0, price));
        }   
        fr.close();
        br.close();
    }
    
    public void saveFileBook(String fname) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeB p = head;
        while(p!=null) {
            pw.printf("%-4s |  %-9s |  %-3d |  %-10.1f\r\n",p.info.getBcode(),
                                        p.info.getTitle(),p.info.getQuantity(),
                                        p.info.getPrice());
            p=p.next;
        }
        pw.close();
        fw.close();
    }
    
    public NodeB search(String xCode){
        NodeB p=head;
        while(p!=null){
           if(p.info.getBcode().equals(xCode)) return(p);
            p=p.next;
        }
       return(null);
    }
    
    public void dele(String xCode) {
        NodeB q = search(xCode);
        remove(q);
    }
    
    public void sortByBCode(){
        NodeB pi, pj;
        Book t;
        for(pi=head; pi!=null; pi=pi.next){
            for(pj=pi.next; pj!=null; pj=pj.next){
                if(pj.info.getBcode().compareTo(pi.info.getBcode())<0){
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }
    // sort linked list
//    public void sort() {
//        sorted = null;
//        NodeB p = head;
//
//        while (p != null) {
//            NodeB next = p.next;
//            if (sorted == null || sorted.info.compareTo(p.info) <= 0) {
//                p.next = sorted;
//                sorted = p;
//            } else {
//                NodeB q = sorted;
//            /* Locate the node before the point of insertion */
//                while (q.next != null && q.next.info.compareTo(p.info) > 0){
//                    q = q.next;
//            }   
//            p.next = q.next;
//            q.next = p;
//        }
//            p = next;
//        }
//        head = sorted;
//    }
}
