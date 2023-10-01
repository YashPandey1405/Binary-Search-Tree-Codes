import java.util.*;

public class BST4_Print_In_BST_Range {
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

    public static void InOrder_Traversal(Node Root) {
        if (Root == null) {
            return;
        }
        InOrder_Traversal(Root.Left);
        System.out.print(Root.data + " ");
        InOrder_Traversal(Root.Right);
    }

    public static void Print_In_BST_Range(Node Root, int Start, int End) {
        if (Root == null) {
            return;
        }
        if (Root.data >= Start && Root.data <= End) {
            Print_In_BST_Range(Root.Left, Start, End);
            System.out.print(Root.data + " ");
            Print_In_BST_Range(Root.Right, Start, End);
        } else if (Root.data >= End) {
            Print_In_BST_Range(Root.Left, Start, End);
        } else {
            Print_In_BST_Range(Root.Right, Start, End);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int n = arr.length;
        Node Root = null;
        for (int i = 0; i < n; i++) {
            Root = Insert_In_BST(Root, arr[i]);
        }
        InOrder_Traversal(Root);
        System.out.println();
        System.out.print("ENTER THE START VALUE TO START PRINTING FROM THE BST ::: ");
        int Start = sc.nextInt();
        System.out.print("ENTER THE END VALUE TO END PRINTING FROM THE BST ::: ");
        int End = sc.nextInt();
        Print_In_BST_Range(Root, Start, End);
    }
}
