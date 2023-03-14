package com.tom.bhxhsqa.service.impl;

import com.tom.bhxhsqa.dto.UserDTO;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.UserService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @PersistenceContext protected EntityManager entityManager;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository injectedBean) {
        this.userRepository = injectedBean;
    }

    @Override
    public UserDTO getCurrentUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDTO dto = new UserDTO(user.get());
        return dto;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public long login(String username, String password) {
        User user = userRepository.findOneByUsername(username);
        if(user.getId() != null){
            if(Objects.equals(password, user.getPassword())){
                return user.getId();
            }
        }
        return -1;
    }

	@Override
	public User getUserByName(String name) {
		User user = userRepository.findOneByUsername(name);
        if(user.getId() != null){
            return user;
        }
        return null;
	}

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void updateUserInfo(User user){
        String sql = "UPDATE `bhxh_ptit`.`tbl_user` " +
                "SET `full_name` = '"+ user.getFullName() + "', "
                + "`cccd` = '"+ user.getCccd() + "', "
                + "`ma_so_thue` = '"+ user.getMaSoThue() + "', "
                + "`address` = '"+ user.getAddress() + "', "
                + "`phone` = '"+ user.getPhone() + "', "
                + "`email` = '"+ user.getEmail() + "', "
                + "`cqbh_thanh_pho` = '"+ user.getCoQuanBaoHiemThanhPho() + "', "
                + "`salary` = "+ user.getSalary() +" "
                + "WHERE id = " +user.getId();
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Override
    public void addUserToCompany(User user, Long companyAccountId) {
        User companyAccount = userRepository.findById(companyAccountId).get();
        String maDonVi = companyAccount.getMaDonVi();
        user.setMaDonVi(maDonVi);
        userRepository.save(user);
    }

    @Override
    public List<User> getUserByMaDonVi(String maDonVi) {
        String sql = "SELECT * FROM tbl_user AS u WHERE u.ma_don_vi = '"+ maDonVi +"' AND u.is_company_account != true";
        Query query = entityManager.createNativeQuery(sql, User.class);
        return query.getResultList();
    }

    @Override
    public Boolean removeUser(User currentUser, User removedUser) {
        if (currentUser.getMaDonVi().equalsIgnoreCase(removedUser.getMaDonVi()) && currentUser.getIsCompanyAccount() == true){
            userRepository.deleteById(removedUser.getId());
            return true;
        }
        return false;
    }
}
