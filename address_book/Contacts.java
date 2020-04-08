package com.stefanosgregory.project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class Contacts {
    private String name, surname, phone, email, address;
    private Scanner scan = new Scanner(System.in);
    private String filepath ="conData.txt";
    private String tempFile = "temp.txt";
    private Scanner x1;
    private Menu menu = new Menu();

    public void writeInFile() {
        try {
            PrintWriter x = new PrintWriter(new FileWriter("conData.txt", true));
            x.append(name + "|" + surname + "|" + phone + "|" + email + "|" + address+"\n");
            x.flush();
            x.close();
            System.out.println("Προστέθηκε επιτυχώς..");
            bmenu();
        } catch (Exception e) {
            System.out.println("Δεν έγινε φόρτωση αρχείου..");
            bmenu();
        }
    }

        void readValues() {
            System.out.print("Δώσε όνομα: ");
            name = scan.nextLine();
            while (!name.matches("[α-ωΑ-Ω]+") && !name.matches("[a-zA-Z]+")) {
                System.out.println("Κάνατε λάθος, το όνομα δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                name = scan.nextLine();
            }
            System.out.print("Δώσε επίθετο: ");
            surname = scan.nextLine();
            while (!surname.matches("[α-ωΑ-Ω]+") && !surname.matches("[a-zA-Z]+")) {
                System.out.println("Κάνατε λάθος, το επίθετο δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                surname = scan.nextLine();
            }
            System.out.print("Δώσε τηλέφωνο: ");
            phone = scan.nextLine();
            while (phone.length() < 10 || !phone.matches("[0-9]+") || phone.length() > 10) {
                System.out.println("Κάνατε λάθος, ο αριθμός πρέπει να είναι 10 ψηφίων..");
                phone = scan.nextLine();
            }
            System.out.print("Δώσε E-mail: ");
            email = scan.nextLine();
            while (!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
                System.out.println("Κάνατε λάθος, το Email πρέπει να είναι της μορφής: example@exp.com ..");
                email = scan.nextLine();
            }
            System.out.print("Δώσε διεύθυνση: ");
            address = scan.nextLine();
            writeInFile();
        }


    public void printFromFile() {
        try {
        x1 = new Scanner(new File(filepath));
        x1.useDelimiter("[|\n]");
        int count=0;
        while (x1.hasNext()) {
            ++count;
            name = x1.next();
            surname = x1.next();
            phone = x1.next();
            email = x1.next();
            address = x1.next();
            System.out.println(count+". "+name + "|" + surname + "|" + phone + "|" + email + "|" + address );
        }
            System.out.println("Εμφανίστηκαν "+count+" εγραφές!");
            bmenu();
        }
        catch (Exception e) {
            System.out.println("Δεν έγινε φόρτωση αρχείου..");
            bmenu();
        }
    }
    public void deleteFromFile() {
        System.out.println("Δώσε το όνομα του ατόμου όπου θα διαγραφή η επαφή του..");
        String sname = scan.nextLine();
        while (!sname.matches("[α-ωΑ-Ω]+") && !sname.matches("[a-zA-Z]+")) {
            System.out.println("Κάνατε λάθος, το όνομα δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
            sname = scan.nextLine();
        }
        File oldfile = new File(filepath);
        File newFile = new File(tempFile);
        name = "";
        surname = "";
        phone = "";
        email = "";
        address = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x1 = new Scanner(new File(filepath));
            x1.useDelimiter("[|\n]");
            int count = 0;
            while (x1.hasNext()) {
                name = x1.next();
                surname = x1.next();
                phone = x1.next();
                email = x1.next();
                address = x1.next();
                if (!name.equals(sname)) {
                    pw.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                } else {
                    ++count;
                    System.out.println("Βρέθηκε αυτή η καταχώρηση με το όνομα, " + name + "..");
                    System.out.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                    System.out.println("Αυτή θέλετε να διαγράψετε..[y/n]");
                    String ans1 = scan.nextLine();
                    while (!ans1.equals("y") && !ans1.equals("n")) {
                        System.out.println("Δώσατε λάθος απάντηση, ξαναπροσπαθήστε!");
                        ans1 = scan.nextLine();
                    }
                    if (!ans1.equals("y")) {
                        pw.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                    } else {
                        System.out.println("Σίγουρα θέλετε να διαγραφή;..[y/n]");
                        String ans = scan.nextLine();
                        while (!ans.equals("y") && !ans.equals("n")) {
                            System.out.println("Δώσατε λάθος απάντηση, ξαναπροσπαθήστε!");
                            System.out.println("Σίγουρα θέλετε να διαγραφή;..[y/n]");
                            ans = scan.nextLine();
                        }
                        if (ans.equals("y")) {
                            x1.close();
                            pw.flush();
                            pw.close();
                            oldfile.delete();
                            File dump = new File(filepath);
                            newFile.renameTo(dump);
                            System.out.println("Διαγράφηκε..");
                            bmenu();
                        } else {
                            bmenu();
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println("Δεν υπάρχει καταχώρηση με το όνομα " + sname + "..");
                bmenu();
            } else {
                System.out.println("Δεν υπάρχει άλλη καταχώρηση με το όνομα " + sname + "..");
                bmenu();
            }
        } catch (Exception e) {
            System.out.println("Δεν έγινε φόρτωση αρχείου..");
            bmenu();
        }
    }
    public void editFromFileWithName(){
        try {
            int count = 0;
            Boolean flag = false;
            File oldfile = new File(filepath);
            File newFile = new File(tempFile);
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            System.out.println("Δώσε το όνομα του ατόμου όπου θα επεξεργαστείτε η επαφή του..");
            String findname = scan.nextLine();
            while (!findname.matches("[α-ωΑ-Ω]+") && !findname.matches("[a-zA-Z]+")) {
                System.out.println("Κάνατε λάθος, το όνομα δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                findname = scan.nextLine();
            }
            x1 = new Scanner(new File(filepath));
            x1.useDelimiter("[|\n]");
            while (x1.hasNext()) {
                name = x1.next();
                surname = x1.next();
                phone = x1.next();
                email = x1.next();
                address = x1.next();
                if (name.equals(findname) && (flag.equals(false))) {
                    System.out.println("Βρέθηκε..");
                    ++count;
                    System.out.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                    System.out.println("Αυτή θέλετε να επεξεργαστείτε;..[y/n]");
                    String ans1 = scan.nextLine();
                    while (!ans1.equals("y") && !ans1.equals("n")) {
                        System.out.println("Δώσατε λάθος απάντηση, ξαναπροσπαθήστε!");
                        ans1 = scan.nextLine();
                    }
                    if (!ans1.equals("y")) {
                        pw.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                    } else {
                        System.out.print("Δώσε όνομα: ");
                        String namet = scan.nextLine();
                        while (!namet.matches("[α-ωΑ-Ω]+") && !namet.matches("[a-zA-Z]+")) {
                            System.out.println("Κάνατε λάθος, το όνομα δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                            namet = scan.nextLine();
                        }
                        System.out.print("Δώσε επίθετο: ");
                        String surnamet = scan.nextLine();
                        while (!surnamet.matches("[α-ωΑ-Ω]+") && !surnamet.matches("[a-zA-Z]+")) {
                            System.out.println("Κάνατε λάθος, το επίθετο δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                            surnamet = scan.nextLine();
                        }
                        System.out.print("Δώσε τηλέφωνο: ");
                        String phonet = scan.nextLine();
                        while (phonet.length() < 10 || !phonet.matches("[0-9]+") || phonet.length() > 10) {
                            System.out.println("Κάνατε λάθος, ο αριθμός πρέπει να είναι 10 ψηφίων..");
                            phonet = scan.nextLine();
                        }
                        System.out.print("Δώσε E-mail: ");
                        String emailt = scan.nextLine();
                        while (!emailt.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
                            System.out.println("Κάνατε λάθος, το Email πρέπει να είναι της μορφής: example@exp.com ..");
                            emailt = scan.nextLine();
                        }
                        System.out.print("Δώσε διεύθυνση: ");
                        String addresst = scan.nextLine();
                        System.out.println("Αποθήκευση;..[y/n]");
                        String ans = scan.nextLine();
                        while (!ans.equals("y") && !ans.equals("n")) {
                            System.out.println("Δώσατε λάθος απάντηση, ξαναπροσπαθήστε!");
                            ans = scan.nextLine();
                        }
                        if (ans.equals("y")) {
                            pw.println(namet + "|" + surnamet + "|" + phonet + "|" + emailt + "|" + addresst);
                            flag = true;
                        } else {
                            pw.println(name + "|" + surname + "|" + phone + "|" + email + "|" + address);
                        }
                    }
                }
            }
            if (flag.equals(true)) {
                System.out.println("Η επεξεργασία ολοκληρώθηκε..");
                x1.close();
                pw.flush();
                pw.close();
                oldfile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
                bmenu();
            }
            if (count == 0) {
                System.out.println("Δεν υπάρχει καταχώρηση με το όνομα " + findname + "..");
                bmenu();
            } else {
                System.out.println("Δεν υπάρχει άλλη καταχώρηση με το όνομα " + findname + "..");
                bmenu();
            }}
        catch(Exception e){
                System.out.println("Δεν έγινε επεξεργασία..");
                bmenu();
            }
        }
    public  void findRecordbyname(){
        try {
            int count=0;
            System.out.println("Δώσε το όνομα του ατόμου όπου θα εμφανιστεί η επαφή του..");
            String findname = scan.nextLine();
            while (!findname.matches("[α-ωΑ-Ω]+") && !findname.matches("[a-zA-Z]+")) {
                System.out.println("Κάνατε λάθος, το όνομα δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                findname = scan.nextLine();
            }
            x1 = new Scanner(new File(filepath));
            x1.useDelimiter("[|\n]");
            while (x1.hasNext()) {
                name = x1.next();
                surname = x1.next();
                phone = x1.next();
                email = x1.next();
                address = x1.next();
                if (name.equals(findname)) {
                    ++count;
                    System.out.println(count+". "+name + "|" + surname + "|" + phone + "|" + email + "|" + address );
                }
            }
            System.out.println("Βρέθηκαν "+count+" εγραφές!");
            bmenu();
        } catch (Exception e) {
            System.out.println("Δεν έγινε φόρτωση αρχείου..");
            bmenu();
        }
    }
    public  void findRecordbyphone(){
        try {
            System.out.println("Δώσε το τηλέφωνο του ατόμου όπου θα εμφανιστεί η επαφή του..");
            String findphone = scan.nextLine();
            while (findphone.length() < 10 || !findphone.matches("[0-9]+") || findphone.length() > 10)  {
                System.out.println("Κάνατε λάθος, το τηλέφωνο δεν πρέπει να περιέχει σύμβολα ή αριθμούς..");
                findphone = scan.nextLine();
            }
            x1 = new Scanner(new File(filepath));
            x1.useDelimiter("[|\n]");
            int count=0;
            while (x1.hasNext()) {
                name = x1.next();
                surname = x1.next();
                phone = x1.next();
                email = x1.next();
                address = x1.next();
                if (phone.equals(findphone)) {
                    ++count;
                    System.out.println(count+". "+name + "|" + surname + "|" + phone + "|" + email + "|" + address );

                }
            }
            System.out.println("Βρέθηκαν "+count+" εγραφές!");
            bmenu();
        }
        catch (Exception e) {
            System.out.println("Δεν έγινε φόρτωση αρχείου..");
            bmenu();
        }
    }


    void bmenu() {
        String ans1;
        System.out.println("Επιστροφή στο Menu..[y/n]");
        ans1 = scan.nextLine();
        while (!ans1.equals("y") && !ans1.equals("n")){
            System.out.println("Δώσατε λάθος απάντηση, ξαναπροσπαθήστε!");
            System.out.println("Επιστροφή στο Menu..[y/n]");
            ans1 = scan.nextLine();
        }
        if (ans1.equals("y")) {
            menu.menu();
        }
        else {
            System.out.println("Έξοδος..");
            System.exit(0);
        }
    }
}