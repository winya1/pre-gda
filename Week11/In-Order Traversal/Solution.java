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
          
           /* could potentially include when the two nodes are equal
           // newNode = current node
            if (newNodeValue == currentNode.value) {
                return;
            } */

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

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.value + " ");
        inOrderTraversal(node.rightChild);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        int caseInput = in.nextInt();
        for (int i = 0; i < caseInput; i++) {
            int nextNode = in.nextInt();
            tree.insert(nextNode);
        }
        inOrderTraversal(tree.root);
    }
}
