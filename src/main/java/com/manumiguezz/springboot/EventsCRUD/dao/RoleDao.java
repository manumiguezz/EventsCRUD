package com.manumiguezz.springboot.EventsCRUD.dao;

import com.manumiguezz.springboot.EventsCRUD.entity.Role;

public interface RoleDao {

    Role findByRoleName (String roleName);
}
