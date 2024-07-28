package cn.pbx.cs2.data.repository;

import cn.pbx.cs2.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.phone = ?1")
    Optional<User> findByPhone(String phone);
}