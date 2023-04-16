CREATE TABLE company (

    id UUID NOT NULL,
    owner_id UUID NOT NULL,
    name TEXT NOT NULL,
    address TEXT,
    contact TEXT,
    official_details TEXT,
    description TEXT,

    "created_date" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    "modified_date" TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    "version" BIGINT NOT NULL DEFAULT 1,

    CONSTRAINT "pk_company"
        PRIMARY KEY ("id")

);
