import java.util.*;

public class BST11_Merge2BST {
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

    public static void Get_InOrder(Node Root, ArrayList<Integer> Inorder) {
        if (Root == null) {
            return;
        }
        Get_InOrder(Root.Left, Inorder);
        Inorder.add(Root.data);
        Get_InOrder(Root.Right, Inorder);
    }

    public static Node CreateBST(ArrayList<Integer> Final, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node Root = new Node(Final.get(mid));
        Root.Left = CreateBST(Final, start, mid - 1);
        Root.Right = CreateBST(Final, mid + 1, end);
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

    public static void Merge2BST(Node Root1, Node Root2) {
        ArrayList<Integer> Root1_InOrder = new ArrayList<>();
        Get_InOrder(Root1, Root1_InOrder);

        ArrayList<Integer> Root2_InOrder = new ArrayList<>();
        Get_InOrder(Root2, Root2_InOrder);

        ArrayList<Integer> Final = new ArrayList<>();

        // Code To Sorted Merged ArrayList.......
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < Root1_InOrder.size() && ptr2 < Root2_InOrder.size()) {
            if (Root1_InOrder.get(ptr1) <= Root2_InOrder.get(ptr2)) {
                Final.add(Root1_InOrder.get(ptr1));
                ptr1++;
            } else {
                Final.add(Root2_InOrder.get(ptr2));
                ptr2++;
            }
        }
        while (ptr1 < Root1_InOrder.size()) {
            Final.add(Root1_InOrder.get(ptr1));
            ptr1++;
        }
        while (ptr2 < Root2_InOrder.size()) {
            Final.add(Root2_InOrder.get(ptr2));
            ptr2++;
        }

        Node Root = CreateBST(Final, 0, (Final.size() - 1));
        System.out.print("THE BST FROM ARRAYLIST " + Final + " IS ::: ");
        InOrder_Traversal(Root);
    }

    public static void main(String args[]) {
        Node Root1 = new Node(2);
        Root1.Left = new Node(1);
        Root1.Right = new Node(4);
        Node Root2 = new Node(9);
        Root2.Left = new Node(3);
        Root2.Right = new Node(12);
        Merge2BST(Root1, Root2);
        // System.out.println(Root1_InOrder);
        // System.out.println(Root2_InOrder);
        // System.out.print(Final);
    }

}