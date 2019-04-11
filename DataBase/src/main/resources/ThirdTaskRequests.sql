#salary all PhoneApp developers
SELECT SUM(salary)
FROM developers
       JOIN developers_projects dp on developers.developer_id = dp.developer_id
       JOIN projects p on dp.project_id = p.project_id
WHERE project_name = 'PhoneApp';

#PhoneApp developers
SELECT developer_name
FROM developers
       JOIN developers_projects dp on developers.developer_id = dp.developer_id
       JOIN projects p on dp.project_id = p.project_id
WHERE project_name = 'PhoneApp';

#Java developers
SELECT developer_name
FROM developers
       JOIN developers_skills ds on developers.developer_id = ds.developer_id
       JOIN skills s on ds.skills_id = s.skills_id
WHERE skill = 'Java';

#middle developers
SELECT developer_name
FROM developers
       JOIN developers_skills ds on developers.developer_id = ds.developer_id
       JOIN skills s on ds.skills_id = s.skills_id
WHERE skill_lvl = 'middle';

#projets list
SELECT dead_line, project_name, developer_name
FROM developers
       JOIN developers_projects dp on developers.developer_id = dp.developer_id
       JOIN projects p on dp.project_id = p.project_id
ORDER BY dead_line;
