package com.manumiguezz.EventsCRUD.dao;

import com.manumiguezz.EventsCRUD.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Integer> {}
