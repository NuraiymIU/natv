CREATE TABLE IF NOT EXISTS channels (
    id serial not null,
    name varchar(50),
    photo varchar(300),
    active boolean,
    order_num integer,

    primary key (id)
)












