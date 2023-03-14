package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.dto.RegisterDTO;
import com.tom.bhxhsqa.entity.Company;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.CompanyRepository;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository injectedBean, CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
		this.userRepository = injectedBean;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model){
        return "register";
    }
    
    @RequestMapping(value="/register-personal", method = RequestMethod.GET)
    public String showRegisterPersonalPage(ModelMap model){
        return "register-personal";
    }
    
    @RequestMapping(value="/register-company", method = RequestMethod.GET)
    public String showRegisterCompanyPage(ModelMap model){
        return "register-company";
    }
    
    @RequestMapping(value="/register-company", method = RequestMethod.POST)
    public String showHomePage(
            ModelMap model,
            HttpServletRequest request
    ){
    	String randomUnitCode = UUID.randomUUID().toString();
    	randomUnitCode = randomUnitCode.substring(0, Math.min(randomUnitCode.length(), 8));
    	Company company = new Company();
        company.setName(request.getParameter("company_name"));
        company.setAddress(request.getParameter("address"));
        company.setEmail(request.getParameter("email"));
        company.setPhone(request.getParameter("phone_number"));
        company.setRepresentative(request.getParameter("representative"));
        company.setTaxCode(request.getParameter("tax_code"));
        company.setUnitCode(randomUnitCode.toUpperCase());
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone_number"));
        user.setIsCompanyAccount(true);
        user.setMaDonVi(randomUnitCode.toUpperCase());

            try {
                userRepository.save(user);
                companyRepository.save(company);
                return "redirect:login";
            } catch (Exception e){
                e.printStackTrace();
                return "register";
            }
    }


    @RequestMapping(value="/register-personal", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpServletRequest request
    ){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername(request.getParameter("username"));
        registerDTO.setPassword(request.getParameter("password"));
        registerDTO.setFullName(request.getParameter("full_name"));
        registerDTO.setCccd(request.getParameter("citizen_id"));
        registerDTO.setAddress(request.getParameter("address"));
        registerDTO.setPhone(request.getParameter("phone_number"));
        registerDTO.setEmail(request.getParameter("email"));

        User user = new User();
        if(validInfo(registerDTO, model, request)){
            user.setUsername(registerDTO.getUsername());
            user.setPassword(registerDTO.getPassword());
            user.setFullName(registerDTO.getFullName());
            user.setCccd(registerDTO.getCccd());
            user.setAddress(registerDTO.getAddress());
            user.setPhone(registerDTO.getPhone());
            user.setEmail(registerDTO.getEmail());
            user.setIsCompanyAccount(false);

            try {
                userRepository.save(user);
                return "redirect:login";
            } catch (Exception e){
                e.printStackTrace();
                return "register";
            }
        } else {
            return "register";
        }
    }

    Boolean validInfo(RegisterDTO registerDTO, ModelMap model, HttpServletRequest request){
        if(!registerDTO.getUsername().isEmpty()){
            if(registerDTO.getUsername().length() < 6){
                model.put("errorMessage", "Tên đăng nhập phải chứa từ 6 kí tự");
                return false;
            }
        } else {
            model.put("errorMessage", "Tên đăng nhập không được để trống");
            return false;
        }

        if(!registerDTO.getPassword().isEmpty()){
            if(registerDTO.getPassword().length() < 6){
                model.put("errorMessage", "Mật khẩu phải chứa từ 6 kí tự");
                return false;
            } else {
                if (!registerDTO.getPassword().equals(request.getParameter("confirm_password"))) {
                    model.put("errorMessage", "Mật khẩu không khớp");
                    return false;
                }
            }
        } else {
            model.put("errorMessage", "Vui lòng nhập mật khẩu");
            return false;
        }

        if(registerDTO.getFullName().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập Họ và tên");
            return false;
        }

        if(registerDTO.getCccd().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập số CCCD/CMND/Hộ chiếu");
            return false;
        }

        if(registerDTO.getAddress().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập địa chỉ");
            return false;
        }

        if(registerDTO.getPhone().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập số điện thoại");
            return false;
        }

        if(registerDTO.getEmail().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập thư điện tử");
            return false;
        }
        return true;
    }
}
