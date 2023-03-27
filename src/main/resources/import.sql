-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into main.job_position (id, title, salary, created_at) values('be979e8f-2057-4d26-af25-896d53f03fdb', 'chef', 5000000, now());
insert into main.job_position (id, title, salary, created_at) values('e1d5ceaf-7644-4390-bc89-66cd139e589d', 'waitress', 3500000, now());
insert into main.job_position (id, title, salary, created_at) values('9943b35b-cf80-4ad2-a7c4-07fa152c52b0', 'cashier', 4000000, now());
insert into main.job_position (id, title, salary, created_at) values('ca3cf084-09ae-4115-a27d-b717e8e4a734', 'manager', 7000000, now());
insert into main.job_position (id, title, salary, created_at) values('1cc57706-1f9f-4a74-a6c0-9929d00275ba', 'janitor', 3000000, now());
insert into main.job_position (id, title, salary, created_at) values('2d34e25a-efb0-4434-b3c9-1df907559f71', 'dishwasher', 2500000, now());
insert into main.job_position (id, title, salary, created_at) values('845b88cd-9913-4ab0-b931-b70093b169e5', 'barista', 4500000, now());


insert into main.last_education (id, name, created_at) values('64f2955e-721f-4dcb-b905-1771dd67af0d', 'SD', now());
insert into main.last_education (id, name, created_at) values('62ce7a68-62eb-4b89-a0b9-8234ff093cf0', 'SMP', now());
insert into main.last_education (id, name, created_at) values('954ed869-11f7-4713-8737-6bb20649f7e5', 'SMA/SMK', now());
insert into main.last_education (id, name, created_at) values('9d57b165-86ec-4944-8a3a-9c339738b5d8', 'D3', now());
insert into main.last_education (id, name, created_at) values('f8f6bcfa-ee1c-43c7-8b27-144df7581ecf', 'S1/D4', now());
insert into main.last_education (id, name, created_at) values('08fb7289-a60d-4625-8376-38d0dee89b7b', 'S2', now());
insert into main.last_education (id, name, created_at) values('fe704e6e-bdaf-4259-8745-77ba27aceaef', 'S3', now());


insert into main.payment_type (id, name, code, created_at) values('8c43539a-8148-4866-a2bb-7fd4a0a61975', 'credit', 'CR', now());
insert into main.payment_type (id, name, code, created_at) values('91a53b76-b770-43eb-ac2c-58ceeb44a948', 'debit', 'DE', now());
insert into main.payment_type (id, name, code, created_at) values('ee911762-9eb2-4b90-9a53-8dc7292f03fc', 'cashless', 'CL', now());
insert into main.payment_type (id, name, code, created_at) values('8be5e420-6889-4538-b4e1-47d2eea45434', 'cash', 'CA', now());