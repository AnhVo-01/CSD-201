package BTree;

import LMS.Book;

public class NodeB {
    Book info;
    NodeB left, right;

    public NodeB() {
    }
    
    public NodeB(Book x) {
        info = x;
        left = right = null;
    }
}