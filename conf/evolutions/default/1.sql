# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                        bigint not null,
  name                      varchar(255),
  created_date              timestamp not null,
  updated_date              timestamp not null,
  constraint pk_category primary key (id))
;

create sequence category_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

