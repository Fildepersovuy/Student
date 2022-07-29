create table universities (
                                id bigint not null auto_increment,
                                abbreviation varchar(255) not null,
                                creation_date timestamp,
                                founding_date timestamp,
                                full_title varchar(255) not null,
                                primary key (id)
) engine=InnoDB

GO
