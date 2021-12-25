package RList;

import LMS.Reader;

public class Node {
    Reader info;
    Node next;

    public Node() {
    }

    public Node(Reader x, Node p) {
        info = x;
        next = p;
    }
    Node(Reader x){
        info = x;
        next = null;
    }
}
