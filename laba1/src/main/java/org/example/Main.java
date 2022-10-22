package org.example;

public class Main {
    public static void main(String[] args) {
        Container<String>text=new Container<>();
        text.addToList("mom");
        text.addToList("dad");
        text.addToList("Брат");
        text.output();
        System.out.println();
        text.delELem("dad");
        text.output();
        System.out.println();
        String s;
        s = text.getData();
        System.out.println(s);


    }
}