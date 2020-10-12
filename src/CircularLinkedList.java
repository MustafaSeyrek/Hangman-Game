public class CircularLinkedList {

    private Node first;
    private Node current;
    private int count;


    public CircularLinkedList() {
        first = null;
        current = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void step() {
        current = current.link;
    }

    public Node getFirst() {
        return first;
    }

    public void insert(String x) {
        Node newNode = new Node(x);

        if (isEmpty()) {
            first = newNode;
            current = first;
        } else {
            current.link = newNode;
        }

        newNode.link = first;
        step();
        count++;
    }


    public String display1() {
        int count1 = 0;
        Node temp = first;
        String s = "";
        while (count1 < count) {
            s = s + (String) temp.displayNode();
            temp = temp.link;
            count1++;
        }
        return s;
    }


    public void replace(int i, String z) {
        Node temp = first;
        int say = 0;
        if (temp == null) {
            System.out.println("List is empty!");
        } else {
            do {
                if (say == i) {
                    temp.data = z;
                }
                temp = temp.link;
                say++;
            } while (temp != first);
        }

    }

}