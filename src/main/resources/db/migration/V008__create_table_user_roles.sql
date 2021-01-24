CREATE TABLE IF NOT EXISTS user_roles (
    user_id int8 NOT NULL,
    role_id int8 NOT NULL,
    PRIMARY KEY(user_id, role_id),
    CONSTRAINT user_roles_user_id_fk FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT user_roles_role_id_fk FOREIGN KEY (role_id)
        REFERENCES roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);