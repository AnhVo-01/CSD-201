package Tree;

public class Main {
    public static void main(String[] args) {
        int[] a={16,6,8,1,10,20,8,12,19};
        BSTree b = new BSTree();
        b.insertMany(a);
        System.out.println("1. Breadth-first traversals");
        b.breadth(b.root);
        System.out.println();
        System.out.println("2. PreOrder traversals");
        b.preOrder(b.root);
        System.out.println();
        System.out.println("3. InOrder traversals");
        b.inOrder(b.root);
        System.out.println();
        System.out.println("4. PostOrder traversals");
        b.postOrder(b.root);
        System.out.println();
    }
}
