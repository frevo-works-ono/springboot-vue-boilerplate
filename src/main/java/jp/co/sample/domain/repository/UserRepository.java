package jp.co.sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sample.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByMailaddress(String mailaddress);
}
