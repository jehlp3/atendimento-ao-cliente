package br.com.manualdaprogramacao.helpdesk.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTicketInteractionDto {

        private String message;

        private UUID userId;

}
