CREATE TABLE IF NOT EXISTS day (
    id serial not null,
    order_detail_id varchar(50),
    days varchar(300),

    primary key (id),
    CONSTRAINT fk_order_detail
       FOREIGN KEY(order_detail_id)
	   REFERENCES customers(id)
)
