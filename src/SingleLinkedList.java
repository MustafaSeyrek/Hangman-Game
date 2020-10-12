

public class SingleLinkedList {

    Node head;

    public void insert(Object data) {
        Node newNode = new Node(data);
        Node current = head;
        Node previous = null;
        //yeni başla
        int index = 0;
        String s = (String) data;
        for (int t = 0; t < s.length(); t++) {
            if (s.charAt(t) == ';') {
                index = t;
                break;
            }
        }
        String name = s.substring(0, index);//yeni gelen
        int score = Integer.parseInt(s.substring(index + 1));
        //yeni bitiş
        String name2 = "";
        int score2 = -1;
        String s2 = "";
        int index2 = 0;
        //eski başlangıç
        if (current != null) {

            s2 = (String) current.getData();
            for (int t = 0; t < s2.length(); t++) {
                if (s2.charAt(t) == ';') {
                    index2 = t;
                    break;
                }
            }
            name2 = s2.substring(0, index2);//yeni gelen
            score2 = Integer.parseInt(s2.substring(index2 + 1));
            //eski bitiş
        }

        while (current != null && (score < score2)) {
            previous = current;
            current = current.getLink();

            if (current != null) {
                s2 = (String) current.getData();
                for (int t = 0; t < s2.length(); t++) {
                    if (s2.charAt(t) == ';') {
                        index2 = t;
                        break;
                    }
                }
                name2 = s2.substring(0, index2);//yeni gelen
                score2 = Integer.parseInt(s2.substring(index2 + 1));
                //eski bitiş
            }
        }
        // insertion at beginning of the list
        if (previous == null) {
            head = newNode;
        } else {
            previous.setLink(newNode);
        }
        newNode.setLink(current);
    }


    public int size() {//SLLnin size
        if (head == null)
            return 0;
        else {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                temp = temp.getLink();
                count++;
            }
            return count;
        }
    }

    public void display() {//high score gösterme konsolda
        int count = 0;
        if (head == null)
            System.out.println("List is empty!");
        else {
            Node temp = head;
            System.out.print("High score table:\n");
            while (temp != null) {
                String t = (String) temp.getData();
                if (t.contains(";")) {
                    t = t.replace(";", "\t");
                }
                System.out.println(t);
                temp = temp.getLink();
                count++;
                //if (count == 10) {
                //    break;
               // }
            }
        }
    }

    public String writeTxt() {//txtyi güncelleyip içine yazma
        String h = "";
        int count = 0;
        if (head == null)
            System.out.println("List is empty!");
        else {
            Node temp = head;
            //System.out.print("High score table:\n");
            while (temp != null) {
                h = h+ (String) temp.getData()+"\n";

                if (h.contains("\t")) {
                    h = h.replace("\t", ";");
                }
                temp = temp.getLink();
                count++;
                if (count == 10) {
                    break;
                }
            }
        }
        return h;
    }


}
