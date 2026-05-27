create table api_events.tb_events(
    id bigserial primary key,
    event_name varchar(100) not null,
    event_date date,
    cep varchar(8) not null
);

ALTER TABLE tb_events
ALTER COLUMN event_date TYPE timestamp;