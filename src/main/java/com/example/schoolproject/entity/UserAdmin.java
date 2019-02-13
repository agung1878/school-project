package com.example.schoolproject.entity;

import com.example.schoolproject.constant.Gender;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "t_user_admin")
public class UserAdmin extends BaseEntity {

    @OneToOne(orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private @Getter
    @Setter
    User user;

    @NotEmpty
    @Column(nullable = false)
    private @Getter
    @Setter
    String fullname;

    @NotEmpty
    @Column(nullable = false)
    private @Getter
    @Setter
    String noTelepon;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @Getter
    @Setter
    Date tglLahir;

    @NotEmpty
    @Column(nullable = false)
    private @Getter
    @Setter
    String photo;
    
    @Enumerated(EnumType.STRING)
    private @Getter @Setter Gender gender;

}
