package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.TicketInteractionEntity;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.enums.TicketStatus;
import br.com.manualdaprogramacao.helpdesk.mapper.TicketMapper;
import br.com.manualdaprogramacao.helpdesk.repository.TicketInteractionRepository;
import br.com.manualdaprogramacao.helpdesk.repository.TicketRepository;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInteractionRepository ticketInteractionRepository;

    private final UserRepository userRepository;

    private final TicketMapper mapper;

    public Ticket createTicket (Ticket newTicket){

        TicketEntity entity = mapper.toEntity(newTicket);
        Optional<UserEntity> createdByUser = userRepository.findById(newTicket.getCreatedByUserId());
        if (createdByUser.isEmpty()){
            //TODO throw new ObjectNotFoundException("User not found with provided id");
        }
        entity.setCreatedBy(createdByUser.get());
        entity.setStatus(TicketStatus.OPEN);
        entity.setCreateAt(new Date());
        entity = ticketRepository.save(entity);
        return mapper.toDomain(entity);
    }

    public Ticket ticketInteract(TicketInteraction domain) {
        TicketEntity ticket = ticketRepository.findById(domain.getTicketId()).orElse(null);

//          TODO Validação do ticket
//        if(ticket == null){
//            throw new BusinessException("Ticket not found with provided id")
//        }

        UserEntity user = userRepository.findById(domain.getUserId()).orElse(null);

//          TODO validação do usuário
//        if(user == null){
//            throw new BusinessException("User not found with provided id")
//        }

        Date now = new Date();

        TicketStatus status = TicketStatus.IN_PROGRESS;
        if (ticket.getCreatedBy().getId() != user.getId()){
            ticket.setSupportUser(user);
            status = TicketStatus.AWAITING_CUSTOMER_ANSWER;
        }

        TicketInteractionEntity entity = new TicketInteractionEntity();
        entity.setTicket(ticket);
        entity.setMessage(domain.getMessage());
        entity.setCreatedBy(user);
        entity.setCreateAt(now);
        entity.setStatus(status);

        ticketInteractionRepository.save(entity);

        ticket.setUpdatedAt(now);
        ticket.setUpdatedBy(user.getId());
        ticket.setStatus(status);
        ticket = ticketRepository.save(ticket);

        return mapper.toDomain(ticket);

    }
}
