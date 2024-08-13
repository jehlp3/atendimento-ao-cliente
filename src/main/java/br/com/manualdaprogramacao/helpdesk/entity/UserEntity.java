package br.com.manualdaprogramacao.helpdesk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    private String username;

    private String password;

    private String name;

    private String email;

    private boolean active;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;
}
