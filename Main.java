package P1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void help() {
        System.out.println("help - Afiseaza aceasta lista de comenzi\n" +
                "add - Adauga o noua persoana (inscriere)\n" +
                "check - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove - Sterge o persoana existenta din lista\n" +
                "update - Actualizeaza detaliile unei persoane\n" +
                "guests - Lista de persoane care participa la eveniment\n" +
                "waitlist - Persoanele din lista de asteptare\n" +
                "available - Numarul de locuri libere\n" +
                "guests_no - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit - Inchide aplicatia");
    }


    public static boolean check(ArrayList<Guest> array, int nrP, int option, String searchBy) {

        GuestsList g = new GuestsList(array, nrP);
        g.setGuestList(array);
        if (g.check(array, option, searchBy)) {
            System.out.println("Persoana este inscrisa la eveniment");
            return true;
        } else {
            System.out.println("Persoana nu este inscrisa la eveniment");
            return false;
        }

    }

    public static boolean remove(GuestsList array) {

        System.out.println("Se sterge o persoana existenta din lista…");
        System.out.println("Introdu participantul pe care vrei sa il scoti din lista: " +
                "\n -nume de familie (1)" +
                "\n -prenume (2)" +
                "\n -email (3)" +
                "\n -numar de telefon (4)");

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Introduceti un nume de familie:");
                String lName = sc.next();

                array.remove(array, choice, lName);
                break;
            case 2:
                System.out.println("Introduceti un prenume:");
                String fName = sc.next();
                array.remove(array, choice, fName);
                break;
            case 3:
                System.out.println("Introduceti un email:");
                String email = sc.next();
                array.remove(array, choice, email);
                break;
            case 4:
                System.out.println("Introduceti un numar de telefon:");
                String nr = sc.next();
                array.remove(array, choice, nr);
                break;
        }
        return false;
    }

    public static void updateSearch(GuestsList guest, int opt, String searchBy1, String searchBy2) {


        Scanner sc = new Scanner(System.in);
        if (guest.getGuestList().contains(guest.updateSearch(guest.getGuestList(), opt, searchBy1, searchBy2))) {
            switch (opt) {
                case 1:
                    System.out.println("Introduceti un nume si prenume");

                    String updatedFn = sc.next();
                    String updatedLn = sc.next();
                    guest.updatedValue(guest.updateSearch(guest.getGuestList(), opt, searchBy1, searchBy2), 1, updatedFn, updatedLn);
                    break;
                case 2:
                    System.out.println("Introduceti un email");

                    String updatedEmail = sc.next();
                    guest.updatedValue(guest.updateSearch(guest.getGuestList(), opt, searchBy1, searchBy2), 1, updatedEmail);
                    break;
                case 3:
                    System.out.println("Introduceti un numar de telefon (format „+40733386463“):");

                    String updatedPhN = sc.next();
                    guest.updatedValue(guest.updateSearch(guest.getGuestList(), opt, searchBy1, searchBy2), 1, updatedPhN);
                    break;
                default:
                    System.out.println("Nu ati introdus optiune valida");
                    break;

            }
        }

    }


    public static ArrayList<Guest> guests(GuestsList guest, int nrP) {


        return guest.getGuestList();
    }

    public static int available(GuestsList guest, int nrP) {

        return guest.available(guest.getGuestList());
    }

    public static int guests_no(GuestsList guest, int nrP) {

        return guest.guests_no(guest.getGuestList());
    }

    public static int waitlist_no(GuestsList guest) {

        return guest.waitlist_no(guest.getWaitlist());
    }

    public static int subscribe_no(GuestsList guest, int nrP) {

        return guest.subscribe_no(guest.getGuestList());
    }


    public static void main(String[] args) {
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Guest> list = new ArrayList<Guest>();
        ArrayList<Guest> waitlist = new ArrayList<Guest>();
        GuestsList pers = new GuestsList(list, n, waitlist);
        pers.setNumberOfParticipants(n);
        String msj = "";

        System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
        msj = sc.next();

        while (!msj.equals("quit")) {
            switch (msj) {
                case "help":
                    help();
                    break;
                case "add":
                    System.out.println("Se adauga o noua persoana...");
                    System.out.println("Introduceti numele de familie:");
                    String ln = sc.next();
                    System.out.println("Introduceti prenumele:");
                    String fn = sc.next();
                    System.out.println("Introduceti email:");
                    String email = sc.next();
                    System.out.println("Introduceti numar de telefon (format „+40733386463“):");
                    String nr = sc.next();
                    Guest newGuest = new Guest(ln, fn, email, nr);
                    int result = pers.add(pers.getGuestList(), newGuest, n);
                    if (result == -1 || result == 0) {
                        System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                    } else if (waitlist_no(pers) > 0) {
                        System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + waitlist_no(pers) +
                                ". Te vom notofica daca un loc devine disponibil.");
                    }
                    break;
                case "check":
                    System.out.println("Alege modul de autentificare, tastand:\n" +
                            "\"1\" - Nume\n" +
                            "\"2\" - Prenume\n" +
                            "\"3\" - Email\n" +
                            "\"4\" - Numar de telefon (format \"+40733386463\")");

                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Introduceti un nume de familie:");
                            String lName = sc.next();
                            check(pers.getGuestList(), n, choice, lName);
                            break;
                        case 2:
                            System.out.println("Introduceti un prenume:");
                            String fName = sc.next();
                            check(pers.getGuestList(), n, choice, fName);
                            break;
                        case 3:
                            System.out.println("Introduceti un email:");
                            String email1 = sc.next();
                            check(pers.getGuestList(), n, choice, email1);
                            break;
                        case 4:
                            System.out.println("Introduceti un numar de telefon(format \"+40733386463\"):");
                            String nr1 = sc.next();
                            check(pers.getGuestList(), n, choice, nr1);
                            break;
                    }

                    break;
                case "remove":

                    remove(pers);
                    break;
                case "update":

                    System.out.println("Alege modul de autentificare, tastand:\n" +
                            "\"1\" - Nume si prenume\n" +
                            "\"2\" - Email\n" +
                            "\"3\" - Numar de telefon (format \"+40733386463\")");
                    int opt = sc.nextInt();

                    switch (opt) {
                        case 1:
                            System.out.println("Introduceti un nume de familie si un prenume:");
                            String lName = sc.next();
                            String fName = sc.next();
                            updateSearch(pers, opt, lName, fName);

                            break;
                        case 2:
                            System.out.println("Introduceti un email:");
                            String email1 = sc.next();
                            updateSearch(pers, opt, email1, "");
                            break;
                        case 3:
                            System.out.println("Introduceti un numar de telefon:");
                            String nr1 = sc.next();
                            updateSearch(pers, opt, nr1, "");
                            break;
                    }
                    break;
                case "guests":
                    System.out.println(guests(pers, n));
                    break;
                case "waitlist":
                    if (pers.getWaitlist().isEmpty()) {
                        System.out.println(" Lista de asteptare este goala");
                    } else {
                        System.out.println("Pe lista de asteptare ses afla: '\n'" + pers.getWaitlist());
                    }


                    break;
                case "available":

                    System.out.println("Numarul de locuri ramase: " + available(pers, n));
                    break;

                case "guests_no":
                    if (guests_no(pers, n) == 0) {
                        System.out.println("Nu este niciun participant...");
                    } else {
                        System.out.println("Numarul de participanti: " + guests_no(pers, n));
                    }
                    break;
                case "waitlist_no":

                    System.out.println("Dimensiunea listei de asteptare: " + waitlist_no(pers));
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane:" + subscribe_no(pers, n));
                    break;
                case "search":
                    System.out.println("Introdu un sir de caractere...");
                    String str = sc.next();
                    GuestsList.search(pers.getGuestList(), str);
                    System.out.println(GuestsList.search(pers.getGuestList(), str));
                    break;
            }
            msj = sc.next();
        }

    }
}


