create table t_security_role_permission (
       id_role varchar(36) not null,
        id_permission varchar(36) not null,
        primary key (id_role, id_permission)
    ) engine=InnoDB
; 
    
    create table t_jurusan (
       id varchar(36) not null,
        nama varchar(255),
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_kelas (
       id varchar(36) not null,
        nama_kelas varchar(255) not null,
        id_jurusan varchar(36),
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_mapel (
       id varchar(36) not null,
        nama varchar(255),
        id_kelas varchar(36),
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_user_murid (
       id varchar(36) not null,
        gender varchar(255),
        nama varchar(255),
        nis varchar(255) not null,
        no_absen varchar(255),
        tgl_lahir datetime not null,
        id_kelas varchar(36),
        id_user varchar(36),
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_security_permission (
       id varchar(36) not null,
        permission_value varchar(50) not null,
        permission_label varchar(100) not null,
        user_type varchar(20) not null,
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_security_role (
       id varchar(36) not null,
        description varchar(255),
        name varchar(15) not null,
        user_type varchar(20) not null,
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_security_user (
       id varchar(36) not null,
        active bit not null,
        email varchar(255) not null,
        role tinyblob,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_security_user_password (
       id_user varchar(36) not null,
        password varchar(255),
        primary key (id_user)
    ) engine=InnoDB
; 
    
    create table t_user_admin (
       id varchar(36) not null,
        fullname varchar(255) not null,
        gender varchar(255),
        no_telepon varchar(255) not null,
        photo varchar(255) not null,
        tgl_lahir date,
        id_user varchar(36),
        primary key (id)
    ) engine=InnoDB
; 
    
    create table t_user_guru (
       id varchar(36) not null,
        alamat varchar(255),
        gender varchar(255),
        nama varchar(255),
        nip varchar(255) not null,
        id_kelas varchar(36),
        id_mapel varchar(36),
        id_user varchar(36),
        primary key (id)
    ) engine=InnoDB
; 
    
    alter table t_user_murid 
       add constraint UK_5jer9r1do7rt722i3wb1rx2fs unique (nis)
; 
    
    alter table t_security_permission 
       add constraint UK_6o8yr74s8kt1l2qeos9hfnf09 unique (permission_value)
; 
    
    alter table t_security_permission 
       add constraint UK_fh1wbbjk86wn7l2wfi2usjbft unique (permission_label)
; 
    
    alter table t_security_role 
       add constraint UK_6qegmio110jkdvyti86hbrkr7 unique (name)
; 
    
    alter table t_security_user 
       add constraint UK_nvwg70suob38xuo9ato31khjh unique (username)
; 
    
    alter table t_user_guru 
       add constraint UK_dnlkxs7b15rta4908qtnbnmbd unique (nip)
; 
    
    alter table t_security_role_permission 
       add constraint FKl0fh6s5cbbqbbuv370xy84hay 
       foreign key (id_permission) 
       references t_security_permission (id)
; 
    
    alter table t_security_role_permission 
       add constraint FK44nm7p8hqb0glhoj9ubhmqa7q 
       foreign key (id_role) 
       references t_security_role (id)
; 
    
    alter table t_kelas 
       add constraint FKma8hq3pu7g5q6vsq08eds4vpl 
       foreign key (id_jurusan) 
       references t_jurusan (id)
; 
    
    alter table t_mapel 
       add constraint FKlq5thotntyng0ag20g6aqyd5v 
       foreign key (id_kelas) 
       references t_kelas (id)
; 
    
    alter table t_user_murid 
       add constraint FK1y9at4ptdj7ddq7f26e8pd05r 
       foreign key (id_kelas) 
       references t_kelas (id)
; 
    
    alter table t_user_murid 
       add constraint FK4fqnqfqnl2x6fvmb8o1mmpsm9 
       foreign key (id_user) 
       references t_security_user (id)
; 
    
    alter table t_security_user_password 
       add constraint FKigmqns96gsqctabycd8s8dm5e 
       foreign key (id_user) 
       references t_security_user (id)
; 
    
    alter table t_user_admin 
       add constraint FKlahjll7shx6s0166jpl9i309j 
       foreign key (id_user) 
       references t_security_user (id)
; 
    
    alter table t_user_guru 
       add constraint FKqlsj4a53lnme58le3nrumoj7t 
       foreign key (id_kelas) 
       references t_kelas (id)
; 
    
    alter table t_user_guru 
       add constraint FKhay0kj0odhhkc1mdfvxm5y770 
       foreign key (id_mapel) 
       references t_mapel (id)
; 
    
    alter table t_user_guru 
       add constraint FKfu1w7cttjqrcpev7usc9q0rin 
       foreign key (id_user) 
       references t_security_user (id)