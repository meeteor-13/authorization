INSERT INTO oauth_client_details(client_id,
                                 resource_ids,
                                 client_secret,
                                 scope,
                                 authorized_grant_types,
                                 authorities,
                                 access_token_validity,
                                 refresh_token_validity)
VALUES ('greeting-service',
        'greeting',
           /*greeting-secret*/
        '$2a$10$BVyQual/HWBsJPeZ.Ri4u.4fYhd3UN7ijSoHdxO7OLDBf/MRFKyOy',
        'read',
        'password,authorization_code,refresh_token,implicit',
        'USER',
        10800,
        2592000);

INSERT INTO authority(a_id, a_name)
VALUES ('3c2adda1-500c-434b-a1e1-6f62f6d5f6d4',
        'GREETING_READ');

INSERT INTO "user"(u_id,
                 u_username,
                 u_password,
                 u_account_non_expired,
                 u_account_non_locked,
                 u_credentials_non_expired,
                 u_enabled)
VALUES ('8598be81-bf6c-478f-abcc-ae2e230fc3d4',
        'solairerove',
           /*strongpwd*/
        '$2a$10$9ovdjj5aVwUu01rAjR7knOYAhatDcdeCJ8EKiR29uy5I1WLzb8WRq',
        TRUE,
        TRUE,
        TRUE,
        TRUE);

INSERT INTO users_authorities(u_id, a_id)
VALUES ('8598be81-bf6c-478f-abcc-ae2e230fc3d4',
        '3c2adda1-500c-434b-a1e1-6f62f6d5f6d4');
