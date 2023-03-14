package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.entity.Payment;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.CompanyRepository;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.PaymentService;
import com.tom.bhxhsqa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/homepage-personal", method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return "homepage-personal";
    }

    @RequestMapping(value = "/homepage-company", method = RequestMethod.GET)
    public String showPersonalInsurance(ModelMap model, HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("id").toString());
        User user = userService.findById(userId);
        List<User> users = userService.getUserByMaDonVi(user.getMaDonVi());
        model.addAttribute("users", users);
        return "homepage-company";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.GET)
    public String showUpdateInfoPersonal(ModelMap model,HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("id").toString());
        User user = userService.findById(userId);
        System.out.println(user.getFullName());
        model.addAttribute("user",user);
        return "update-info-personal";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.POST)
    public String updateInfoPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        user.setFullName(request.getParameter("full_name"));
        user.setCccd(request.getParameter("citizen_id"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));
        user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
        user.setMaSoThue(request.getParameter("tax_code"));
        user.setSalary(Long.parseLong(request.getParameter("salary")));

        userService.updateUserInfo(user);
        return "redirect:homepage-personal";
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.GET)
    public String showPaymentPersonal(ModelMap model) {
        return "payment-personal";
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.POST)
    public void paymentPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        Payment payment = new Payment();
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        payment.setUser(user);
        payment.setChiNhanhNganHang(request.getParameter("branch"));
        payment.setLoaiGiaoDich(1);
        payment.setNganHang(request.getParameter("bank_name"));
        payment.setNoiDung(request.getParameter("content"));
        payment.setNgayThanhToan(request.getParameter("payment_date"));
        payment.setSoTien(Double.parseDouble(request.getParameter("payment_amount")));

        paymentService.thanhToan(payment);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUserToCompany(
            ModelMap model
    ) {
        return "add-user";
    }

    @RequestMapping(value = {"/company-remove-user/{id}"}, method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") Long id, ModelMap model, HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("id").toString());
        User currentUser = userService.findById(userId);
        User user = userService.findById(id);
        Boolean result = userService.removeUser(currentUser, user);
        return "homepage-company";
    }

    @RequestMapping(value = {"/company-update-user/{id}"}, method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update-user-company";
    }

    @RequestMapping(value = {"/company-update-user/{id}"}, method = RequestMethod.POST)
    public String updateUserInfo(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
        User user = new User();
        user.setId(id);
        user.setFullName(request.getParameter("full_name"));
        user.setCccd(request.getParameter("citizen_id"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));
        user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
        user.setMaSoThue(request.getParameter("tax_code"));
        user.setSalary(Long.parseLong(request.getParameter("salary")));

        userService.updateUserInfo(user);
        return "homepage-company";
    }
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUserToCompany(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        String randomUsername = UUID.randomUUID().toString();
        randomUsername = randomUsername.substring(0, Math.min(randomUsername.length(), 8)).toUpperCase();
        String randomPassword = UUID.randomUUID().toString();
        randomPassword = randomPassword.substring(0, Math.min(randomPassword.length(), 8)).toUpperCase();
        User user = new User();
        Long companyAccountId = Long.parseLong(session.getAttribute("id").toString());
        user.setFullName(request.getParameter("full_name"));
        user.setCccd(request.getParameter("citizen_id"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));
        user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
        user.setMaSoThue(request.getParameter("tax_code"));
        user.setSalary(Long.parseLong(request.getParameter("salary")));
        user.setUsername(randomUsername);
        user.setPassword(randomPassword);
        user.setIsCompanyAccount(false);

        userService.addUserToCompany(user,companyAccountId);
        return "redirect:/homepage-company";
    }
}
