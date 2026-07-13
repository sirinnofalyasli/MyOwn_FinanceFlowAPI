package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.entity.User;
import com.nofal.financeflowapi.repository.UserRepository;
import com.nofal.financeflowapi.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public User update(Long id, User user){
        User existingUser =
                userRepository.findById(id).orElseThrow(()
                        -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setCreatedAt(user.getCreatedAt());

        return userRepository.save(existingUser);
    }


}
