package br.com.manualdaprogramacao.helpdesk.controller;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.dto.*;
import br.com.manualdaprogramacao.helpdesk.mapper.TicketMapper;
import br.com.manualdaprogramacao.helpdesk.mapper.UserMapper;
import br.com.manualdaprogramacao.helpdesk.service.TicketService;
import br.com.manualdaprogramacao.helpdesk.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@OpenAPIDefinition
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/tickets")
public class TicketController {

    private final TicketService ticketService;

    private final TicketMapper mapper;

    @Operation(description = "This method creates a new support ticket in the system")
    @PostMapping
    public ResponseEntity<TicketDto> create(@RequestBody CreateTicketDto request){
        Ticket domain = mapper.toDomain(request);
        TicketDto createdTicket = mapper.toDto(ticketService.createTicket(domain));
        return ResponseEntity.ok(createdTicket);
    }

    @Operation(description = "This method creates a new support ticket interaction in the system")
    @PostMapping(value = "{id}/interaction}")
    public ResponseEntity<TicketDto> create(@PathVariable(name = "id") UUID ticketId, @RequestBody CreateTicketInteractionDto request){
        TicketInteraction domain = mapper.toDomain(request);
        domain.setTicketId(ticketId);
        TicketDto updatedTicket = mapper.toDto(ticketService.ticketInteract(domain));
        return ResponseEntity.ok(updatedTicket);
    }
}
