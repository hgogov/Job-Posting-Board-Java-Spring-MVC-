CREATE TABLE IF NOT EXISTS jobs (
    id BIGSERIAL,
    name VARCHAR(128) NOT NULL,
    description VARCHAR(10240) NOT NULL,
    category_id BIGINT  NOT NULL,
    location_id BIGINT NOT NULL,
    type_id BIGINT NOT NULL,
    experience_level_id BIGINT NOT NULL,
    company_id int8 NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT jobs_category_id_fk FOREIGN KEY (category_id) REFERENCES categories (id),
    CONSTRAINT jobs_location_id_fk FOREIGN KEY (location_id) REFERENCES locations (id),
    CONSTRAINT jobs_type_id_fk FOREIGN KEY (type_id) REFERENCES job_types (id),
    CONSTRAINT jobs_experience_level_id_fk FOREIGN KEY (experience_level_id) REFERENCES job_experience_levels (id),
    CONSTRAINT jobs_company_id_fk FOREIGN KEY (company_id) REFERENCES companies (id)
);