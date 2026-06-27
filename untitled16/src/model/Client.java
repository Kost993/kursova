package model;

import java.io.Serializable;

public class Client implements Serializable {

    private int id;
    private String fullName;
    private String phone;
    private String email;

    private Membership membership;

    public Client(int id,
                  String fullName,
                  String phone,
                  String email) {

        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {

        String membershipInfo =
                membership == null
                        ? "Немає абонемента"
                        : membership.toString();

        return "\nID: " + id +
                "\nПІБ: " + fullName +
                "\nТелефон: " + phone +
                "\nEmail: " + email +
                "\nАбонемент: " + membershipInfo;
    }
}