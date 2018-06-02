# --- !Ups

create table "category" (
  "id" integer not null primary key autoincrement,
  "name" varchar not null
);

create table "product" (
  "id" integer not null primary key autoincrement,
  "name" varchar not null,
  "description" text not null,
  "category" int not null,
  "price" decimal(4,2) not null,
  foreign key(category) references category(id)
);

create table "cart" (
  "product_id" int not null,
  "quantity" int default 0 not null,
  foreign key(product_id) references product(id)
);

create table "orders" (
  "order_id" integer primary key autoincrement not null
);

create table "ordered_products" (
  "order_id" int not null,
  "product_id" int not null,
  foreign key(order_id) references orders(order_id)
);

create table "opinions" (
  "id" integer primary key autoincrement not null,
  "product_id" int not null,
  "title" varchar(100) not null,
  "opinion" varchar(300) not null,
  foreign key(product_id) references product(id)
);


# --- !Downs

drop table if exists "product";
drop table if exists "category";
drop table if exists "cart";
drop table if exists "orders";
drop table if exists "ordered_products";
drop table if exists "opinions";