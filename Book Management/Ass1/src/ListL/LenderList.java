package ListL;

import LMS.Lending;

public class LenderList {
    NodeL head, tail, sorted;
    public LenderList(){
        head=tail=null;
    }
    public void clear(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addFirst(Lending x) {
        if (isEmpty()) {
            head = tail = new NodeL(x);
        } else {
            NodeL q = new NodeL(x);
            q.next = head;
            head = q;
        }
    }
    public void addLast(Lending x) {
        NodeL q = new NodeL(x);
        if(isEmpty()) {
            head=tail=q;
            return;
        }
        tail.next=q;
        tail=q;
    }
    public void traverse(){
        NodeL p=head;
        while(p!=null){
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println();
    }
    public void sortByBCode(){
        NodeL pi, pj;
        Lending t;
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
    public NodeL search(String xCode){
        NodeL p=head;
        while(p!=null){
           if(p.info.getBcode().equals(xCode)) return(p);
            p=p.next;
        }
       return(null);
    }
}
