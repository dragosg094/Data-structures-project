package P1;

import java.util.ArrayList;
import java.util.Scanner;


public class GuestsList {

    private ArrayList<Guest> guestList;
    private ArrayList<Guest> waitlist;

    private int numberOfParticipants;
    public Scanner sc = new Scanner(System.in);

    public GuestsList(ArrayList<Guest> guestList, int numberOfParticipants, ArrayList<Guest> waitlist) {
        this.guestList = guestList;
        this.numberOfParticipants = numberOfParticipants;
        this.waitlist = waitlist;
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public GuestsList(ArrayList<Guest> guestList, int numberOfParticipants) {
        this.guestList = guestList;
        this.numberOfParticipants = numberOfParticipants;
    }

    public ArrayList<Guest> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(ArrayList<Guest> guestList) {
        this.waitlist = guestList;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {

        this.numberOfParticipants = numberOfParticipants;
        guestList.ensureCapacity(numberOfParticipants);
    }

    public Guest searchByLastName(ArrayList<Guest> list, String lName) {


        setGuestList(list);
        for (Guest i : list) {
            if (i.getLastName().toLowerCase().equals(lName)) {
                return i;
            }
        }
        Guest noParticipant = new Guest("-", "-", "-", "-");
        return noParticipant;
    }

    public Guest searchByFirstName(ArrayList<Guest> list, String fName) {

        setGuestList(list);
        Guest noParticipant = new Guest("-", "-", "-", "-");
        for (Guest i : list) {
            if (i.getFirstName().toLowerCase().equals(fName)) {

                return i;
            }
        }
        return noParticipant;
    }

    public Guest searchByEmail(ArrayList<Guest> list, String email) {

        setGuestList(list);
        for (Guest i : list) {
            if (i.getEmail().toLowerCase().equals(email)) {
                return i;
            }
        }
        Guest noParticipant = new Guest("-", "-", "-", "-");
        return noParticipant;
    }

    public Guest searchByPhoneNumber(ArrayList<Guest> list, String nr) {

        setGuestList(list);

        for (Guest i : list) {
            if (i.getPhoneNumber().toLowerCase().equals(nr)) {
                return i;
            }
        }
        Guest noParticipant = new Guest("-", "-", "-", "-");
        return noParticipant;
    }

    public int add(ArrayList<Guest> list, Guest guest, int nrP) {
        ArrayList<Guest> wList = new ArrayList<>();
        GuestsList waitL = new GuestsList(getGuestList(), nrP, wList);

        setGuestList(list);
        if (getGuestList().isEmpty() || getGuestList() == null) {
            getGuestList().add(guest);
            this.guestList = list;
            return 0;
        } else if (getGuestList().size() >= nrP) {
            wList = list;
            getGuestList().add(guest);
            if (getWaitlist().isEmpty() || getWaitlist() == null) {
                waitL.getWaitlist().add(guest);
                this.waitlist = waitL.getWaitlist();
                return waitL.getWaitlist().size();
            } else {
                for (Guest i : list) {
                    if (i.getLastName().equals(guest.getLastName()) && i.getFirstName().equals(guest.getFirstName())) {

                        return -1;
                    } else {
                        wList.add(guest);
                        setWaitlist(wList);
                        return 0;
                    }
                }
            }
            for (Guest i : list) {
                if (i.getLastName().equals(guest.getLastName()) && i.getFirstName().equals(guest.getFirstName())) {

                    return -1;
                } else {
                    list.add(guest);
                    setGuestList(list);
                    return 0;
                }
            }
        }
        return -1;
    }


    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }

    public boolean check(ArrayList<Guest> lst, int option, String searchBy) {

        this.guestList = lst;


        if (option == 1) {

            if (!getGuestList().contains(searchByLastName(lst, searchBy))) {
                return false;
            } else {
                return true;
            }
        }
        if (option == 2) {

            if (getGuestList().contains(searchByFirstName(lst, searchBy))) {
                return true;
            } else {
                return false;
            }
        }
        if (option == 3) {

            if (getGuestList().contains(searchByEmail(lst, searchBy))) {
                return true;
            } else {
                return false;
            }
        }
        if (option == 4) {

            if (getGuestList().contains(searchByPhoneNumber(lst, searchBy))) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }


    public boolean remove(GuestsList guest, int option, String searchBy) {


        switch (option) {
            case 1:

                if (guest.getGuestList().contains(searchByLastName(guest.getGuestList(), searchBy))) {
                    Guest pers = searchByLastName(guest.getGuestList(), searchBy);
                    this.guestList.remove(searchByLastName(guest.getGuestList(), searchBy));

                    if (guest.getWaitlist().contains(searchByLastName(guest.getWaitlist(), searchBy))) {
                        pers = searchByLastName(guest.getWaitlist(), searchBy);
                        this.waitlist.remove(searchByLastName(guest.getWaitlist(), searchBy));


                    }
                    System.out.println("Participantul " + pers + " a fost sters din lista");
                    return true;

                } else {
                    return false;
                }
            case 2:

                if (guest.getGuestList().contains(searchByFirstName(guest.getGuestList(), searchBy))) {
                    Guest pers = searchByLastName(guest.getGuestList(), searchBy);
                    this.guestList.remove(searchByFirstName(guest.getGuestList(), searchBy));

                    System.out.println("Participantul " + pers + " a fost sters din lista");
                    if (guest.getWaitlist().contains(searchByFirstName(guest.getWaitlist(), searchBy))) {
                        pers = searchByLastName(guest.getWaitlist(), searchBy);
                        this.waitlist.remove(searchByFirstName(guest.getWaitlist(), searchBy));
                        System.out.println("Participantul " + pers + " a fost sters din lista");
                    }
                } else {
                    return false;
                }
            case 3:

                if (guest.getGuestList().contains(searchByEmail(guest.getGuestList(), searchBy))) {
                    Guest pers = searchByEmail(guest.getGuestList(), searchBy);
                    this.guestList.remove(searchByEmail(guest.getGuestList(), searchBy));
                    System.out.println("Participantul " + pers + " a fost sters din lista");
                    if (guest.getWaitlist().contains(searchByEmail(guest.getWaitlist(), searchBy))) {
                        pers = searchByEmail(guest.getWaitlist(), searchBy);
                        this.waitlist.remove(searchByEmail(guest.getWaitlist(), searchBy));
                        System.out.println("Participantul " + pers + " a fost sters din lista");
                    }
                } else {
                    return false;
                }
            case 4:

                if (guest.getGuestList().contains(searchByPhoneNumber(guest.getGuestList(), searchBy))) {
                    Guest pers = searchByLastName(guest.getGuestList(), searchBy);
                    this.guestList.remove(searchByPhoneNumber(guest.getGuestList(), searchBy));
                    System.out.println("Participantul " + pers + " a fost sters din lista");
                    if (guest.getWaitlist().contains(searchByPhoneNumber(guest.getWaitlist(), searchBy))) {
                        pers = searchByPhoneNumber(guest.getWaitlist(), searchBy);
                        this.waitlist.remove(searchByPhoneNumber(guest.getWaitlist(), searchBy));
                        System.out.println("Participantul " + pers + " a fost sters din lista");
                    }
                } else {
                    return false;
                }

        }
        return false;
    }

    public Guest updateSearch(ArrayList<Guest> list, int opt, String searchBy1, String searchBy2) {


        this.guestList = list;


        switch (opt) {
            case 1:
                if (list.contains(searchByLastName(list, searchBy1)) && list.contains(searchByFirstName(list, searchBy2))) {
                    if (searchByLastName(list, searchBy1) == searchByFirstName(list, searchBy2))

                        return searchByLastName(list, searchBy1);
                }
                break;


            case 2:

                if (list.contains(searchByEmail(list, searchBy1))) {
                    Guest guest = searchByEmail(list, searchBy1);
                    return guest;

                }
                break;
            case 3:

                if (list.contains(searchByPhoneNumber(list, searchBy1))) {
                    Guest guest = searchByPhoneNumber(list, searchBy1);
                    return guest;

                }
                break;
            default:
                System.out.println("Ai introdus o valoare incorecta");
                break;
        }
        return null;
    }

    public static void updatedValue(Guest g, int option, String searchBy1, String searchBy2) {
        if (option == 1) {
            g.setLastName(searchBy1);
            g.setFirstName(searchBy2);

        }
    }

    public static void updatedValue(Guest g, int option, String searchBy1) {

        switch (option) {
            case 1:
                g.setEmail(searchBy1);
                break;
            case 2:
                g.setPhoneNumber(searchBy1);
                break;
            default:
                System.out.println("Ai introdus o valoare incorecta");
                break;
        }


    }

    public ArrayList<Guest> guests(ArrayList<Guest> list) {

        this.guestList = list;
        return list;
    }

    public ArrayList<Guest> waitlist(ArrayList<Guest> list, int nrP) {

        if (list.size() > nrP) {
            for (int i = 0; i < nrP; i++) {
                list.remove(list.get(i));

            }
            this.waitlist = list;
            return this.waitlist;
        }
        return null;


    }

    public int available(ArrayList list) {


        if (list.size() < this.numberOfParticipants) {
            int available = list.size() - this.numberOfParticipants;
            return Math.abs(available);
        }
        return 0;
    }

    public int guests_no(ArrayList list) {

        this.guestList = list;

        return list.size();


    }

    public int waitlist_no(ArrayList list) {


        return list.size();
    }


    public int subscribe_no(ArrayList list) {

        this.guestList = list;

        return this.guestList.size();
    }

    public static ArrayList<Guest> search(ArrayList<Guest> list, String searchFor) {

        ArrayList<Guest> result = new ArrayList<>();

        for (Guest g : list) {
            if (g.getLastName().toLowerCase().contains(searchFor) ||
                    g.getFirstName().toLowerCase().contains(searchFor) ||
                    g.getEmail().toLowerCase().contains(searchFor) || g.getPhoneNumber().toLowerCase().contains(searchFor)) {
                result.add(g);
            }
        }
        return result;
    }
}

