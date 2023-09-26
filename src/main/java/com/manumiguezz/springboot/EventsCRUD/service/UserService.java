package com.manumiguezz.springboot.EventsCRUD.service;

import com.manumiguezz.springboot.EventsCRUD.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

}
