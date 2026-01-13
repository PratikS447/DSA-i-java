package org.example.Tree;


import com.sun.source.tree.Tree;

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
    }
}
