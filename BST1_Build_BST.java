public class BST1_Build_BST {
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

    public static Node Insert_In_BST(Node Root, int Value) { // O(n).....
        if (Root == null) {
            Root = new Node(Value);
            return Root;
        }
        if (Root.data > Value) {
            Root.Left = Insert_In_BST(Root.Left, Value);
            // return Root.Left;
        } else {
            Root.Right = Insert_In_BST(Root.Right, Value);
            // return Root.Right;
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

    public static void main(String args[]) {
        int arr[] = { 5, 1, 3, 4, 2, 7 };
        // int arr[] = { 5, 3, 2, 1, 4, 7, 6, 9, 8, 10 };
        int n = arr.length;
        Node Root = null;
        for (int i = 0; i < n; i++) {
            Root = Insert_In_BST(Root, arr[i]);
        }
        InOrder_Traversal(Root);
    }
}
// Node NewNode = new Node(4);
// NewNode.Left = new Node(2);
// NewNode.Left.Left = new Node(1);
// NewNode.Left.Right = new Node(3);
// NewNode.Right = new Node(6);
// NewNode.Right.Left = new Node(5);
// NewNode.Right.Right = new Node(7);
