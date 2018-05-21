select * from sbs.event;
select * from sbs.user;


drop table sbs.user;
drop table sbs.EVENT;

CREATE TABLE SBS.USER(
    id_user                                 integer,
    email                                   varchar(30),
    password                                 varchar(100),
    register_date                              timestamp,
    CONSTRAINT pk_id_user PRIMARY KEY(id_user)
);
INSERT INTO SBS.USER (id_user, email,password, register_date)
VALUES (14,'JOSE', '1',CURRENT_TIMESTAMP);


CREATE TABLE sbs.EVENT(
    id_event                                integer,
    id_user                                 integer,
    name                                    varchar(30),
    category                                varchar(30),
    place                                   varchar(30),
    address                                 varchar(100),
    ispresencial                              boolean,
    date_start                              timestamp,
    date_final                              timestamp,
    date_register                           timestamp,
    CONSTRAINT pk_id_event PRIMARY KEY(id_event),
    CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES SBS.USER (id_user)
);
GRANT SELECT, UPDATE, DELETE, INSERT ON SBS.EVENT TO SBSAPI;
GRANT SELECT, UPDATE, DELETE, INSERT ON SBS.USER TO SBSAPI;

INSERT INTO SBS.EVENT (id_event, id_user,name, category, place, address, presencial,date_start, date_final, date_register) 
VALUES (14,12, 'JOSE RIVERA', '01', 'mandalay', 'address', true,  CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE sbs.user_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

GRANT SELECT, UPDATE, USAGE ON sbs.user_id_seq TO SBSAPI;

CREATE SEQUENCE sbs.event_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

GRANT SELECT, UPDATE, USAGE ON sbs.event_id_seq TO SBSAPI;
