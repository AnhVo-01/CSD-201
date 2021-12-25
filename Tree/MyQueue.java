package Tree;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Node> t;
    MyQueue(){
        t = new LinkedList<>();
    }
    void clear(){
        t.clear();
    }
    boolean isEmty(){
        return (t.isEmpty());
    }
    void enqueue(Node p){
        t.addLast(p);
    }
    Node dequeue(){
        if(isEmty()) return null;
        return t.removeFirst();
    }
    Node front(){
        if(isEmty()) return null;
        return t.getFirst();
    }
}
