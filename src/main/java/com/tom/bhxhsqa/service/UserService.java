package com.tom.bhxhsqa.service;

import com.tom.bhxhsqa.dto.UserDTO;
import com.tom.bhxhsqa.entity.Payment;
import com.tom.bhxhsqa.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserDTO getCurrentUser(Long id);

    public User getUserByName(String name);

    public User findById(Long id);

    public void save(User user);

    public long login(String username, String password);

    public void updateUserInfo(User user);

    public void addUserToCompany(User user, Long companyAccountId);

    public List<User> getUserByMaDonVi(String maDonVi);

    public Boolean removeUser(User currentUser, User removedUser);
}
