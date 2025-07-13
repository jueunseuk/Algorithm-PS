package Tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main_5639_이진검색트리 {
    static StringBuilder sb = new StringBuilder();

    static class BTree {
        Node root;

        BTree() {
            this.root = null;
        }

        public void insert(int value) {
            root = insertRecursive(root, value);
        }

        private Node insertRecursive(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }
            if (value < node.value) {
                node.left = insertRecursive(node.left, value);
            } else if (value > node.value) {
                node.right = insertRecursive(node.right, value);
            }
            return node;
        }

        public boolean search(int value) {
            return searchRecursive(root, value);
        }

        private boolean searchRecursive(Node node, int value) {
            if (node == null) {
                return false;
            }
            if (value == node.value) {
                return true;
            }
            return value < node.value
                ? searchRecursive(node.left, value)
                : searchRecursive(node.right, value);
        }

        public void update(int oldValue, int newValue) {
            if (search(oldValue)) {
                delete(oldValue);
                insert(newValue);
            } else {
                System.out.println("Value " + oldValue + " not found in the tree.");
            }
        }

        public void delete(int value) {
            root = deleteRecursive(root, value);
        }

        private Node deleteRecursive(Node node, int value) {
            if (node == null) {
                return null;
            }
            if (value < node.value) {
                node.left = deleteRecursive(node.left, value);
            } else if (value > node.value) {
                node.right = deleteRecursive(node.right, value);
            } else {
                if (node.left == null && node.right == null) {
                    return null;
                } else if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    int minValue = findMin(node.right);
                    node.value = minValue;
                    node.right = deleteRecursive(node.right, minValue);
                }
            }
            return node;
        }

        private int findMin(Node node) {
            int minValue = node.value;
            while (node.left != null) {
                minValue = node.left.value;
                node = node.left;
            }
            return minValue;
        }

        public void preorderTraversal() {
            preorderRecursive(root);
        }

        private void preorderRecursive(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preorderRecursive(node.left);
                preorderRecursive(node.right);
            }
        }

        public void postorderTraversal() {
            postorderRecursive(root);
        }

        private void postorderRecursive(Node node) {
            if (node != null) {
                postorderRecursive(node.left);
                postorderRecursive(node.right);
                sb.append(node.value).append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BTree tree = new BTree();
        String line;

        while (true) {
        	line = br.readLine();
        	
        	if(line == null || line.length() == 0) {
        		break;
        	}
        	
            int value = Integer.parseInt(line);
            tree.insert(value);
        }

        tree.postorderTraversal();
        System.out.println(sb.toString().trim());
    }
}
