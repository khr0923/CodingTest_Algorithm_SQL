import java.util.Scanner;

class Node {
    char data;
    Node lNode, rNode;


    Node(char data, Node lNode, Node rNode) {
        this.data = data;
        this.lNode = lNode;
        this.rNode = rNode;
    }

}

public class Main {
    static Scanner in = new Scanner(System.in);
    static Node head = new Node('A', null, null);

    public static void main(String[] args) {
        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            String alpha = in.nextLine();
            String[] alphaArr = alpha.split(" ");
            char root = alphaArr[0].charAt(0);
            char left = alphaArr[1].charAt(0);
            char right = alphaArr[2].charAt(0);

            addNode(head, root, left, right);

        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }

    public static void addNode(Node temp, char root, char left, char right) {
        if(temp.data == root) {
            temp.lNode = (left == '.' ? null : new Node(left, null, null));
            temp.rNode = (right == '.' ? null : new Node(right, null, null));
        } else {
            if(temp.lNode != null) addNode(temp.lNode, root, left, right);
            if(temp.rNode != null) addNode(temp.rNode, root, left, right);
        }
    }
    public static void preOrder(Node node){
        if(node == null) return;
        else{
            System.out.print(node.data);
            preOrder(node.lNode);
            preOrder(node.rNode);
        }

    }

    public static void inOrder(Node node){
        if(node == null) return;
        else{
            inOrder(node.lNode);
            System.out.print(node.data);
            inOrder(node.rNode);
        }
    }

    public static void postOrder(Node node){
        if(node == null) return;
        else{
            postOrder(node.lNode);
            postOrder(node.rNode);
            System.out.print(node.data);
        }
    }

}