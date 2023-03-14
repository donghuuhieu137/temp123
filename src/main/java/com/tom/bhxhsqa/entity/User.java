package com.tom.bhxhsqa.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "cccd")
    @NotNull
    private String cccd;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "full_name")
    @NotNull
    private String fullName;

    @Column(name = "date_of_birth")
    @NotNull
    private String dateOfBirth;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "email")
    @NotNull
    private String email;
    
    @Column(name = "is_company_account")
    private Boolean isCompanyAccount;

    // Thong tin khai bao
    
    @Column(name = "type_user") // 1: Hop dong, 2: tu do
    private Integer typeUser;

    @Column(name = "cqbh_thanh_pho")
    private String coQuanBaoHiemThanhPho;

    @Column(name = "cqbh_quan_huyen")
    private String coQuanBaoHiemQuanHuyen;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "ma_so_thue")
    private String maSoThue;

    @Column(name = "ten_don_vi")
    private String tenDonVi;

    @Column(name = "ma_don_vi")
    private String maDonVi;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> thanhtoans = new ArrayList<>();

    public User() {
    }

    public User(String username, String cccd, String fullName, String dateOfBirth, String password, String phone,
                String email, String address, Integer typeUser, String coQuanBaoHiemThanhPho,
                String coQuanBaoHiemQuanHuyen, Long salary, String maSoThue, String tenDonVi, String maDonVi) {
        super();
        this.username = username;
        this.cccd = cccd;
        this.address = address;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.typeUser = typeUser;
        this.coQuanBaoHiemThanhPho = coQuanBaoHiemThanhPho;
        this.coQuanBaoHiemQuanHuyen = coQuanBaoHiemQuanHuyen;
        this.salary = salary;
        this.maSoThue = maSoThue;
        this.tenDonVi = tenDonVi;
        this.maDonVi = maDonVi;
    }

    public Boolean getIsCompanyAccount() {
		return isCompanyAccount;
	}

	public void setIsCompanyAccount(Boolean isCompanyAccount) {
		this.isCompanyAccount = isCompanyAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Payment> getThanhtoans() {
        return thanhtoans;
    }

    public void setThanhtoans(List<Payment> thanhtoans) {
        this.thanhtoans = thanhtoans;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cccd='" + cccd + '\'' +
                ", address='" + address + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", typeUser=" + typeUser +
                ", coQuanBaoHiemThanhPho='" + coQuanBaoHiemThanhPho + '\'' +
                ", coQuanBaoHiemQuanHuyen='" + coQuanBaoHiemQuanHuyen + '\'' +
                ", salary=" + salary +
                ", maSoThue='" + maSoThue + '\'' +
                ", tenDonVi='" + tenDonVi + '\'' +
                ", maDonVi='" + maDonVi + '\'' +
                ", thanhtoans=" + thanhtoans +
                '}';
    }
}
