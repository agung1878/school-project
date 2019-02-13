package com.example.schoolproject.entity;

import com.example.schoolproject.constant.UserType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_security_role")
public class Role extends BaseEntity{
    
    @NotEmpty
    @Column(name = "name", nullable = false, unique = true, length = 15)
    private @Getter @Setter String name;
    
    @Column(name = "description", length = 255)
    private @Getter @Setter String description;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @OrderBy("permissionValue asc")
    @JoinTable(
        name="t_security_role_permission", 
        joinColumns=@JoinColumn(name="id_role", nullable=false),
        inverseJoinColumns=@JoinColumn(name="id_permission", nullable=false)
    )
    private Set<Permission> permissions = new HashSet<>();
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private @Getter @Setter UserType userType;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    
    
}
