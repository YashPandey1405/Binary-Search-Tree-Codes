import java.util.*;

public class BST6_IsValid_BST {
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

    public static boolean IsValid_BST(Node Root, Node Min, Node Max) {
        if (Root == null) {
            return true;
        }
        if (Min != null && Root.data <= Min.data) {
            return false;
        } else if (Max != null && Root.data >= Max.data) {
            return false;
        }
        boolean IsValid_LeftSubTree = IsValid_BST(Root.Left, Min, Root);
        boolean IsValid_RightSubTree = IsValid_BST(Root.Right, Root, Max);
        return (IsValid_LeftSubTree && IsValid_RightSubTree);
    }

    public static void main(String args[]) {
        int arr[] = { 8, 5, 3, 6, 10, 11, 14 };
        int n = arr.length;
        Node Root = null;
        for (int i = 0; i < n; i++) {
            Root = Insert_In_BST(Root, arr[i]);
        }
        InOrder_Traversal(Root);
        System.out.println();
        boolean ans = IsValid_BST(Root, null, null);
        System.out.print("THE BST { ");
        InOrder_Traversal(Root);
        if (ans) {
            System.out.println(" } IS AN VALID BST");
        } else {
            System.out.println(" } IS NOT AN VALID BST");
        }
    }
}
