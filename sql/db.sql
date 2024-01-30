DROP DATABASE IF EXISTS clinic20231222;
CREATE DATABASE clinic20231222;
USE clinic20231222;

CREATE TABLE specialties (
    specialty_id bigint auto_increment primary key,
    name varchar(255)
);

CREATE TABLE buildings (
    building_id bigint auto_increment primary key,
    name varchar(255)
);

CREATE TABLE people (
    person_id bigint auto_increment primary key,
    firstname varchar(255),
    lastname varchar(255),
    address varchar(255),
    phone varchar(255)
);

CREATE TABLE doctors (
    doctor_id bigint auto_increment primary key,
    specialty_id bigint,
    person_id bigint,
    foreign key (specialty_id) REFERENCES specialties (specialty_id),
    foreign key (person_id) REFERENCES people (person_id)
);

CREATE TABLE services (
    service_id bigint auto_increment primary key,
    code int, 
    name varchar(255),
    building_id bigint,
    doctor_id bigint,
    foreign key (building_id) REFERENCES buildings (building_id),
    foreign key (doctor_id) REFERENCES doctors (doctor_id)
);

CREATE TABLE nurses (
    nurse_id bigint auto_increment primary key,
    rotation varchar(255),
    salary int, 
    person_id bigint,
    service_id bigint,
    foreign key (person_id) REFERENCES people (person_id),
    foreign key (service_id) REFERENCES services (service_id)
);

CREATE TABLE rooms (
    room_id bigint auto_increment primary key,
    number int,
    nurse_id bigint,
    service_id bigint,
    foreign key (nurse_id) REFERENCES nurses (nurse_id),
    foreign key (service_id) REFERENCES services (service_id)
);

CREATE TABLE beds (
    bed_id bigint auto_increment primary key,
    number int,
    room_id bigint,
    foreign key (room_id) REFERENCES rooms (room_id)
);

CREATE TABLE patients (
    patient_id bigint auto_increment primary key,
    diagnosis varchar(255),
    bed_id bigint,
    person_id bigint,
    foreign key (bed_id) REFERENCES beds (bed_id),
    foreign key (person_id) REFERENCES people (person_id)
);

CREATE TABLE doctors_treat_patients (
    doctors_treat_patients_id bigint auto_increment primary key,
    doctor_id bigint,
    patient_id bigint,
    foreign key (doctor_id) REFERENCES doctors (doctor_id),
    foreign key (patient_id) REFERENCES patients (patient_id)
);

CREATE TABLE emails (
    email_id bigint auto_increment primary key,
    name varchar(255),
    person_id bigint NOT NULL,
    foreign key (person_id) REFERENCES people (person_id)
);
