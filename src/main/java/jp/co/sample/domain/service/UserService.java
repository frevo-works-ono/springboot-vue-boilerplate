package jp.co.sample.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.model.User;
import jp.co.sample.domain.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(int userId) {
        return userRepository.findByUserId(userId);
    }

    public User save(User entry) {
        return userRepository.save(entry);
    }
}
