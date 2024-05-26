package fr.olympicgames.service;

import fr.olympicgames.model.Order;
import fr.olympicgames.model.Event;
import fr.olympicgames.model.User;
import fr.olympicgames.model.Ticket;
import fr.olympicgames.repository.OrderRepository;
import fr.olympicgames.repository.EventRepository;
import fr.olympicgames.repository.UserRepository;
import fr.olympicgames.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public Order createOrder(Long eventId, Long userId, int quantity) throws Exception {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception("Event not found"));

        List<Order> userOrders = orderRepository.findByUserIdAndEventDate(userId, event.getDate());
        if (!userOrders.isEmpty()) {
            throw new Exception("User already registered for an event on this date");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        Ticket ticket = ticketRepository.findByEventId(eventId)
                .orElseThrow(() -> new Exception("Tickets not found for event"));

        if (ticket.getAvailableTickets() < quantity) {
            throw new Exception("Not enough tickets available");
        }

        double totalPrice = event.getPrice() * quantity;
        if (quantity > 1) {
            totalPrice *= 0.9;
        }

        Order order = new Order();
        order.setUser(user);
        order.setEvent(event);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);

        ticket.setAvailableTickets(ticket.getAvailableTickets() - quantity);
        ticketRepository.save(ticket);

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
