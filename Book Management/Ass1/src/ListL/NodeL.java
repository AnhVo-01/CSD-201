package ListL;

import LMS.Lending;

public class NodeL {
    Lending info;
    NodeL next;

    public NodeL() {
    }

    public NodeL(Lending x, NodeL p) {
        info = x;
        next = p;
    }
    NodeL(Lending x){
        info = x;
        next = null;
    }
}

