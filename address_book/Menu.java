package com.stefanosgregory.project;

import java.util.Scanner;

class Menu  {
    private Scanner scan = new Scanner(System.in);
    private String answer;
    void  menu() {
        System.out.println("             Εφαρμογή AddressBook");
        System.out.println("Παρακαλώ επιλέξετε από το παρακάτω Menu επιλογών");
        System.out.println("------------------------------------------------");
        System.out.println("   1.   Προβολή όλων των διαθέσιμων επαφών");
        System.out.println("   2.   Προσθήκη νέας επαφής");
        System.out.println("   3.   Αναζήτηση επαφής βάσει ονόματος");
        System.out.println("   4.   Αναζήτηση επαφής βάσει τηλεφώνου");
        System.out.println("   5.   Επεξεργασία επαφής βάσει ονόματος");
        System.out.println("   6.   Διαγραφή επαφής βάσει ονόματος");
        System.out.println("   7.   Έξοδος από την εφαρμογή");
        answer = scan.nextLine();
        while (!answer.matches("[1-7]+")|| answer.length()>1 | answer.length()<1) {
            System.out.println("Κάνατε λάθος, ξαναπροσπαθήστε..");
            answer = scan.nextLine();
        }
         Contacts contacts = new Contacts();
         if (answer.equals("1") ) {
             contacts.printFromFile();
         }
         else if (answer.equals("2")) {
             contacts.readValues();
         }
         else if (answer.equals("3")) {
             contacts.findRecordbyname();
         }
         else if (answer.equals("4")) {
             contacts.findRecordbyphone();
         }
         else if (answer.equals("5")) {
             contacts.editFromFileWithName();
         }
         else if (answer.equals("6")) {
             contacts.deleteFromFile();
         }
         else  {
             System.out.println("Eπιλέξατε την έξοδο..");
             System.exit(0);
         }
     }
}
