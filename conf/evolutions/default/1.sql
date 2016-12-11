# --- !Ups
CREATE TABLE UUIDTest (
    id SERIAL,
    testId VARCHAR(36) NOT NULL
);

INSERT INTO UUIDTest VALUES (1, '6623dafd-da75-4f4c-854e-76f6ec63a5a2');

# --- !Downs
