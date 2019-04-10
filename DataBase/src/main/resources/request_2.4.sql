ALTER TABLE projects ADD COLUMN cost INT;

UPDATE projects SET projects.cost = 10000 WHERE project_name = 'PhoneApp';
UPDATE projects SET projects.cost = 15000 WHERE project_name = 'DeskTopApp';