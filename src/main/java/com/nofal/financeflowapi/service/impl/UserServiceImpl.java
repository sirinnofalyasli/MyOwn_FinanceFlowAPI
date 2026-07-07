package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.repository.UserRepository;
import com.nofal.financeflowapi.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
}
