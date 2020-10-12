public class DoubleLinkedList {
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Object dataToAdd) {
        Node newnode;
        if (head == null) {  //list is empty
            newnode = new Node(dataToAdd);
            head = newnode;
            tail = newnode;
        }
        else {   //add to the end
            newnode = new Node(dataToAdd);
            newnode.setPrev(tail);
            tail.setNext(newnode);
            tail=newnode;
        }
    }





    public void remove(String s)
    {
        if (head == null)
            System.out.println("linked list is empty");
        else
        {
            while (( head.getData()).equals(s))	{
                head = head.getNext();
                head.setPrev(null);
            }
            Node temp = head;
            while (temp != null)
            {
                if ((temp.getData()).equals(s)) {
                    if (temp.getNext() == null) {
                        tail = tail.getPrev();
                        tail.setNext(null);
                    }
                    else {
                        temp.getPrev().setNext(temp.getNext());
                        temp.getNext().setPrev(temp.getPrev());
                    }
                }
                temp=temp.getNext();
            }
        }
    }

    public int size()
    {
        int count = 0;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            Node temp = head;
            while (temp != null)
            {
                count++;
                temp=temp.getNext();
            }
        }
        return count;
    }

    public String display1()//Double link listteki alfabeyi göstermek için
    {
        String s="";
        if (head == null)
            System.out.println("linked list is empty");
        else {
            Node temp = head;
            while (temp != null)
            {
                s=s+temp.getData() + " ";
                temp = temp.getNext();
            }
        }
        return s;
    }


    public boolean search1(Object s) //baştan kontrol
    {
        boolean flag = false;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            Node temp = head;
            while (temp != null)
            {
                if (temp.getData().equals(s)) {
                    flag = true;
                    break;
                }
                temp = temp.getNext();
            }
        }
        return flag;
    }
    public boolean search2(Object s) //sondan kontrol
    {
        boolean flag = false;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            Node temp = tail;
            while (temp != null)
            {
                if (temp.getData().equals(s)) {
                    flag = true;
                    break;
                }
                temp = temp.getPrev();
            }
        }
        return flag;
    }


    public void display()//Double link listteki alfabeyi göstermek için
    {
        if (head == null)
            System.out.println("linked list is empty");
        else {
            Node temp1 = head;
            Node temp2 = tail;
            while (temp1 != temp2 && temp1 != temp2.getNext())
            {
                System.out.print(temp1.getData() + " ");
                System.out.print(temp2.getData() + " ");
                temp1 = temp1.getNext();
                temp2 = temp2.getPrev();
            }
            if(temp1 == temp2) System.out.print(temp1.getData());
            System.out.println();
        }
    }




}
