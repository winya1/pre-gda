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

    public static int lowestCommonAncestor(Node root, int v, int w) {
        // this is assuming 0 can't be the lowestCommonAncestor
        if(root == null)
            return 0;
        if(root.value == v || root.value == w)
            return root.value;

        int left = lowestCommonAncestor(root.leftChild,v,w);
        int right = lowestCommonAncestor(root.rightChild,v,w);

        // If we get left and right not null , it is lca for v and w

        if(left != 0 && right != 0)
            return root.value;
        if(left == 0)
            return right;
        else
            return left;

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        String input = in.nextLine().trim().replaceAll("  +", " ");
        int[] inputs = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int v = inputs[1];
        int w = inputs[2];

        int noOfInserts = inputs[0];
        for (int i = 0; i < noOfInserts; i++) {
            int nextNode = in.nextInt();
            tree.insert(nextNode);
        }

        System.out.println(lowestCommonAncestor(tree.root, v, w));
    }
}
