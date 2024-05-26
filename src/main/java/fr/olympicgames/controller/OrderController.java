package fr.olympicgames.controller;

import fr.olympicgames.dto.TicketPurchaseRequest;
import fr.olympicgames.model.Order;
import fr.olympicgames.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> purchaseTickets(@RequestBody TicketPurchaseRequest request) {
        if (request.getEventId() == null || request.getUserId() == null || request.getQuantity() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            Order order = orderService.createOrder(request.getEventId(), request.getUserId(), request.getQuantity());
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
