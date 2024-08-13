package br.com.manualdaprogramacao.helpdesk.domain;

import java.util.Date;
import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        String name,
        String email
) {

}
