CREATE TABLE service (

    id UUID NOT NULL,
    name TEXT NOT NULL,
    company_id UUID NOT NULL,

    created_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    version BIGINT NOT NULL DEFAULT 1,

    CONSTRAINT pk_service
        PRIMARY KEY (id),

    CONSTRAINT fk_service__company_id___company__id
        FOREIGN KEY (company_id) REFERENCES company (id)
);
