import java.util.*;


class Solution {

    static class Node {
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value) {
            this.value = value;
        }
    }

    static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(int newNodeValue) {
            root = insert(newNodeValue, root);
        }

        private Node insert(int newNodeValue, Node currentNode) {
            if (currentNode == null) {
                currentNode = new Node(newNodeValue);
            }
            // newNode < current node
            if (newNodeValue < currentNode.value) {
                currentNode.leftChild = insert(newNodeValue, currentNode.leftChild);
            }
            // newNode > current node
            if (newNodeValue > currentNode.value) {
                currentNode.rightChild = insert(newNodeValue, currentNode.rightChild);
            }
            return currentNode;
        }

    }

  // created a separate class for mirrored BST, but there might be a way to combine the two methods
    static class MirroredBinarySearchTree {
        Node root;

        public MirroredBinarySearchTree() {
            root = null;
        }

        public void insert(int newNodeValue) {
            root = insert(newNodeValue, root);
        }

        private Node insert(int newNodeValue, Node currentNode) {
            if (currentNode == null) {
                currentNode = new Node(newNodeValue);
            }

            // newNode < current node
            if (newNodeValue < currentNode.value) {
                currentNode.rightChild = insert(newNodeValue, currentNode.rightChild);
            }
            // newNode > current node
            if (newNodeValue > currentNode.value) {
                currentNode.leftChild = insert(newNodeValue, currentNode.leftChild);
            }
            return currentNode;
        }

    }


    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        MirroredBinarySearchTree mirror = new MirroredBinarySearchTree();

        int caseInput = in.nextInt();
        for (int i = 0; i < caseInput; i++) {
            int nextNode = in.nextInt();
            tree.insert(nextNode);
            mirror.insert(nextNode);
        }
        preOrderTraversal(tree.root);
        System.out.println();
        preOrderTraversal(mirror.root);
    }
}
