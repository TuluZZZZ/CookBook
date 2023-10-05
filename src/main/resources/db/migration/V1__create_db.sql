DO $$
BEGIN
        IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'cook_book') THEN
            CREATE DATABASE "food_market"
                WITH
                OWNER = postgres
                ENCODING = 'UTF8'
                LC_COLLATE = 'C'
                LC_CTYPE = 'C'
                TABLESPACE = pg_default
                CONNECTION LIMIT = -1
                IS_TEMPLATE = False;
END IF;
END $$;