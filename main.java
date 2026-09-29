import java.util.Scanner;

public class main {

    // === AVL NODE ===
    static class Node {
        int key;
        int height;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
    /// === HEIGHT HELPERS ===
    static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;

        static int updateHeight(Node node) {
            if (node == null) {
                return 0;
            }
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            return node.height;
        }


    // === ROTATIONS ===
    static Node rotateRight(Node root) {
        Node newRoot = root.left;
        Node temp = newRoot.right;

        newRoot.right = root;
        root.left = temp;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.right;
        Node temp = newRoot.left;

        newRoot.left = root;
        root.right = temp;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    // === INSERTION ===
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            return root; // duplicate keys are not allowed
        }

        updateHeight(root);
        int balance = getHeight(root.left) - getHeight(root.right);

        // Left left
        if (balance > 1 && key < root.left.ket) {
            return rotateRight(root);
        }

        // right right
        if (balance < -1 && key > root.right.key) {
            return rotateLeft(root);
        }

        // left right 
        if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // right left
        if (balance < -1 && key < root.right.key) {
            root.right = rotateright(root.right);
            return rotateLeft(root);
        }



    // === MAIN ===
    public static void main(String[] args) {
        // === INPUT ===
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

    }
    
}
