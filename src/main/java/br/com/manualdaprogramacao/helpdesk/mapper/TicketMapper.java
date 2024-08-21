package br.com.manualdaprogramacao.helpdesk.mapper;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketDto;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketInteractionDto;
import br.com.manualdaprogramacao.helpdesk.dto.TicketDto;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    Ticket toDomain(TicketEntity entity);

    TicketDto toDto(Ticket domain);

    TicketEntity toEntity(Ticket domain);

    Ticket toDomain (CreateTicketDto dto);

    TicketInteraction toDomain(CreateTicketInteractionDto dto);
}
