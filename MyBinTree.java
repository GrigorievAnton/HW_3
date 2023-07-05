

public class MyBinTree<E> {
    private class Node {
        public E element;

        public Node left;
        public Node right;
        public Node(E element) {
            this.element = element;

            left = null;
            right = null;
        }
    }
    private int size = 0;
    private Node root = null;
    private Node findNode(Object element) {
        Node curNode = root;
        Comparable<E> cKey = (Comparable<E>) element;
        while(curNode != null) {
            int cnp = cKey.compareTo(curNode.element);
            if (cnp < 0) {
                curNode = curNode.left;
            }
            if(cnp > 0) {
                curNode = curNode.right;
            }
            if(cnp == 0) {
                return curNode;
            }
        }
        return null;
    }
    private Node findParent(Object element) {
        Comparable<E> cKey = (Comparable<E>) element;
        Node child = root;
        Node parent = root;
        while (child != null) {
            int cnp = cKey.compareTo(child.element);
            if (cnp > 0) {
                parent = child;
                child = child.right;
            }
            if (cnp < 0) {
                parent = child;
                child = child.left;
            }
            if (cnp == 0) {
                return parent;
            }
        }
        return null;
    }
    public boolean contains(Object element) {
        Node curNode = findNode(element);
        if (curNode == null) return false;
        return true;
    }
    public void add(E element) {
        if (root == null) {
            root = new Node(element);
            size++;
            return;
        }
        putHelper(element, root);
    }
    private void putHelper(E element, Node node) {
        Comparable<E> cKey = (Comparable<E>) element;
        int cnp = cKey.compareTo(node.element);
        if (cnp <= 0) {
            if (node.left == null) {
                node.left = new Node(element);
                size++;
                return;
            }
            putHelper(element, node.left);
        }
        if (cnp > 0) {
            if (node.right == null) {
                node.right = new Node(element);
                size++;
                return;
            }
            putHelper(element, node.right);
        }
        return;
    }
    public E remove(Object element) {
        Node child = findNode(element);
        if (child == null) return null;
        if (size == 1) {
            root = null;
            size--;
            return child.element;
        }
     Node parent = findParent(element);
     if (child.left != null && child.right != null) {
         Node preemnik = findPreemnik(child.right);
         Node preParent = findParent(preemnik.element);
         removeHelper(preemnik, preParent);
         child.element = preemnik.element;
         E oldValue = child.element;
         child.element = preemnik.element;
         return oldValue;
     } else if (child == root) {
         if (child.left != null) root = child.left;
         if (child.right != null) root = child.right;
         size--;
         return child.element;
     } else {
         return removeHelper(child, parent);
     }
    }
    private E removeHelper(Node child, Node parent) {
        if (child.left == null && child.right == null) {
            if(parent.left == child) parent.left = null;
            if (parent.right == child) parent.right = null;
            size--;
            return child.element;
        }
        if (child.left == null) {
            if (parent.left == child)parent.left = child.right;
            if (parent.right == child) parent. right = child.right;
            size--;
            return child.element;
        }
        if (child.right == null) {
            if (parent.left == child) parent.left = child.left;
            if (parent.right == child) parent. right = child.left;
            size--;
            return child.element;
        }
        return null;
    }
    private Node findPreemnik(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("Root is" + root.element);
        LER(root);
    }
    public void LER(Node node) {
        if (node.left != null) LER(node.left);
        System.out.println(node.element);
        if(node.right != null) LER(node.right);
    }
}
