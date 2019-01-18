CREATE TABLE IF NOT EXISTS activeQuests (
    questId integer,
    studentId integer
);

CREATE TABLE IF NOT EXISTS admins (
    id SERIAL,
    first_name VARCHAR (20),
    last_name VARCHAR (20),
    email text,
    phone_number VARCHAR (25),
    adress text
);

CREATE TABLE IF NOT EXISTS artifacts (
    id SERIAL,
    name VARCHAR (15),
    price integer,
    description text,
    image text
);

CREATE TABLE IF NOT EXISTS mentors (
    id SERIAL,
    first_name VARCHAR (20),
    last_name VARCHAR (20),
    email text,
    phone_number VARCHAR (25),
    adress text,
    module_id integer
);

CREATE TABLE IF NOT EXISTS modules (
    id SERIAL,
    name VARCHAR (10)
);

CREATE TABLE IF NOT EXISTS ownedArtifacts (
    artifactId integer,
    studentId integer
);

CREATE TABLE IF NOT EXISTS quests (
    id SERIAL,
    name VARCHAR (15),
    price integer,
    description text,
    image text
);

CREATE TABLE IF NOT EXISTS students (
    id SERIAL,
    first_name VARCHAR (20),
    last_name VARCHAR (20),
    email text,
    phone_number VARCHAR (25),
    adress text,
    module_id integer
);