package br.com.manualdaprogramacao.helpdesk.domain;

import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.enums.TicketStatus;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TicketInteraction {

    private String message;

    private UUID userId;

    private UUID ticketId;

}
