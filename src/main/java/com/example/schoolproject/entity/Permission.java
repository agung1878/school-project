package com.example.schoolproject.entity;

import com.example.schoolproject.constant.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_security_permission")
public class Permission extends BaseEntity{
    
    @NotEmpty
    @Column(name = "permission_label", nullable = false, unique = true, length = 100)
    private @Getter @Setter String permissionValue;
    
    @NotEmpty
    @Column(name = "permission_value", nullable = false, unique = true, length = 50)
    private @Getter @Setter String permissionLabel;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private @Getter @Setter UserType userType;
}
