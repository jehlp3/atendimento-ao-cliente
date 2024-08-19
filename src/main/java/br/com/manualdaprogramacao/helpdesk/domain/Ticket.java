package br.com.manualdaprogramacao.helpdesk.domain;

import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Ticket {

    private UUID id;

    private User supportUser;

    private String subject;

    private String description;

    private TicketStatus status;

    private UserEntity createdBy;

    private UUID createdByUserId;

    private Date createAt;

    private UUID updatedBy;

    private Date updatedAt;
}
