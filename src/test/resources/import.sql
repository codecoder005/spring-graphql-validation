insert into users(uid, name, email) values (101, 'test_user', 'test_user@email.com');
select next value for uid_seq_generator;

insert into orders(oid, amount, customer) values (101, 98.23, 'test_user');
