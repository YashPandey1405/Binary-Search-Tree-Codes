import java.util.*;

public class BST2_Search_In_BST {
    static class Node {
        int data;
        Node Left;
        Node Right;

        public Node(int CurrData) {
            this.data = CurrData;
            this.Left = null;
            this.Right = null;
        }
    }

    public static Node Insert_In_BST(Node Root, int Value) {
        if (Root == null) {
            Root = new Node(Value);
            return Root;
        }
        if (Root.data > Value) {
            Root.Left = Insert_In_BST(Root.Left, Value);
        } else {
            Root.Right = Insert_In_BST(Root.Right, Value);
        }
        return Root;
    }

    public static boolean Search_In_BST(Node Root, int Key) { // O(h)....[h=Height Of BST]
        if (Root == null) {
            return false;
        }
        if (Root.data == Key) {
            return true;
        }
        if (Root.data > Key) {
            return Search_In_BST(Root.Left, Key);
        } else {
            return Search_In_BST(Root.Right, Key);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE KEY YOU WANT TO SAERCH IN THE BST ::: ");
        int Key = sc.nextInt();
        int arr[] = { 5, 3, 2, 1, 4, 7, 6, 9, 8, 10 };
        int n = arr.length;
        Node Root = null;
        for (int i = 0; i < n; i++) {
            Root = Insert_In_BST(Root, arr[i]);
        }
        boolean ans = Search_In_BST(Root, 7);
        if (ans) {
            System.out.println("KEY " + Key + " FOUND IN THE GIVEN BINARY SEARCH TREE");
        } else {
            System.out.println("KEY " + Key + " NOT FOUND IN THE GIVEN BINARY SEARCH TREE");
        }
    }
}
