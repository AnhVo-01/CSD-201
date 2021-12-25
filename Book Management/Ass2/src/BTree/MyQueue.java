package BTree;

import java.util.*;
public class MyQueue {
   LinkedList<NodeB> t;
   MyQueue() {
     t=new LinkedList<NodeB>();  
   }
   void clear() {
     t.clear();  
   }
   boolean isEmpty() {
     return(t.isEmpty());  
   }
   void enqueue(NodeB p) {
      t.addLast(p);
   }
   NodeB dequeue() {
      if(isEmpty()) return(null);
      return(t.removeFirst());
   }
   NodeB front() {
      if(isEmpty()) return(null);
      return(t.getFirst());    
   }
}
