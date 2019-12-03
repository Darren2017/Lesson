public class Test3 {
    public static void main(String[] args){
        if("A" < "E"){
            System.out.print("w");
        }
    }

    static class BinarySearchTree<T extends Comparable<T> >implements Iterable<T>{
        private Node root;
        private int size;

        private class Node{
            T element;
            Node Left;
            Node right;

            public Node(T elem){
                element = elem;
            }
        }

        public T min(){
            if (isEmpty() == true){
                return null;
            }else{
                Node n = root;
                while(n.left != null){
                    n = n.left;
                }
                return n.element;
            }
        }
    }
}
