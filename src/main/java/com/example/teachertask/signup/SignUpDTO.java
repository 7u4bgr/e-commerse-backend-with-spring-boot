package com.example.teachertask.signup;

import com.example.teachertask.role.Role;

public class SignUpDTO {

    private String organizationName;
    private String phoneNumber;
    private String adress;
    private String userName;
    private String email;
    private String password;
    private Role role;
    public SignUpDTO(String organizationName, String phoneNumber, String adress, String userName, String email, String password,Role role) {

        this.organizationName = organizationName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;

    }


    public String getOrganizationName() {
        return organizationName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
}
