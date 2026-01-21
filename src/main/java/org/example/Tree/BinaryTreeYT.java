package org.example.Tree;


import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSInput;

import java.util.*;

public class BinaryTreeYT {
    //QUESTION : CREATE A BINARY TREE
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //QUESTION : INSERT ELEMENT INTO BINARY TREE
    static class BuildTree{
        static int idx = -1;
        public static Node tree(int [] arr){
            idx++;
            if (arr[idx] == -1){
                return null;
            }

            Node newNode = new Node(arr[idx]);
            newNode.left = tree(arr);
            newNode.right = tree(arr);

            return newNode;
        }
    }

    //QUESTION : PREORDER TRAVERSAL
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //QUESTION : INORDER
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //QUESTION : POSTORDER
    public static void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //QUESTION : LEVEL ORDER
    public static void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node curr = q.poll();
            if (curr == null){
                if (q.isEmpty()){
                    break;
                }
                System.out.println();
                q.add(null);
            }else {
                System.out.print(curr.data+" ");
                if (curr.left != null){
                    q.add(curr.left);
                }
                if (curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    //QUESTION : COUNT THE NODES
    public static int countNode(Node root){
        if (root == null){
            return 0;
        }
        int left = countNode(root.left);
        int right = countNode(root.right);

        return left+right+1;
    }
    //QUESTION : SUM OF NODES
    public static int sumNode(Node root){
        if (root == null){
            return 0;
        }
        int left = sumNode(root.left);
        int right = sumNode(root.right);

        return left+right+root.data;
    }
    //QUESTION : HEIGHT OF NODES
    public static int height(Node root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int max = Math.max(left, right) +1;

        return max;
    }
    //QUESTION : DIAMETER OF NODES O(n^2)
    public static int diametero2(Node root){
        if (root == null){
            return 1;
        }
        int left = diametero2(root.left);
        int right = diametero2(root.right);
        int through = height(root.left) + height(root.right) +1;

        return Math.max(through, Math.max(left, right));
    }
    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }
    public static TreeInfo diameteron1(Node root){
        if (root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameteron1(root.left);
        TreeInfo right = diameteron1(root.right);
        int height = Math.max(left.ht, right.ht) + 1;

        int max = Math.max(height, left.dia+ right.dia);

        TreeInfo t = new TreeInfo(height, max);

        return t;
    }
    // QUESTION : IS SUBTREE
    public static boolean isIdentical(Node root, Node subroot){
        if (subroot == null && root == null){
            return true;
        }
        if (subroot == null || root == null){
            return false;
        }
        if (root.data != subroot.data){
            return false;
        }
        return isIdentical(root.left, subroot.left) &&
                isIdentical(root.right, subroot.right);
    }
    public static boolean isSubtree(Node root, Node subroot){
        if (subroot == null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (root.data == subroot.data){
            if (isIdentical(root, subroot)){
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    // PREORDER TRAVERSAL ITERATIVELY
    public static void preOrderIter(Node root){
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            Node curr = st.pop();
            System.out.print(curr.data+" ");
            if (curr.right != null){
                st.push(curr.right);
            }
            if (curr.left != null){
                st.push(curr.left);
            }
        }
    }
    // INORDER TRAVERSAL ITERATIVELY
    public static void inorderIter(Node root){
        if (root == null){
            return;
        }

        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()){
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data+" ");

            curr = curr.right;
        }
    }
    // POSTORDER TRAVERSAL ITERATIVELY USING 2 STACK
    public static void postTraversal(Node root){
        if (root == null){
            return;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()){
            Node curr = st1.pop();
            st2.push(curr);
            if (curr.left != null){
                st1.push(curr.left);
            }
            if (curr.right != null){
                st1.push(curr.right);
            }
        }
        while (!st2.isEmpty()){
            Node curr = st2.pop();
            System.out.print(curr.data+" ");
        }
    }

    // POSTORDER TRAVERSAL ITERATIVELY USING 1 STACK
    public static void postOrder1Stack(Node root){
        if (root == null){
            return;
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while (true){
            while ( root != null ){
                st.push(root);
                st.push(root);
                root = root.left;
            }
            if (st.isEmpty()){
                break;
            }
            root = st.pop();
            if (!st.isEmpty() && st.peek() == root){
                root = root.right;
            }else {
                res.add(root.data);
                root = null;
            }
        }
        for (int i : res){
            System.out.print(i+" ");
        }
    }
    // USING LAST VISTED
    public static void lastVistedmethod(Node root){
        List<Integer> ls = new ArrayList<>();
        if (root == null){
            return;
        }
        Stack<Node> st = new Stack<>();
        Node lastvisted = null;
        while (!st.isEmpty() || root != null){
            if (root != null){
                st.push(root);
                root = root.left;
            }else {
                Node peekNode = st.peek();
                if (peekNode.right != null && lastvisted != peekNode.right){
                    root = peekNode.right;
                }else {
                    ls.add(peekNode.data);
                    lastvisted = st.pop();
                }
            }
        }
        for (int i : ls){
            System.out.print(i+" ");
        }
    }
    // CHECK FOR BALANCED BINARY TREE.
    public static boolean Balanced_Binary_Tree(Node root){
        if (root == null){
            return true;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        return Math.abs(heightLeft - heightRight) <= 1 && Balanced_Binary_Tree(root.left)
                && Balanced_Binary_Tree(root.right);
    }
    // BOUNDARY TRAVERSAL OF BINARY TREE.
    public static void leftBoundary(Node root, List<Integer> res){
        Node curr = root;
        while (curr != null){
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void rightBoundary(Node root, List<Integer> res){
        Node curr = root;
        List<Integer> ls = new ArrayList<>();
        while (curr != null){
            if (!isLeaf(curr)) ls.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i = ls.size()-1; i >= 0; --i){
            res.add(ls.get(i));
        }
    }

    public static void addLeaf(Node root, List<Integer> res){
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left, res);
        if (root.right != null) addLeaf(root.right, res);
    }
    public static boolean isLeaf(Node root){
        if (root == null){
            return false;
        }
        return root.left == null && root.right == null;
    }
    public static List<Integer> boundaryTraversal(Node root){
        List<Integer> ls = new ArrayList<>();
        if (!isLeaf(root)) ls.add(root.data);
        leftBoundary(root.left, ls);
        addLeaf(root, ls);
        rightBoundary(root.right, ls);

        return ls;
    }

    // BINARY TREE MAXIMUM PATH SUM
    static int max = 0;
    public static int maxPathSum(Node root){
        maximumSum(root);
        return max;
    }

    public static int maximumSum(Node root){
        if (root == null){
            return 0;
        }
        int left = Math.max(0, maximumSum(root.left));
        int right = Math.max(0, maximumSum(root.right));
        max = Math.max(max, left+right+root.data);

        return Math.max(left, right) + root.data;
    }

    // ZIG-ZAG TRAVERSAL OF TREE
    public static List<List<Integer>> zig_zag(Node root){
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flag = true;
        while (!q.isEmpty()){
            Node curr = q.poll();
            if (curr == null){
                if (flag){
                    ans.add(ls);
                }else {
                    Collections.reverse(ls);
                    ans.add(ls);
                }
                if (q.isEmpty()) break;
                ls = new ArrayList<>();
                q.add(null);
                flag = !flag;
            }else {
                ls.add(curr.data);
                if (curr.left != null){
                    q.add(curr.left);
                }
                if (curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }

    // TOP VIEW
    public static void leftTraversal(Node root, List<Integer> res){
        if (root == null){
            return;
        }
        while (root != null){
            res.add(root.data);
            root = root.left;
        }
        Collections.reverse(res);
    }

    public static void rightTraversal(Node root, List<Integer> res){
        if (root == null){
            return;
        }
        while (root != null){
            res.add(root.data);
            root = root.right;
        }
    }

    public static List<Integer> topView(Node root) {
        //your code goes here
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        leftTraversal(root.left, ans);
        rightTraversal(root.right, ans);

        return ans;
    }

    // VERTICAL ORDER TRAVERSAL
    static class Triple{
        Node node;
        int hd;
        int row;
        Triple(Node node, int hd, int row){
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(root, 0, 0));
        while (!q.isEmpty()){
            Triple curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;
            int row = curr.row;

            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(row, new PriorityQueue<>());
            map.get(hd).get(row).add(node.data);

            if (node.left != null){
                q.add(new Triple(node.left, hd-1, row+1));
            }
            if (node.right != null){
                q.add(new Triple(node.right, hd+1, row+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> columns: map.values()){
            List<Integer> currCol = new ArrayList<>();
            for (PriorityQueue<Integer> nodesAtSameSpot: columns.values()){
                while (!nodesAtSameSpot.isEmpty()){
                    currCol.add(nodesAtSameSpot.poll());
                }
            }
            res.add(currCol);
        }
        return res;
    }

    public static void main(String args[]){
        int arr[] = {45,15,10, -1, 12, -1, -1, 20, -1, -1, 79, 55, 50, -1, -1, -1, 90, -1, -1};
        BuildTree obj1 = new BuildTree();
        Node root = obj1.tree(arr);
        System.out.println("The root of the tree is : "+root.data);
        System.out.print("Preorder traversal is : ");
        preOrder(root);
        System.out.println();
        System.out.print("Inorder traversal is : ");
        inorder(root);
        System.out.println();
        System.out.print("The postOrder traversal is : ");
        postorder(root);
        System.out.println();
        System.out.print("Level order traversal : ");
        levelOrder(root);
        System.out.println();
        System.out.print("Count of nodes : "+countNode(root));
        System.out.println();
        System.out.print("Sum of node is : "+sumNode(root));
        System.out.println();
        System.out.print("Height of tree : "+height(root));
        System.out.println();
        System.out.print("diameter of tree is : "+diametero2(root));
        System.out.println();
        System.out.print("diameter of tree is : "+diameteron1(root).dia);
        int arr1[] = {79, 55, 50, -1, -1, -1, 90, -1, -1};
        BuildTree obj2 = new BuildTree();
        obj2.idx = -1;
        Node subroot = obj2.tree(arr1);
        System.out.println();
        System.out.print("Subroot Node : "+subroot.data);
        System.out.println();
        System.out.print("Preorder traversal Iteratively is : ");
        preOrderIter(subroot);
        System.out.println();
        System.out.print("Is subtree or not : " +isSubtree(root, subroot));
        System.out.println();
        System.out.print("Inorder traversal is : ");
        inorderIter(root);
        System.out.println();
        System.out.print("Postorder traversal is : ");
        postTraversal(root);
        System.out.println();
        System.out.print("Postorder traversal is : ");
        postOrder1Stack(root);
        System.out.println();
        System.out.print("Postorder traversal is : ");
        lastVistedmethod(root);
        System.out.println();
        boolean balancedornot = Balanced_Binary_Tree(subroot);
        System.out.print("Is Balanced or not : "+balancedornot);
        System.out.println();
        List<Integer> ls = boundaryTraversal(root);
        System.out.print("Boundary traversal : "+ls);
        System.out.println();
        System.out.print("Binary Tree Maximum Path Sum : "+maxPathSum(root));
        System.out.println();
        System.out.println("Zig-Zag traversal : "+zig_zag(root));
        System.out.println("Top-view : "+topView(root));
        System.out.println("Vertical traversal : "+verticalTraversal(root));
    }
}
