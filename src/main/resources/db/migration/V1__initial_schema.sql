CREATE TABLE IF NOT EXISTS product (

    barcode     varchar(50) NOT NULL PRIMARY KEY,
    name        varchar(100),
    price       decimal(13,2),
    size        varchar(10),
    add_date    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;