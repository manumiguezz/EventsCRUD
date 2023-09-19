package com.manumiguezz.springboot.EventsCRUD.dao;

import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {}
