package br.com.manualdaprogramacao.helpdesk.mapper;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketDto;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketInteractionDto;
import br.com.manualdaprogramacao.helpdesk.dto.TicketDto;
import br.com.manualdaprogramacao.helpdesk.dto.TicketInteractionDto;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.TicketInteractionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    Ticket toDomain(TicketEntity entity);

    TicketDto toDto(Ticket domain);

    TicketEntity toEntity(Ticket domain);

    Ticket toDomain (CreateTicketDto dto);

    TicketInteraction toDomain(CreateTicketInteractionDto dto);

    List<Ticket> toDomain(List<TicketEntity> entities); //Mapper consegue fazer a conversão dos itens da lista de forma automática

    List<TicketDto> toDto(List<Ticket> domains);

    List<TicketInteractionDto> toInteractionDto(List<TicketInteraction> domains);

    List<TicketInteraction> toInteractionDomain(List<TicketInteractionEntity> byTicket);
}
