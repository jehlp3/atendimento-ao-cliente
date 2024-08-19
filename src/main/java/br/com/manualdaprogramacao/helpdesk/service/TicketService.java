package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.mapper.TicketMapper;
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

    private final TicketRepository TicketRepository;

    private final UserRepository userRepository;

    private final TicketMapper mapper;

    public Ticket createTicket (Ticket newTicket){

        TicketEntity entity = mapper.toEntity(newTicket);
        Optional<UserEntity> createdByUser = userRepository.findById(newTicket.getCreatedByUserId());
        if (createdByUser.isEmpty()){
            //TODO throw new ObjectNotFoundException("User not found with provided id");
        }
        entity.setCreatedBy(createdByUser.get());

        entity.setCreateAt(new Date());
        entity = TicketRepository.save(entity);
        return mapper.toDomain(entity);
    }

}
