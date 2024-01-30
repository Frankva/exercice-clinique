USE clinic20231222;
INSERT INTO
specialties (name)
VALUES
('Oncologue'),
('Chirurgien'),
('Pédiatre'),
('Cardiologue'),
('Dermatologue');

INSERT INTO
buildings (name)
VALUES
('A'),
('B'),
('C'),
('D');

INSERT INTO
services (code, name, building_id)
VALUES
('002', 'Pédiatrie', 1),
('004', 'Chirurgie', 2),
('006', 'Cardiologie', 3),
('008', 'Oncologie', 4);
