import java.util.*;

public class BST7_Mirror_An_BST {
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

    public static Node Mirror_An_BST(Node Root) {
        if (Root == null) {
            return null;
        }
        Node Left_SubTree = Mirror_An_BST(Root.Left);
        Node Right_SubTree = Mirror_An_BST(Root.Right);
        Root.Left = Right_SubTree;
        Root.Right = Left_SubTree;
        return Root;
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
        Mirror_An_BST(Root);
        System.out.print("AFTER Mirror_An_BST() FUNCTION , MIRROR BST IS ::: ");
        InOrder_Traversal(Root);
    }
}
