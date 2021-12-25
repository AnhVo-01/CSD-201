package ListR;

import LMS.Reader;
import java.io.*;

public class ReaderList {
    NodeR head, tail, sorted;
    public ReaderList(){
        head=tail=null;
    }
    public void clear(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addLast(Reader x) {
        NodeR q = new NodeR(x);
        if(isEmpty()) {
            head=tail=q;
            return;
        }
        tail.next=q;
        tail=q;
    }
    public void traverse(){
        NodeR p=head;
        while(p!=null){
            System.out.println(p.info);
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
    
    void remove(NodeR q) {
         if(q==null) return;
         if(q==head){
             removeFirst();
             return;
        } 
        NodeR p=head;
        while(p!=null && p.next!=q) 
            p=p.next;
        if(p==null) return;
        NodeR q1=q.next;
        p.next=q1;
        if (p.next == null) tail = p;
    }
    public void loadFileReader(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s; 
        String []a;
        String rcode; 
        String name;
        int byear;
        while(true) {
            s = br.readLine();
            if(s == null || s.trim().length()<3) break;
            a = s.split("[|]");
            rcode = a[0].trim();
            name = a[1].trim();
            byear = Integer.parseInt(a[2].trim());
            addLast(new Reader(rcode, name, byear));
        }   
        fr.close();
        br.close();
    }
    public void saveFileReader(String fname) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeR p = head;
        while(p!=null) {
            pw.printf("%-4s |  %-9s |  %-3d\r\n",p.info.getRcode(),
                                        p.info.getName(),p.info.getByear());
            p=p.next;
        }
        pw.close();
        fw.close();
    }
    public NodeR search(String xCode){
        NodeR p=head;
        while(p!=null){
            if(p.info.getRcode().equals(xCode)) return(p);
            p=p.next;
        }
       return(null);
    }
    public void dele(String xCode) {
        NodeR q = search(xCode);
        remove(q);
    }
    public void sortByRCode(){
        NodeR pi, pj;
        Reader t;
        for(pi=head; pi!=null; pi=pi.next){
            for(pj=pi.next; pj!=null; pj=pj.next){
                if(pj.info.getRcode().compareTo(pi.info.getRcode())<0){
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }
}
