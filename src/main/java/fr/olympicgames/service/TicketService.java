package fr.olympicgames.service;

import fr.olympicgames.model.*;
import fr.olympicgames.repository.*;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Ticket purchaseTicket(Long eventId, Long userId, int quantity) throws Exception {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (!eventOptional.isPresent()) {
            throw new Exception("Event not found");
        }

        Event event = eventOptional.get();

        List<Ticket> userTickets = ticketRepository.findByUserIdAndEventDate(userId, event.getDate());
        if (!userTickets.isEmpty()) {
            throw new Exception("User already registered for an event on this date");
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new Exception("User not found");
        }

        User user = userOptional.get();

        Order order = new Order();
        order.setUser(user);
        order.setEvent(event);
        order.setQuantity(quantity);
        if (quantity > 1) {
            order.setTotalPrice(event.getPrice() * quantity * 0.9);
        } else {
            order.setTotalPrice(event.getPrice() * quantity);
        }
        orderRepository.save(order);

        for (int i = 0; i < quantity; i++) {
            Ticket ticket = new Ticket();
            ticket.setEvent(event);
            ticket.setUser(user);
            ticket.setOrder(order);
            ticketRepository.save(ticket);
        }

        return new Ticket();
    }
}
