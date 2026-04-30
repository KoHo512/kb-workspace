package day_0429.tree;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        // CASE 1 : Node가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else { // CASE 2 : Node가 하나 이상 들어가있을 때
            Node findNode = this.head;

            while (true) {
                // CASE 2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) findNode = findNode.left;
                    else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else { // CASE 2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
                    if (findNode.right != null) findNode = findNode.right;
                    else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }

        return true;
    }

    public Node searchNode(int data) {
        // CASE 1 : Node가 하나도 없을 때
        if (this.head == null) return null;
        else { // CASE 2 : Node가 하나 이상 들어가있을 때
            Node findNode = this.head;

            while (findNode != null) {
                if (data == findNode.value) return findNode;
                else if (data < findNode.value) findNode = findNode.left;
                else findNode = findNode.right;
            }
        }
        return null;
    }

    public boolean deleteNode(int data) {
        Node parentNode = null;
        Node currentNode = this.head;

        // 코너 CASE 1 : Node가 하나도 없을 경우 - 삭제 실패
        if (this.head == null) return false;

        // 코너 CASE 2 : Node가 1개이고, 해당 Node를 삭제할 경우
        if (data == this.head.value && this.head.left == null && this.head.right == null) {
            this.head = null;
            return true;
        }

        // 삭제할 Node와 그 Node의 Parent Node 찾기
        boolean isSearched = false;

        while (currentNode != null) {
            if (data == currentNode.value) {
                isSearched = true;
                break;
            } else if (data < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        // 코너 CASE 3 : 해당 data를 갖는 Node가 없는 경우 - 삭제 실패
        if (isSearched == false) return false;


        // CASE 1 : 삭제할 Node가 Leaf Node인 경우
        if (currentNode.left == null && currentNode.right == null) {
            if (data < parentNode.value) parentNode.left = null;
            else parentNode.right = null;

            return true;
        }

        // CASE 2 : 삭제할 Node가 Child Node를 1개 가지고 있을 경우
        // CASE 2-1 : 왼쪽 자식만 가지고 있을 경우
        if (currentNode.left != null && currentNode.right == null) {
            if (data < parentNode.value) parentNode.left = currentNode.left;
            else parentNode.right = currentNode.left;
        }

        // CASE 2-2 : 오른쪽 자식만 가지고 있을 경우
        else if (currentNode.left == null && currentNode.right != null) {
            if (data < parentNode.value) parentNode.left = currentNode.right;
            else parentNode.right = currentNode.right;
        }

        // CASE 3 : 삭제할 Node가 Child Node를 2개 가지고 있을 경우
        else {
            // 삭제할 Node의 오른쪽 Child Node의 자식 중 가장 작은 값 찾기
            Node parNode = currentNode;
            Node findNode = currentNode.right;

            while (findNode.left != null) {
                parNode = findNode;
                findNode = findNode.left;
            }

            // 찾은 Node를 삭제할 Node의 위치로 올리기
            if (findNode.right != null) parNode.left = findNode.right;
            else parNode.left = null;

            findNode.left = currentNode.left;
            findNode.right = currentNode.right;

            if (data < parentNode.value) {
                parentNode.left = findNode;
            } else {
                parentNode.right = findNode;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();

        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);

        System.out.println(myTree.deleteNode(15));

        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }

}