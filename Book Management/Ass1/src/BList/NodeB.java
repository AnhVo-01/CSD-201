package BList;

import LMS.Book;

public class NodeB {
    Book info;
    NodeB next;

    public NodeB() {
    }

    public NodeB(Book x, NodeB p) {
        info = x;
        next = p;
    }
    NodeB(Book x){
        info = x;
        next = null;
    }
}
