package com.nofal.financeflowapi.service;

import com.nofal.financeflowapi.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User findById(Long id);

    void delete(Long id);

    User update(Long id, User user);


}
