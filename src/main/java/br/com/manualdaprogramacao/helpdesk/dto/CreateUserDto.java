package br.com.manualdaprogramacao.helpdesk.dto;

import lombok.Data;

@Data
public class CreateUserDto{
        String username;
        String password;
        String name;
        String email;
}
