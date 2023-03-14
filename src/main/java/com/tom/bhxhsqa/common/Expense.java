package com.tom.bhxhsqa.common;

import java.util.List;

public class Expense {
    public static Double tinhPhiBaoHiemCaNhan(Long luong) {
        if (luong <= 0) {
            return 0.0;
        } else if (luong > 0 && luong < 4420000) {
            return 1.0;
        } else if(luong > 29800000) {
            return 2.0;
        } else {
            return luong * 0.08;
        }
    }

    public static Double tinhPhiBaoHiemDN(Long luong) {
        if (luong <= 0) {
            return 0.0;
        } else if (luong > 0 && luong < 4420000) {
            return 1.0;
        } else if(luong > 29800000) {
            return 2.0;
        } else {
            return luong * 0.175;
        }
    }

    public static Double tinhPhiBaoHiemTudo(Long luong) {
        if (luong <= 0) {
            return 0.0;
        } else if (luong > 29800000) {	// 20 thang luong co so
            return 1.0;
        } else if(luong > 0 && luong < 700000) {
            return 2.0;
        } else {
            return luong * 0.22;
        }
    }

    public static Long tongLuong(List<Long> list) {
        Long tong = 0L;
        for(Long i : list) {
            tong += i;
        }
        return tong;
    }
}