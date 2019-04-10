ALTER TABLE developers ADD COLUMN salary INT;

UPDATE developers SET developers.salary = 1500 WHERE developer_id = 1;
UPDATE developers SET developers.salary = 1400 WHERE developer_id = 2;
UPDATE developers SET developers.salary = 1300 WHERE developer_id = 3;
UPDATE developers SET developers.salary = 1700 WHERE developer_id = 4;
UPDATE developers SET developers.salary = 1800 WHERE developer_id = 5;
UPDATE developers SET developers.salary = 1900 WHERE developer_id = 6;