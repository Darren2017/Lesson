public class LinkedNoedsExamQuestion{
    public static void main(String[] args) {
        SinglyLinked<Integer> iChain = new SinglyLinked<>();
        iChain.add(10);
        iChain.add(12);
        iChain.add(8);
        iChain.add(2);
        iChain.add(6);
        iChain.add(4);
        Integer smallestInterger = iChain.min();
        System.out.println(smallestInterger);

        SinglyLinked<String> sChain = new SinglyLinked<>();
        sChain.add("W");
        sChain.add("A");
        sChain.add("R");
        sChain.add("E");
        sChain.add("A");
        sChain.add("G");
        sChain.add("L");
        sChain.add("E");
        String smallestInterge = sChain.min();
        System.out.println(smallestInterge);
    }

    static class SinglyLinked<T extends Comparable<T>> {
        Node front;

        class Node{
            T element;
            Node next;

            public Node(T elmt, Node nxt){
                element = elmt;
                next = nxt;
            }
        }

        public SinglyLinked(){
            front = null;
        }

        public void add(T value){
            front = new Node(value, front);
        }

        public T min(){
            T min_n;
            if (front == null){
                return null;
            }else{
                Node p = front;
                min_n = p.element;
                p = p.next;
                while(p != null){
                    if(p.element.compareTo(min_n) < 0){
                        min_n = p.element;
                    }
                    p = p.next;
                }
            }
            return min_n;
        }
    }
}