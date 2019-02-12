create table t_guru (
       id varchar(36) not null,
        nama varchar(255),
        nip varchar(255),
        id_kelas varchar(36),
        id_mapel varchar(36),
        primary key (id)
    ) engine=InnoDB;
    
    create table t_jurusan (
       id varchar(36) not null,
        nama varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
    create table t_kelas (
       id varchar(36) not null,
        nama_kelas varchar(255) not null,
        id_jurusan varchar(36),
        primary key (id)
    ) engine=InnoDB;
    
    create table t_mapel (
       id varchar(36) not null,
        nama varchar(255),
        id_kelas varchar(36),
        primary key (id)
    ) engine=InnoDB;
    
    create table t_murid (
       id varchar(36) not null,
        jenis_kelamin varchar(255),
        nama varchar(255),
        nis varchar(255),
        no_absen varchar(255),
        tgl_lahir datetime not null,
        id_kelas varchar(36),
        primary key (id)
    ) engine=InnoDB;
    
    alter table t_guru 
       add constraint FKfc03y796i8qmvookdu6wbmb6t 
       foreign key (id_kelas) 
       references t_kelas (id);
    
    alter table t_guru 
       add constraint FKt6hsgxoxnvsnaewb79d3gb9dw 
       foreign key (id_mapel) 
       references t_mapel (id);
    
    alter table t_kelas 
       add constraint FKma8hq3pu7g5q6vsq08eds4vpl 
       foreign key (id_jurusan) 
       references t_jurusan (id);
    
    alter table t_mapel 
       add constraint FKlq5thotntyng0ag20g6aqyd5v 
       foreign key (id_kelas) 
       references t_kelas (id);
    
    alter table t_murid 
       add constraint FK1y9at4ptdj7ddq7f26e8pd05r 
       foreign key (id_kelas) 
       references t_kelas (id);