public class Node {

    public Object data;
    public Node link;

    public Node(int x) {
        data = x;
        link = null;
    }

    public Object displayNode() {
        return data;
    }


        //private Object data1;
        private Node prev;
        private Node next;

        public Node(Object dataToAdd) {
            data =  dataToAdd;
            prev = null;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data1) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }


    public Node getLink() { return link;  }
    public void setLink(Node link) { this.link = link;   }

}