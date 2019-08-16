package estimate.builder.Backend.data;

import java.util.ArrayList;

/**
 * User data.
 */
public class IconData {
    private ArrayList<String> email = new ArrayList<>();
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "IconData{" +
                "email=" + email +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", index=" + index +
                '}' + "\n";
    }

    private int index;

    public IconData() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public IconData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getAllEmails() {
        return this.email;
    }
}