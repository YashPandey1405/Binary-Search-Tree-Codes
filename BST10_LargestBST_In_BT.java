public class BST10_LargestBST_In_BT {
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

    static class Info {
        boolean IsBST;
        int size;
        int max;
        int min;

        public Info(boolean VALID, int SIZE, int MIN, int MAX) {
            this.IsBST = VALID;
            this.size = SIZE;
            this.min = MIN;
            this.max = MAX;
        }
    }

    public static int MaxBST = 0;

    public static Info LargestBST_In_BT(Node Root) {
        if (Root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info LeftInfo = LargestBST_In_BT(Root.Left);
        Info RightInfo = LargestBST_In_BT(Root.Right);
        int Size = LeftInfo.size + RightInfo.size + 1;
        int Min = Math.min(Root.data, Math.min(LeftInfo.min, RightInfo.min));
        int Max = Math.max(Root.data, Math.max(LeftInfo.max, RightInfo.max));
        if (Root.data <= LeftInfo.max || Root.data >= RightInfo.min) {
            return new Info(false, Size, Min, Max);
        }
        if (LeftInfo.IsBST && RightInfo.IsBST) {
            MaxBST = Math.max(MaxBST, Size);
            return new Info(true, Size, Min, Max);
        }
        return new Info(false, Size, Min, Max);
    }

    public static void main(String args[]) {
        Node NewNode = new Node(50);
        NewNode.Left = new Node(30);
        NewNode.Left.Left = new Node(5);
        NewNode.Left.Right = new Node(20);
        NewNode.Right = new Node(60);
        NewNode.Right.Left = new Node(45);
        NewNode.Right.Right = new Node(70);
        NewNode.Right.Right.Left = new Node(65);
        NewNode.Right.Right.Right = new Node(80);
        Info Temp = LargestBST_In_BT(NewNode);
        System.out.println("THE MAX BST IN THE BINARY TREE IS ::: " + MaxBST);
    }

}
