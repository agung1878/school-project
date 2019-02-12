package com.example.schoolproject.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_murid")
public class Murid extends BaseEntity {
    
    @NotEmpty
    private @Getter @Setter String nis;
    
    @NotEmpty
    private @Getter @Setter String nama;
    
    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private @Getter @Setter Kelas kelas;
    
    @NotEmpty
    private @Getter @Setter String noAbsen;
    
    @NotEmpty
    private @Getter @Setter String jenisKelamin;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @Getter @Setter Date tglLahir;
    
}
