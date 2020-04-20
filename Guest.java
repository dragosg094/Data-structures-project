package P1;

import java.util.Objects;

public class Guest {



    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(getLastName(), guest.getLastName()) &&
                Objects.equals(getFirstName(), guest.getFirstName()) &&
                Objects.equals(getEmail(), guest.getEmail()) &&
                Objects.equals(getPhoneNumber(), guest.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getFirstName(), getEmail(), getPhoneNumber());
    }

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Guest() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Nume:" + lastName + " "
                + firstName +
                ", Email: " + email +
                ", Telefon: " + phoneNumber;
    }
}