CREATE ROLE authorization_user WITH LOGIN PASSWORD 'authorization_pass' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE SCHEMA "authorization" AUTHORIZATION meeteor_user;
GRANT ALL ON SCHEMA "authorization" TO authorization_user;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp" SCHEMA "authorization";
ALTER EXTENSION "uuid-ossp" SET SCHEMA "authorization";
