create table if not exists j_role (
    id serial primary key,
    name varchar(2000)
);

INSERT INTO j_role (name) VALUES ('normal');
INSERT INTO j_role (name) VALUES ('hard');