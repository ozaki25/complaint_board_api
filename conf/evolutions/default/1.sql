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

create table comment (
  id                        bigint not null,
  content                   varchar(255),
  category_id               bigint,
  created_date              timestamp not null,
  updated_date              timestamp not null,
  constraint pk_comment primary key (id))
;

create sequence category_seq;

create sequence comment_seq;

alter table comment add constraint fk_comment_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_comment_category_1 on comment (category_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

drop table if exists comment;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

drop sequence if exists comment_seq;

