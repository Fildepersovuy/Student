create table students (
                       id bigint not null auto_increment,
                       fio varchar(255) not null,
                       country_of_birth varchar(255) not null,
                       date_of_birth timestamp
                       email varchar(255) not null,
                       first_name varchar(255) not null,
                       gender varchar(255) not null,
                       last_name varchar(255) not null,
                       primary key (id)
) engine=InnoDB

GO



