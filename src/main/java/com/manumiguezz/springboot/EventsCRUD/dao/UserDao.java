package com.manumiguezz.springboot.EventsCRUD.dao;

import com.manumiguezz.springboot.EventsCRUD.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}