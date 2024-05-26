package fr.olympicgames.service;

import fr.olympicgames.model.Ticket;
import fr.olympicgames.model.Event;
import fr.olympicgames.repository.TicketRepository;
import fr.olympicgames.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicketById(id);
        ticket.setAvailableTickets(ticketDetails.getAvailableTickets());
        ticket.setEvent(ticketDetails.getEvent());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }

    public Ticket createTicketForEvent(Long eventId, int availableTickets) throws Exception {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception("Event not found"));

        Ticket ticket = new Ticket();
        ticket.setEvent(event);
        ticket.setAvailableTickets(availableTickets);
        return ticketRepository.save(ticket);
    }

    public void updateTicketAvailability(Long eventId, int quantity) throws Exception {
        Ticket ticket = ticketRepository.findByEventId(eventId)
                .orElseThrow(() -> new Exception("Tickets not available for this event"));

        if (ticket.getAvailableTickets() < quantity) {
            throw new Exception("Not enough tickets available");
        }

        ticket.setAvailableTickets(ticket.getAvailableTickets() - quantity);
        ticketRepository.save(ticket);
    }
}
