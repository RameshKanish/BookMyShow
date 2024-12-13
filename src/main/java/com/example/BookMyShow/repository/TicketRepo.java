package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepo extends JpaRepository<Ticket , Integer> {

}
