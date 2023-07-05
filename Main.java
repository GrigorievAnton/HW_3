public class Main {
    public static void main(String[] args) {
        MyBinTree<Integer> test = new MyBinTree<>();
        test.add(100);
        test.add(80);
        test.add(130);
        test.add(40);
        test.add(90);
        test.add(110);
        test.add(170);
        test.add(20);
        test.add(60);
        test.add(165);
        test.add(50);
        test.add(70);
        test.add(55);
        test.add(100);
        test.printTree();
        test.remove(100);
        test.printTree();
    }
}