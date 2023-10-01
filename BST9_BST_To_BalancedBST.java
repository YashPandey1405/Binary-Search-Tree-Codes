import java.util.*;

public class BST9_BST_To_BalancedBST {
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

    public static Node SortedArray_To_BST(int arr[], int start, int end) { // O(n).....
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node Root = new Node(arr[mid]);
        Root.Left = SortedArray_To_BST(arr, start, (mid - 1));
        Root.Right = SortedArray_To_BST(arr, (mid + 1), end);
        return Root;
    }

    public static void Get_InOrder(Node Root, ArrayList<Integer> InOrder) {
        if (Root == null) {
            return;
        }
        Get_InOrder(Root.Left, InOrder);
        InOrder.add(Root.data);
        Get_InOrder(Root.Right, InOrder);
    }

    public static Node Create_BST(ArrayList<Integer> InOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node Root = new Node(InOrder.get(mid));
        Root.Left = Create_BST(InOrder, start, (mid - 1));
        Root.Right = Create_BST(InOrder, (mid + 1), end);
        return Root;
    }

    public static Node Balanced_BST(Node Root) {
        ArrayList<Integer> InOrder = new ArrayList<>();
        Get_InOrder(Root, InOrder);
        Root = Create_BST(InOrder, 0, (InOrder.size() - 1));
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

    public static void main(String args[]) {
        Node NewNode = new Node(8);
        NewNode.Left = new Node(6);
        NewNode.Left.Left = new Node(5);
        NewNode.Left.Left.Left = new Node(3);
        NewNode.Right = new Node(10);
        NewNode.Right.Right = new Node(11);
        NewNode.Right.Right.Right = new Node(12);
        Node Temp = Balanced_BST(NewNode);
        System.out.print("THE BINARY SEARCH TREE IS ::: ");
        InOrder_Traversal(Temp);
    }
}
