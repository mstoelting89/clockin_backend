INSERT INTO user_role VALUES (1, "ADMIN");
INSERT INTO user_role VALUES (2, "USER");

INSERT INTO user_entries (first_name, last_name, email, password, user_role_id, enabled, locked)
VALUES
       (
        "Michael",
        "Stölting",
        "michaelstoelting@gmail.com",
        "$2a$10$xOPlSqT9VwCTx1RQZFRxQ.HQxMEQMlkw5P7nCQcBfe/BavxD.ZShO",
        1,
        true,
        false
        );
