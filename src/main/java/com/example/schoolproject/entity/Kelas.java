package com.example.schoolproject.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_kelas")
public class Kelas extends BaseEntity{
    
    @NotEmpty
    @NotNull
    private @Getter @Setter String namaKelas;
    
    @JoinColumn(name = "id_jurusan")
    @ManyToOne
    private @Getter @Setter Jurusan jurusan;
    
}
