
    create table book (
        book_id integer not null auto_increment,
        quantity bigint,
        rem_quantity bigint,
        author varchar(255),
        book_name varchar(255),
        primary key (book_id)
    ) engine=InnoDB;

    create table student (
        date_of_borrow date,
        id_card_number integer not null,
        phone_number integer,
        email varchar(255),
        name varchar(255),
        primary key (id_card_number)
    ) engine=InnoDB;

    create table student_book (
        book_id integer not null,
        id_card_number integer not null
    ) engine=InnoDB;

    alter table student_book 
       add constraint FK7lxv23edvxyshx6x6j9qse38f 
       foreign key (book_id) 
       references book (book_id);

    alter table student_book 
       add constraint FKfs0wj0iqnmb1occktk1pd7x07 
       foreign key (id_card_number) 
       references student (id_card_number);
