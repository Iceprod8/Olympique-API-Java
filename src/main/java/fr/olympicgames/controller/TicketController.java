package fr.olympicgames.controller;

import fr.olympicgames.model.*;
import fr.olympicgames.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchaseTicket")
    public ResponseEntity<?> purchaseTicket(@RequestParam Long eventId, @RequestParam Long userId, @RequestParam int quantity) {
        try {
            Ticket ticket = ticketService.purchaseTicket(eventId, userId, quantity);
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
