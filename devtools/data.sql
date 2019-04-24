INSERT INTO "authorization".oauth_client_details(client_id,
                                                 resource_ids,
                                                 client_secret,
                                                 scope,
                                                 authorized_grant_type,
                                                 authorities,
                                                 access_token_validity,
                                                 refresh_token_validity)
VALUES ('authorization-service',
        'authorization',
           /*authorization-secret*/
        '$2y$04$FCPlZw1uELhtuJj76qYOjeZcS7iBp0rmyKaSd.bbJTFb7snnf4cpa',
        'read,write',
        'password,authorization_code,refresh_token,implicit',
        'USER',
        10800,
        2592000);

INSERT INTO "authorization".oauth_client_details(client_id,
                                 resource_ids,
                                 client_secret,
                                 scope,
                                 authorized_grant_type,
                                 authorities,
                                 access_token_validity,
                                 refresh_token_validity)
VALUES ('greeting-service',
        'greeting',
           /*greeting-secret*/
        '$2y$04$tWV/RMg7GxfEB8/sR/yxiuxrme6yqNlVgPCdhBzf4QjlG2IRBKnsC',
        'read',
        'password,authorization_code,refresh_token,implicit',
        'USER',
        10800,
        2592000);

INSERT INTO "authorization".authority(a_id, a_name)
VALUES ('6a00149c-d639-4271-a6d1-49527871aac7',
        'GREETING_CREATE');

INSERT INTO "authorization".authority(a_id, a_name)
VALUES ('3c2adda1-500c-434b-a1e1-6f62f6d5f6d4',
        'GREETING_READ');

INSERT INTO "authorization".user(u_id,
                 u_username,
                 u_password,
                 u_account_non_expired,
                 u_account_non_locked,
                 u_credentials_non_expired,
                 u_enabled)
VALUES ('720d8090-e4ff-4dba-9825-f56333288f3b',
        'admin',
           /*pass*/
        '$2y$08$6N/5oIDaeX8Ih/YSwkbyHu/udngYrP6O1xvV1Hn0Zb3y2vFEnCUPm',
        FALSE,
        FALSE,
        FALSE,
        TRUE);

INSERT INTO "authorization".user(u_id,
                 u_username,
                 u_password,
                 u_account_non_expired,
                 u_account_non_locked,
                 u_credentials_non_expired,
                 u_enabled)
VALUES ('8598be81-bf6c-478f-abcc-ae2e230fc3d4',
        'solairerove',
           /*strongpwd*/
        '$2y$08$KcR3C.Zqe.dFFwYPkUQ/4e.JmPy3o3QANmx9IpohHaBVopJDqIdDW',
        FALSE,
        FALSE,
        FALSE,
        TRUE);

INSERT INTO "authorization".users_authorities(u_id, a_id)
VALUES ('720d8090-e4ff-4dba-9825-f56333288f3b',
        '6a00149c-d639-4271-a6d1-49527871aac7');

INSERT INTO "authorization".users_authorities(u_id, a_id)
VALUES ('720d8090-e4ff-4dba-9825-f56333288f3b',
        '3c2adda1-500c-434b-a1e1-6f62f6d5f6d4');

INSERT INTO "authorization".users_authorities(u_id, a_id)
VALUES ('8598be81-bf6c-478f-abcc-ae2e230fc3d4',
        '3c2adda1-500c-434b-a1e1-6f62f6d5f6d4');
