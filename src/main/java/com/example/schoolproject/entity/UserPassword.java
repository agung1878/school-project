package com.example.schoolproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_security_user_password")
public class UserPassword extends BaseEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user", nullable = false, columnDefinition = "varchar(36)")
    private @Getter
    @Setter
    User user;

    @NotEmpty(message = "Password tidak boleh kosong")
    @Column
    private @Getter
    @Setter
    String password;

}
