package com.example.olympicgames.repository;

import com.example.olympicgames.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // TODO: Add ticket-specific queries
}
