package fr.olympicgames.dto;

import lombok.Data;

@Data
public class TicketPurchaseRequest {
    private Long eventId;
    private Long userId;
    private int quantity;
}
