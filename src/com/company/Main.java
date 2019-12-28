package com.company;

public class Main {

    public static void main(String[] args) {

        DbConnect connect = new DbConnect();
        connect.getData();
       /* connect.addData("Armen" , "Armen2019");
        System.out.println("_____________________");
        System.out.println("After add new data into DataBase");
        connect.getData();*/

       connect.deleteData(2);
        System.out.println("________________________");
        System.out.println("Test delete value on data base");
        connect.getData();

    }
}
