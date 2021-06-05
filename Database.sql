
create table IF NOT EXISTS users( 
	id SERIAL PRIMARY KEY NOT NULL, 
	email varchar(100) NOT NULL, 
	password varchar(100) NOT NULL 
); 

create table IF NOT EXISTS personals( 
	id SERIAL NOT NULL,
	user_id integer NOT NULL, 
	first_name varchar(20) NOT NULL, 
	last_name varchar(20) NOT NULL, 
	status boolean DEFAULT true,
	PRIMARY KEY(id),
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
); 

create table IF NOT EXISTS jobs( 
	id SERIAL PRIMARY KEY NOT NULL, 
	job_name varchar(50) NOT NULL 
); 

create table IF NOT EXISTS schools( 
	id SERIAL PRIMARY KEY NOT NULL,
	name varchar(50) NOT NULL
);

create table IF NOT EXISTS school_part( 
	id SERIAL NOT NULL,
	school_id integer NOT NULL, 
	name varchar(50) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_schools FOREIGN KEY(school_id) REFERENCES schools(id)
);

create table IF NOT EXISTS languages( 
	id SERIAL PRIMARY KEY NOT NULL, 
	language_name varchar(50) NOT NULL
);

create table IF NOT EXISTS programing_languages( 
	id SERIAL PRIMARY KEY NOT NULL, 
	language_name varchar(50) NOT NULL
);

create table IF NOT EXISTS job_seekers( 
	id SERIAL NOT NULL,
	user_id integer NOT NULL,
	job_wanted_id integer NOT NULL,
	first_name varchar(20) NOT NULL, 
	last_name varchar(20) NOT NULL, 
	nationality_id char(11) NOT NULL, 
	year_of_birth varchar(10) NOT NULL, 
	github_adress varchar(100) NOT NULL, 
	linkedin_adress varchar(100) NOT NULL, 
	about varchar(200) NOT NULL, 
	status boolean DEFAULT false,
	PRIMARY KEY(id),
	CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(id),
	CONSTRAINT fk_job_wanted FOREIGN KEY(job_wanted_id) REFERENCES jobs(id)
); 

create table IF NOT EXISTS jobseekers_school_information( 
	id SERIAL NOT NULL,
	school_id integer NOT NULL, 
	jobseekers_id integer NOT NULL, 
	university_start_date date NOT NULL,
	university_graduation_date date,
	PRIMARY KEY(id),
	CONSTRAINT fk_schools FOREIGN KEY(school_id) REFERENCES schools(id),
	CONSTRAINT fk_job_seekers FOREIGN KEY(jobseekers_id) REFERENCES job_seekers(id)
);

create table IF NOT EXISTS Job_experience( 
	id SERIAL NOT NULL,
	job_seekers_id integer NOT NULL, 
	job_id integer NOT NULL, 
	company_name varchar(50) NOT NULL,
	start_date date NOT NULL,
	end_date date,
	PRIMARY KEY(id),
	CONSTRAINT fk_job_seekers FOREIGN KEY(job_seekers_id) REFERENCES job_seekers(id),
	CONSTRAINT fk_jobs FOREIGN KEY(job_id) REFERENCES jobs(id)
);

create table IF NOT EXISTS known_languages( 
	id SERIAL NOT NULL,
	job_seekers_id integer NOT NULL, 
	language_id integer NOT NULL, 
	level integer NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_job_seekers FOREIGN KEY(job_seekers_id) REFERENCES job_seekers(id),
	CONSTRAINT fk_languages FOREIGN KEY(language_id) REFERENCES languages(id)
);

create table IF NOT EXISTS known_programing_languages( 
	id SERIAL NOT NULL,
	job_seekers_id integer NOT NULL, 
	programing_language_id integer NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_job_seekers FOREIGN KEY(job_seekers_id) REFERENCES job_seekers(id),
	CONSTRAINT fk_programing_languages FOREIGN KEY(programing_language_id) REFERENCES programing_languages(id)
);

create table IF NOT EXISTS employers( 
	id SERIAL NOT NULL,
	user_id integer NULL,  
	company_name varchar(30) NOT NULL, 
	website varchar(30) NOT NULL, 
	telephone varchar(15) NOT NULL, 
	status boolean DEFAULT false ,
	PRIMARY KEY(id),
	CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS email_activations
(
	id SERIAL NOT NULL,
	user_id integer NOT NULL, 
    activation_code character varying(200) NOT NULL,
    email character varying(100) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS mernis_activations
(
	id SERIAL NOT NULL,
	user_id integer NOT NULL, 
    is_approved boolean NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS cities
(
    id SERIAL PRIMARY KEY NOT NULL,
    name character varying(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS job_adverts
(
    id SERIAL NOT NULL,
    employers_id integer NOT NULL,
    job_position_id integer NOT NULL,
    city_id integer NOT NULL,
    description character varying NOT NULL,
    min_salary integer,
    max_salary integer,
    number_of_open_positions integer NOT NULL,
    created_at timestamp with time zone NOT NULL,
    application_deadline timestamp with time zone,
	is_active boolean NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_employers FOREIGN KEY(employers_id) REFERENCES employers(id),
	CONSTRAINT fk_jobs FOREIGN KEY(job_position_id) REFERENCES jobs(id),
	CONSTRAINT fk_cities FOREIGN KEY(city_id) REFERENCES cities(id)
);
