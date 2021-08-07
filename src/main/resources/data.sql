INSERT INTO USER(name, email, password) VALUES('Student', 'student@email.com', '$2a$10$Uv1Z6jFD1NoqkgSDjxVHFOj3cyVpSaBMyMuPBjNVGSl/prcxLCMrK');
INSERT INTO USER(name, email, password) VALUES('Moderator', 'moderator@email.com', '$2a$10$Uv1Z6jFD1NoqkgSDjxVHFOj3cyVpSaBMyMuPBjNVGSl/prcxLCMrK');

INSERT INTO PROFILE(id, name) VALUES(1, 'ROLE_STUDENT');
INSERT INTO PROFILE(id, name) VALUES(2, 'ROLE_MODERATOR');

INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(1, 1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(2, 2);

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question', 'Error on project creation', '2019-05-05 18:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 2', 'Project dont compile', '2019-05-05 19:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 3', 'Tag HTML', '2019-05-05 20:00:00', 'UNANSWERED', 1, 2);