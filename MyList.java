//Singly-LinkedList
public class MyList {
    Node head, tail;
    MyList(){
        head=tail=null;
    }
    void clear(){
        head=tail=null;
    }
    boolean isEmpty(){
        return head==null;
    }
    //chen vao duoi
    void addLast(Person x){
        //chen duoi
        Node p = new Node(x);
        
        //1. DS rong
        if (isEmpty()){
            head=tail=p;
        }
        //2. DS da co phan tu
        tail.next=p;
        tail=p;
    }
    // nhieu phan tu vao cuoi
    void addLastMany(String[] name, int[]age){
        for (int i=0; i<name.length; i++){
            addLast(new Person(name[i], age[i]));
        }
    }
    //visit - thăm đứa thông tin của node(info)
    void visit(Node p){
        if (p!=null){
            System.out.println(p.infor+" ");
        }
    }
    //traverse - duyet - thăm cả DSLK
    void traverse(){
        Node p=head;
        while(p!=null)
         {visit(p);
           p=p.next;
         }
      System.out.println();
    }
    void addMany(String [] a, int [] b)
     {int n,i; n=a.length;
       for(i=0;i<n;i++) addLast(new Person(a[i],b[i]));
     }
}
