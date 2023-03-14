package com.tom.bhxhsqa.dto;

import com.tom.bhxhsqa.entity.User;

public class RegisterDTO extends AbstractDTO<RegisterDTO> {

    private String username;
    private String cccd;
    private String fullName;
    private String password;
    private String dateOfBirth;
    private String phone;
    private String email;
    private Integer typeUser;
    private String address;

    public RegisterDTO() {
        super();
    }

    public RegisterDTO(User user) {
        super();
        this.setId(user.getId());
        this.username = user.getUsername();
        this.cccd = user.getCccd();
        this.fullName = user.getFullName();
        this.dateOfBirth = user.getDateOfBirth();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.typeUser = user.getTypeUser();
        this.address = user.getAddress();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

}