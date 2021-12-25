package ListR;

import LMS.Reader;

public class NodeR {
    Reader info;
    NodeR next;

    public NodeR() {
    }

    public NodeR(Reader x, NodeR p) {
        info = x;
        next = p;
    }
    NodeR(Reader x){
        info = x;
        next = null;
    }
}
