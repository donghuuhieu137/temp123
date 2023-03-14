package com.tom.bhxhsqa.dto;

import com.tom.bhxhsqa.common.Expense;
import com.tom.bhxhsqa.entity.User;

public class UserDTO extends AbstractDTO<UserDTO> {

    private String username;
    private String cccd;
    private String fullName;
    private String dateOfBirth;
    private String phone;
    private String email;
    private Integer typeUser;
    private String address;
    private String password;

    private String coQuanBaoHiemThanhPho;
    private String coQuanBaoHiemQuanHuyen;
    private Long salary;
    private String maSoThue;
    private String tenDonVi;
    private String maDonVi;

    private Double phiBaoHiem;
    private Double phiBaoHiemDN;

    private String status;

    Expense phi = new Expense();

    public UserDTO() {
        super();
    }

    public UserDTO(User user) {
        super();
        if (user != null) {
            this.setId(user.getId());
            this.username = user.getUsername();
            this.cccd = user.getCccd();
            this.fullName = user.getFullName();
            this.dateOfBirth = user.getDateOfBirth();
            this.phone = user.getPhone();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.typeUser = user.getTypeUser();
            this.address = user.getAddress();

            this.coQuanBaoHiemThanhPho = user.getCoQuanBaoHiemThanhPho();
            this.coQuanBaoHiemQuanHuyen = user.getCoQuanBaoHiemQuanHuyen();
            this.salary = user.getSalary();
            this.maSoThue = user.getMaSoThue();
            this.tenDonVi = user.getTenDonVi();
            this.maDonVi = user.getMaDonVi();
            if (this.salary != null) {
                if (this.typeUser == 1) {
                    if (this.salary > 0 && this.salary < 4420000) {
                        this.status = "Bạn không thuộc đối tượng đóng BHXH";
                    } else if (this.salary > 29800000) {
                        this.phiBaoHiem = Expense.tinhPhiBaoHiemCaNhan(this.salary - 29800000);
                        this.phiBaoHiemDN = Expense.tinhPhiBaoHiemDN(this.salary - 29800000);
                    } else {
                        this.phiBaoHiem = Expense.tinhPhiBaoHiemCaNhan(this.salary);
                        this.phiBaoHiemDN = Expense.tinhPhiBaoHiemDN(this.salary);
                    }

                } else {
                    if (this.salary > 0 && this.salary < 700000) {
                        this.status = "Bạn không thuộc đối tượng đóng BHXH";
                    } else if (this.salary > 29800000) {
                        this.phiBaoHiem = Expense.tinhPhiBaoHiemTudo(this.salary - 29800000);
                    } else {
                        this.phiBaoHiem = Expense.tinhPhiBaoHiemTudo(this.salary);
                    }

                }
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoQuanBaoHiemThanhPho() {
        return coQuanBaoHiemThanhPho;
    }

    public void setCoQuanBaoHiemThanhPho(String coQuanBaoHiemThanhPho) {
        this.coQuanBaoHiemThanhPho = coQuanBaoHiemThanhPho;
    }

    public String getCoQuanBaoHiemQuanHuyen() {
        return coQuanBaoHiemQuanHuyen;
    }

    public void setCoQuanBaoHiemQuanHuyen(String coQuanBaoHiemQuanHuyen) {
        this.coQuanBaoHiemQuanHuyen = coQuanBaoHiemQuanHuyen;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public Double getPhiBaoHiem() {
        return phiBaoHiem;
    }

    public void setPhiBaoHiem(Double phiBaoHiem) {
        this.phiBaoHiem = phiBaoHiem;
    }

    public Double getPhiBaoHiemDN() {
        return phiBaoHiemDN;
    }

    public void setPhiBaoHiemDN(Double phiBaoHiemDN) {
        this.phiBaoHiemDN = phiBaoHiemDN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}