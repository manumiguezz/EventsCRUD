package com.manumiguezz.springboot.EventsCRUD.dao;


import com.manumiguezz.springboot.EventsCRUD.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class RoleDaoImpl implements RoleDao {

    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findByRoleName(String theRoleName) {

        TypedQuery<Role> theQuery = entityManager.createQuery("from Role where roleName=:uRole", Role.class);
        theQuery.setParameter("uRole", theRoleName);

        Role theRole = null;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }
}
