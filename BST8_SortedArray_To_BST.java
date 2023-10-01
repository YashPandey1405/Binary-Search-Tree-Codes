public class BST8_SortedArray_To_BST {
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

    public static void InOrder_Traversal(Node Root) {
        if (Root == null) {
            return;
        }
        InOrder_Traversal(Root.Left);
        System.out.print(Root.data + " ");
        InOrder_Traversal(Root.Right);
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

    public static void main(String args[]) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        int n = arr.length;
        Node NewNode = SortedArray_To_BST(arr, 0, (n - 1));
        System.out.print("THE BINARY SEARCH TREE FROM SORTED ARRAY {3,5,6,8,10,11,12} IS ::: ");
        InOrder_Traversal(NewNode);
    }
}