create table users
(
    user_id      varchar(32)  not null primary key,
    name         varchar(30)  not null,
    password     varchar(100) not null,
    email        varchar(100) not null UNIQUE,
    phone_number varchar(13)  not null UNIQUE,
    nick_name    varchar(30)  not null,
    created_at   datetime(6)  not null default now(),
    modified_at  datetime(6)  null
);

--  Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO users (user_id, name, password, email, phone_number, nick_name, created_at)
VALUES ('cfb98446efaa4c9d9525d67eed414e01', '김철수', '1234', 'kim@kakao.com', '010-1111-2222', '철수',
        DATE_ADD(NOW(), INTERVAL -5 MONTH));
INSERT INTO users (user_id, name, password, email, phone_number, nick_name, created_at)
VALUES ('3a762305de0d488eba93235300a2fdf5', 'test', '1234', 'test@gmail.com', '010-2222-3333',
        'test',
        DATE_ADD(NOW(), INTERVAL -5 MONTH));


create table accounts
(
    account_number    varchar(20)  not null primary key,
    user_id           varchar(32)  not null,
    account_name      varchar(30)  not null,
    is_representative TINYINT(1)   not null default 0,
    account_password  varchar(100) not null,
    balance           decimal(20,0)       not null,
    created_at        datetime(6)  not null default now(),
    modified_at       datetime(6)  null
);

ALTER TABLE accounts
    ADD CONSTRAINT `fk-users-accounts` FOREIGN KEY (user_id)
        REFERENCES users (user_id);

--  Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO accounts (account_number, user_id, account_name, is_representative, account_password,
                      balance, created_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01', '철수계좌', 1, '$2a$10$UcPbfEqV9c7QqPty7KSACeYalYqXTK2EeFthZMJS/p59fbs/VWYQG', 10000000000,
        DATE_ADD(NOW(), INTERVAL -5 MONTH));
INSERT INTO accounts (account_number, user_id, account_name, is_representative, account_password,
                      balance, created_at)
VALUES ('333-111111-2222', '3a762305de0d488eba93235300a2fdf5', '테스트계좌', 1, '$2a$10$L8h5LHMPf3kaL/7MsNFbaeBlJxEzxXMY1XegCsD2OOhhXxgG1d2bC', 10000000000,
        DATE_ADD(NOW(), INTERVAL -5 MONTH));


create table transfer_history
(
    id               bigint      not null AUTO_INCREMENT primary key,
    withdraw_account varchar(20) not null,
    deposit_account  varchar(20) null,
    sender_id        varchar(32) not null,
    receiver_id      varchar(32) not null,
    transfer_amount  decimal(20,0)      not null,
    transfer_status  varchar(20) not null default 'REQUEST',
    transfer_type    varchar(20) not null,
    send_at          datetime(6) not null default now(),
    receive_at       datetime(6) null
);

--  Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -3 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'REQUEST', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -2 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'REQUEST', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, deposit_account, sender_id, receiver_id,
                              transfer_amount, transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', '333-111111-2222',
        'cfb98446efaa4c9d9525d67eed414e01', '3a762305de0d488eba93235300a2fdf5', 1000, 'SUCCESS',
        'FRIEND', DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'REQUEST', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'REQUEST', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));
INSERT INTO transfer_history (withdraw_account, sender_id, receiver_id, transfer_amount,
                              transfer_status, transfer_type, send_at)
VALUES ('111-222222-1111', 'cfb98446efaa4c9d9525d67eed414e01',
        '3a762305de0d488eba93235300a2fdf5', 1000, 'FAILURE', 'FRIEND',
        DATE_ADD(NOW(), INTERVAL -1 MONTH));