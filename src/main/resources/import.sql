insert into users(uid, name, email) values (101, 'John', 'john@email.com');
insert into users(uid, name, email) values (102, 'Mike', 'mike@email.com');
insert into users(uid, name, email) values (103, 'Catherine', 'catherine@email.com');
insert into users(uid, name, email) values (104, 'Trump', 'trump@email.com');


insert into orders (oid, customer, amount) values (201, 'John', 94.0);
insert into orders (oid, customer, amount) values (202, 'Mike', 132.89);


insert into students(sid, name, created_date_time, last_updated_date_time) values (nextval('students_sid_seq_gen'), 'default student', current_timestamp, current_timestamp);