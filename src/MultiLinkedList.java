

public class MultiLinkedList {
    CategoryNode head;

    public void addCategory(int dataToAdd) {//insert to down nodes
        CategoryNode temp;
        if (head == null) {
            temp = new CategoryNode(dataToAdd);
            head = temp;
        } else {
            temp = head;
            while (temp.getDown() != null)
                temp = temp.getDown();
            CategoryNode newnode = new CategoryNode(dataToAdd);
            temp.setDown(newnode);
        }
    }

    public void addItem(int uzunluk, String Ulke) {//insert to right nodes
        String icerdeki = "";
        ItemNode prev = null;
        ItemNode nn = new ItemNode(Ulke);
        if (head == null)
            System.out.println("Add a Category before Country");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                if (uzunluk == (int) temp.getCategoryName()) {
                    ItemNode temp2 = temp.getRight();

                    if (temp2 != null) {
                        icerdeki = temp2.getItemName();
                    }
                    while (temp2 != null && (Ulke.compareTo(icerdeki) > 0)) {
                        prev = temp2;
                        temp2 = temp2.getNext();
                        if (temp2 != null) {
                            icerdeki = temp2.getItemName();
                        }
                    }
                    if (prev == null) {
                        temp.setRight(nn);
                    } else {
                        prev.setNext(nn);
                    }
                    nn.setNext(temp2);


                }
                temp = temp.getDown();
            }
        }
    }

    public int sizeCategory() {//size of down nodes and how many categories in txt
        int count = 0;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                count++;
                temp = temp.getDown();
            }
        }
        return count;
    }

    public int sizeItem() {//size of right nodes and how many words in txt
        int count = 0;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                ItemNode temp2 = temp.getRight();
                while (temp2 != null) {
                    count++;
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
            }
        }
        return count;
    }

    public String findWord(int random) {//random değerle gidilen sizedaki kelimeyi bulma
        String word = "";
        CategoryNode temp = head;
        int count = 0;
        while (temp != null) {
            ItemNode temp2 = temp.getRight();
            while (temp2 != null) {
                count++;
                if(count == random){
                    word = temp2.getItemName();
                    break;
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getDown();
        }

        return word;
    }


    public void display() {//this is show to list of highscore.
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                System.out.print(temp.getCategoryName() + " --> ");
                ItemNode temp2 = temp.getRight();
                while (temp2 != null) {
                    System.out.print(temp2.getItemName() + " ");
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
                System.out.println();
            }
        }
    }


}
