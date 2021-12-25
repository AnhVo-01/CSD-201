package BTree;

import LMS.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookTree {
    public NodeB root;
    public BookTree() {
        root = null;
    }
    public void clear() {
        root = null;
    }
    public boolean isEmpty() {
        return (root == null);
    }
    public void insert(Book x){
        NodeB p = new NodeB(x);
        if(isEmpty()){root = p; return;}
        NodeB f = null;
        NodeB q = root;
        while (q != null) {
            if (q.info.getBcode().equals(x.getBcode())) {
                System.out.println("Insertion failed, duplicated key");
                return;
            } else if (q.info.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
            f.left = p;
        } else {
            f.right = p;
        }
    }
    public void inOrder(NodeB p) {
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void visit(NodeB p) {
       System.out.print(p.info + "  ");
       System.out.println();
    }
    public void breadth(NodeB p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        NodeB r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    public void loadFile(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
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
            insert(new Book (bcode, title, quantity, 0, price));
        }   
        fr.close();
        br.close();
    }
    void visit(PrintWriter pw, NodeB p) throws IOException {
        if (pw == null || p == null) {
            return;
        }
        pw.printf("%-4s |  %-9s |  %-3d |  %-10.1f\r\n",p.info.getBcode(),
                                        p.info.getTitle(),p.info.getQuantity(),
                                        p.info.getPrice());
    }
    public void saveFileInOrder(String fname) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeB p = root;
        if (p == null) {
            return;
        }
        inOrder(p.left);
//        visit(pw,p);
        inOrder(p.right);  
        pw.close();
        fw.close();
    }
    public NodeB search(String xCode){
        NodeB p = root;
        while(p != null){
            if(p.info.getBcode().equals(xCode)){
                return p;
            }else if(p.info.getBcode().compareToIgnoreCase(xCode) > 0){
                p=p.left;
            }else{
                p=p.right;
            }
        }  
        return (null);
    }
    
    public void deleByCopy(String xCode) {
        if (root == null) {
            System.out.println("Empty, no deletion");
            return;
        }
        NodeB f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.getBcode().equals(xCode)) {
                break;//Found key x
            }
            if (p.info.getBcode().compareTo(xCode) > 0) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xCode + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) {// p is a leaf node
            if (f == null) {// The tree is one node
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        if (p.left != null && p.right == null) {// p has only left child
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        if (p.left == null && p.right != null){ // p has only right child
            if (f == null) {// p is a root
                root = p.right;
            } else {
                if (f.left == p) {// p is aleft child
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        if (p.left != null && p.right != null) {// p has both left and right children
            NodeB q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null){ // rp is just a left son of p 
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }
    }
    public int count(NodeB p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }
    public void balance(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last) /2;
        Book x = ((NodeB)a.get(m)).info;
        insert(x);
        balance(a, first, m-1);
        balance(a, m+1, last);
    }
    public void simpBalance(NodeB p){
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int first = 0;
        int last = a.size() - 1;
        BookTree b = new BookTree(); //create new tree 
        b.balance(a, first, last);
        root = b.root; //referen root to root b
    }
    public void buildArray(ArrayList a, NodeB p){
        if(p == null){
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }
//    public NodeB search(Node p, int xAge) {
//        if (p == null) {
//            return (null);
//        }
//        if (p.info.age == xAge) {
//            return (p);
//        }
//        if (xAge < p.info.age) {
//            return (search(p.left, xAge));
//        } else {
//            return (search(p.right, xAge));
//        }
//    }
}
