package com.manumiguezz.springboot.EventsCRUD.dao;

import com.manumiguezz.springboot.EventsCRUD.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Integer> {}
