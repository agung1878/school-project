package com.example.schoolproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_security_user")
public class User extends BaseEntity{
    
    @Column(nullable = false,unique = true)
    private @Getter @Setter String username;
    
    private @Getter @Setter Role role;
    
    private @Getter @Setter boolean active = false;
    
    @Transient
    private @Getter @Setter String password;
    
    @JsonIgnore
    @OneToOne(mappedBy = "user", optional = true)
    @Cascade(CascadeType.ALL)
    private @Getter @Setter UserPassword userPassword;
    
    @Column(name = "email", length = 255, nullable = false)
    private @Getter @Setter String email;
    
}
