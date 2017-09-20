package jp.co.sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(Integer userId);

    public User findByMailaddress(String mailaddress);
}
