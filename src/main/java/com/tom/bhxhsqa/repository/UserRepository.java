package com.tom.bhxhsqa.repository;

import com.tom.bhxhsqa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT nextval('item_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    Optional<User> findByUsername(String username);

    public User findOneByUsername(String username);

    public User findOneByPassword(String password);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

    public Boolean existsByPhone(String phone);

    public Boolean existsByCccd(String cccd);

    public Boolean existsByMaSoThue(String maSoThue);

}
