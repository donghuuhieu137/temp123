package com.tom.bhxhsqa.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_thanhtoan")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "id_seq", sequenceName = "item_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_thanh_toan")
    private String ngayThanhToan;

    @Column(name = "so_tien")
    private Double soTien;

    @Column(name = "ngan_hang")
    private String nganHang;

    @Column(name = "chi_nhanh_ngan_hang")
    private String chiNhanhNganHang;

    @Column(name = "ma_giao_dich")
    private String code;

    @Column(name = "loai_giao_dich")
    private Integer loaiGiaoDich;

    public Payment() {
        // TODO Auto-generated constructor stub
    }

    public Payment(User user, String noiDung, String ngayThanhToan, Double soTien, String nganHang,
                     String chiNhanhNganHang, String code, Integer loaiGiaoDich) {
        super();
        this.user = user;
        this.noiDung = noiDung;
        this.ngayThanhToan = ngayThanhToan;
        this.soTien = soTien;
        this.nganHang = nganHang;
        this.chiNhanhNganHang = chiNhanhNganHang;
        this.code = code;
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getChiNhanhNganHang() {
        return chiNhanhNganHang;
    }

    public void setChiNhanhNganHang(String chiNhanhNganHang) {
        this.chiNhanhNganHang = chiNhanhNganHang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(Integer loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

}