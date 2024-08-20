package br.com.manualdaprogramacao.helpdesk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "tickets_interaction")
public class TicketInteractionEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn (name="ticket_id")
    private TicketEntity ticket;

    @ManyToOne
    @JoinColumn (name="sent_by_user_id")
    private UserEntity sentByUser;

    private String message;

    @ManyToOne
    @JoinColumn (name = "created_by")
    private UserEntity createdBy;

    @Column(name = "created_at")
    private Date createAt;


    @JoinColumn(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;
}
