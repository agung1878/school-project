package com.example.schoolproject.entity;

import com.example.schoolproject.constant.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_user_murid")
public class UserMurid extends BaseEntity {
    
    @OneToOne(orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;
    
    @Column(nullable = false, unique = true)
    private @Getter @Setter String nis;
    
    @NotEmpty
    private @Getter @Setter String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private @Getter @Setter Kelas kelas;
    
    @NotEmpty
    private @Getter @Setter String noAbsen;
    
     @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @Getter @Setter Date tglLahir;
    
}
