 package UB;


public class SimpleNodeStack<T> {
     private static class Node<U> {
         private U item;
         private Node<U> next;
         public Node() {
             item = null;
             next = null;
         }
         public Node(U item,Node<U> next) {
             this.item = item;
             this.next = next;
         }   
         public boolean end() {
             return item == null && next == null;
         }
         
     }
     
     private Node<T> node = new Node<T>();
     
     public void push(T item) {
         node = new Node<T>(item,node);
     }
     
     public T pop() {
         T result = node.item;
         if(!node.end()) {
             node = node.next;
         }
         return result;
     }
}
