package Tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		BinaryTree tree = new BinaryTree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.addNodee(parent, left, right);
        }

        StringBuilder preorderResult = new StringBuilder();
        StringBuilder inorderResult = new StringBuilder();
        StringBuilder postorderResult = new StringBuilder();

        tree.preorder(tree.root, preorderResult);
        tree.inorder(tree.root, inorderResult);
        tree.postorder(tree.root, postorderResult);

        System.out.println(preorderResult);
        System.out.println(inorderResult);
        System.out.println(postorderResult);
	}
	
}

class Nodee {
	char value;
	Nodee left;
	Nodee right;
	
	public Nodee(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	Nodee root;
	
	public void addNodee(char parent, char left, char right) {
        if (root == null) {
            root = new Nodee(parent);
        }
        addRecursive(root, parent, left, right);
    }

    private void addRecursive(Nodee node, char parent, char left, char right) {
        if (node == null) return;

        if (node.value == parent) {
            if (left != '.') node.left = new Nodee(left);
            if (right != '.') node.right = new Nodee(right);
        } else {
            addRecursive(node.left, parent, left, right);
            addRecursive(node.right, parent, left, right);
        }
    }
    
    public void preorder(Nodee node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.value);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public void inorder(Nodee node, StringBuilder sb) {
        if (node == null) return;
        inorder(node.left, sb);
        sb.append(node.value);
        inorder(node.right, sb);
    }

    public void postorder(Nodee node, StringBuilder sb) {
        if (node == null) return;
        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.value);
    }
}
