import java.util.*;

public class BST5_Print_LeafToNode_BST {
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

    public static void PrintPath(ArrayList<Integer> Path, int Count) {
        int n = Path.size();
        System.out.print("THE PATH " + Count + " FROM ROOT->LEAF NODE IS ::: ");
        for (int i = 0; i < n; i++) {
            System.out.print(Path.get(i) + "-->");
        }
        System.out.println("Null");
    }

    public static void Print_LeafToNode_BST(Node Root, ArrayList<Integer> Path, int Count) {
        if (Root == null) {
            return;
        }
        Path.add(Root.data);
        if (Root.Left == null && Root.Right == null) {
            PrintPath(Path, Count);
        }
        Print_LeafToNode_BST(Root.Left, Path, Count);
        Print_LeafToNode_BST(Root.Right, Path, Count);
        Path.remove(Path.size() - 1);
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
        Print_LeafToNode_BST(Root, new ArrayList<>(), 0);
    }
}
