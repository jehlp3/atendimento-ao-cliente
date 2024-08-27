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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<TicketDto> create(@RequestBody CreateTicketDto request, Authentication authentication){
        Ticket domain = mapper.toDomain(request);
        TicketDto createdTicket = mapper.toDto(ticketService.createTicket(domain, authentication.getName()));
        return ResponseEntity.ok(createdTicket);
    }

    @Operation(description = "This method creates a new support ticket interaction in the system")
    @PostMapping(value = "/{id}/interaction")
    public ResponseEntity<TicketDto> create(@PathVariable(name = "id") UUID ticketId, @RequestBody CreateTicketInteractionDto request,
                                            Authentication authentication){
        TicketInteraction domain = mapper.toDomain(request);
        domain.setTicketId(ticketId);
        TicketDto updatedTicket = mapper.toDto(ticketService.ticketInteract(domain, authentication.getName()));
        return ResponseEntity.ok(updatedTicket);
    }

    @Operation(description = "This method returns the ticket list")
    @GetMapping
    public ResponseEntity<List<TicketDto>> listAllTickets(){
        List<TicketDto> tickets = mapper.toDto(ticketService.listAll());
        return ResponseEntity.ok(tickets);
    }
}
