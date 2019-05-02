CREATE TABLE channel
(
    id   serial primary key,
    name varchar(100)
);

DROP TABLE link;
CREATE TABLE link
(
    id          serial primary key,
    channel_id  integer NOT NULL,
    name        VARCHAR(100),
    url         VARCHAR(100),
    description VARCHAR(200)
)