public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public void insert(int key) {
        root = insertRec(root,key);
    }

    public Node insertRec(Node root, int key) {

        // If the tree is empty return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left,key);
        } else if (key > root.key){
            root.right = insertRec(root.right,key);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key > key)
            return search(root.right,key);
            return search(root.left,key);

    }

    public int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    public void delete(int key) {
        root = deleteRec(root,key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key) {
            root.left = deleteRec(root.left,key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right,key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right,root.key);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(10);
        tree.insert(49);
        tree.insert(15);

        tree.delete(10);

        tree.inorder();
    }
}













