package br.com.manualdaprogramacao.helpdesk.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTicketDto {

        private String subject;

        private String description;

        private UUID createdByUserId;

}
