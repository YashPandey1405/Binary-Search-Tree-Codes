import java.util.*;

public class BST3_Delete_In_BST {
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

    public static Node Delete_In_BST(Node Root, int Value) {
        if (Root.data > Value) {
            Root.Left = Delete_In_BST(Root.Left, Value);
        } else if (Root.data < Value) {
            Root.Right = Delete_In_BST(Root.Right, Value);
        } else {
            if (Root.Left == null && Root.Right == null) {
                return null;
            }
            if (Root.Left == null) {
                return Root.Right;
            } else if (Root.Right == null) {
                return Root.Left;
            }
            Node InOrdSucs = Find_InOrder_Sucsessor(Root.Right);
            Root.data = InOrdSucs.data;
            Root.Right = Delete_In_BST(Root.Right, InOrdSucs.data);
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

    public static Node Find_InOrder_Sucsessor(Node Root) {
        Node Temp = Root;
        while (Temp.Left != null) {
            Temp = Temp.Left;
        }
        return Temp;
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
        System.out.print("ENTER THE VALUE YOU WANT TO DELETE FROM THE BST ::: ");
        int Value = sc.nextInt();
        Node temp = Delete_In_BST(Root, Value);
        InOrder_Traversal(Root);
    }

}
