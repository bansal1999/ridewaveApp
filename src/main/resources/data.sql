INSERT INTO app_user(name, email, password) VALUES
('John Doe', 'johndoe@example.com', '@johndoe1'),
('Jane Smith', 'janesmith@example.com', '@janesmith2'),
('Michael Johnson', 'michaeljohnson@example.com', '@michaeljohnson3'),
('Emily Davis', 'emilydavis@example.com', '@emilydavis4'),
('David Wilson', 'davidwilson@example.com', '@davidwilson5'),
('Olivia Miller', 'oliviamiller@example.com', '@oliviamiller6'),
('Sophia Taylor', 'sophiataylor@example.com', '@sophiataylor7'),
('Christopher Brown', 'christopherbrown@example.com', '@christopherbrown8'),
('Ava Garcia', 'avagarcia@example.com', '@avagarcia9'),
('William Davis', 'williamdavis@example.com', '@williamdavis10'),
('Emma Wilson', 'emmawilson@example.com', '@emmawilson11'),
('Daniel Smith', 'danielsmith@example.com', '@danielsmith12'),
('Oliver Taylor', 'olivertaylor@example.com', '@olivertaylor13'),
('Sofia Johnson', 'sofiajohnson@example.com', '@sofiajohnson14'),
('Matthew Brown', 'matthewbrown@example.com', '@matthewbrown15'),
('Aiden Garcia', 'aidengarcia@example.com', '@aidengarcia16'),
('Henry Wilson', 'henrywilson@example.com', '@henrywilson17'),
('Mia Davis', 'miadavis@example.com', '@miadavis18'),
('James Smith', 'jamessmith@example.com', '@jamessmith19'),
('Ella Johnson', 'ellajohnson@example.com', '@ellajohnson20');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(1, 'DRIVER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(10, 'DRIVER'),
(11, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(20, 'DRIVER');

INSERT INTO rider (id, user_id, rating) VALUES
(1, 1, 4.9)

INSERT INTO driver (id, user_id, rating, available, current_location) VALUES
(1, 1, 4.9, true, ST_GeomFromText('POINT(77.2025 28.6041)', 4326)),
(3, 3, 4.5, true, ST_GeomFromText('POINT(77.2025 28.6041)', 4326)),
(4, 4, 4.8, false, ST_GeomFromText('POINT(77.3025 28.7041)', 4326)),
(5, 5, 4.6, true, ST_GeomFromText('POINT(77.4025 28.8041)', 4326)),
(6, 6, 4.9, false, ST_GeomFromText('POINT(77.5025 28.9041)', 4326)),
(7, 7, 4.7, true, ST_GeomFromText('POINT(77.6025 29.0041)', 4326)),
(8, 8, 4.5, false, ST_GeomFromText('POINT(77.7025 29.1041)', 4326)),
(9, 9, 4.8, true, ST_GeomFromText('POINT(77.8025 29.2041)', 4326)),
(10, 10, 4.6, false, ST_GeomFromText('POINT(77.9025 29.3041)', 4326)),
(11, 11, 4.9, true, ST_GeomFromText('POINT(78.0025 29.4041)', 4326)),
(12, 12, 4.7, false, ST_GeomFromText('POINT(78.1025 29.5041)', 4326)),
(13, 13, 4.5, true, ST_GeomFromText('POINT(78.2025 29.6041)', 4326)),
(14, 14, 4.8, false, ST_GeomFromText('POINT(78.3025 29.7041)', 4326)),
(15, 15, 4.6, true, ST_GeomFromText('POINT(78.4025 29.8041)', 4326)),
(16, 16, 4.9, false, ST_GeomFromText('POINT(78.5025 29.9041)', 4326)),
(17, 17, 4.7, true, ST_GeomFromText('POINT(78.6025 30.0041)', 4326)),
(18, 18, 4.5, false, ST_GeomFromText('POINT(78.7025 30.1041)', 4326)),
(19, 19, 4.8, true, ST_GeomFromText('POINT(78.8025 30.2041)', 4326)),
(20, 20, 4.6, false, ST_GeomFromText('POINT(78.9025 30.3041)', 4326));