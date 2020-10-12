import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        MultiLinkedList MLL = new MultiLinkedList();
        DoubleLinkedList DLL = new DoubleLinkedList();
        SingleLinkedList SLL = new SingleLinkedList();
        CircularLinkedList CLL1 = new CircularLinkedList();
        CircularLinkedList CLL2 = new CircularLinkedList();

        Random r = new Random();


        
        FileReader fileReader = new FileReader("C:/Users/mustafa//Desktop/input.txt");
        FileReader fileReader1 = new FileReader("C:/Users/mustafa//Desktop/HighScoreTable.txt");

        String satir, satir1;

        BufferedReader br = new BufferedReader(fileReader);
        BufferedReader br1 = new BufferedReader(fileReader1);
        for (int i = 4; i < 14; i++) {
            MLL.addCategory(i);
        }

        char c;
        for (c = 'A'; c <= 'Z'; ++c) {
            DLL.add(String.valueOf(c));
        }

        while ((satir = br.readLine()) != null) {
            String B = satir.toUpperCase();
            MLL.addItem(satir.length(), B);
        }
        while ((satir1 = br1.readLine()) != null) {
            SLL.insert(satir1);
        }


        int ulkesayisi = MLL.sizeItem();
        int random = r.nextInt(ulkesayisi);
        random++;

        String word = ""; //random sayısındaki ülke ismi
        word = MLL.findWord(random);
        //System.out.println(word); //gelen word görmek için
        for (int i = 0; i < word.length(); i++) {
            CLL1.insert(String.valueOf(word.charAt(i)));
            CLL2.insert("-");
        }


        int lives = 6;
        int score = 0; //sesli => +5, sessiz => +10
        boolean flag = true;
        Scanner scn = new Scanner(System.in);

        boolean winControl = false;//kazanma kontrolü
        //SLL.display(); highscore görüntüleme
        System.out.println("Randomly generated number: " + random);
        while (flag == true) {
            String input = "";
            String temp = "";
            boolean inputControl = false;
            System.out.print("Word: " + CLL2.display1() + "\t\tLives: " + lives + "\t\tScore: " + score + "\t " + DLL.display1() + "\n");
            System.out.print("Guess: " + input);
            input = scn.next();
            input = input.toUpperCase();
            if(input.length()!=1){
                System.out.println("Enter true input!!");
            }
            else{
            //input <=M ise baştan kontroll et değilse sondan kontrol et
            if (input.compareTo("M") > 0) {
                inputControl = DLL.search2(input);
            } else {
                inputControl = DLL.search1(input);
            }

            DLL.remove(input);//alfabeden silme
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == input.charAt(0)) {
                    CLL2.replace(i, input); //cll2 harf değiştirme
                }
            }
            if (word.contains(input)) {
                if (inputControl == true) {
                    if (input.equals("A") || input.equals("E") || input.equals("I") || input.equals("O") || input.equals("U")) {
                        score += 5;
                    } else {
                        score += 10;
                    }
                } else
                    System.out.println("You entered the same letter before or entered an incorrect character!");
            } else {
                if (inputControl == true)
                    lives--;
                else
                    System.out.println("You entered the same letter before or entered an incorrect character!");
            }


            if (lives == 0) { //can biterse lost
                System.out.println("\nYou lost !!");
                flag = false;
            }
            temp = CLL2.display1();
            if (!temp.contains("-")) {
                System.out.print("Word: " + CLL2.display1() + "\t\tLives: " + lives + "\t\tScore: " + score + "\t " + DLL.display1() + "\n");

                System.out.println("\nYou win !!");
                winControl = true;
                flag = false;
            }

        }}
        String z = "";
        String f = "";

        if (winControl == true) {//eğer oyuncu kazanırsa isim isteniyor. Kaybederse gerek kalmıyor.
            System.out.print("Please enter your name: ");
            z = scn.next();
            f = z + ";" + score;
            SLL.insert(f);
            String son = SLL.writeTxt();
            //txtye score ekleme
            File file = new File("C:/Users/mustafa//Desktop/HighScoreTable.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(son);
            //bWriter.newLine();
            bWriter.close();
        }
        SLL.display();//high score table


    }
}