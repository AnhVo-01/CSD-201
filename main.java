public class main {
    public static void main(String[] args) {
        //Basic
        Person p = new Person("Ha", 20);
        Node x = new Node(p);
        System.out.println("Infor x: "+x.infor);
        System.out.println("-------------------------");
        
        //Node
        Node a, b, c;
        a=new Node(p);
        b=new Node(new Person("Thu", 19), a);
        c=new Node(new Person("Tuan", 20), b);
        System.out.println("Infor c: "+c.infor);
        System.out.println("Infor b: "+c.next.infor);
        System.out.println("Infor a: "+c.next.next.infor);
        
        //danh sach
        String[] name = {"Ha","Binh","Tuan","Ngoc"};
        int[] age = {19,19,20,21};
        MyList t = new MyList();
        t.addLastMany(name, age);
        t.traverse();
        System.out.println();
    }
}
