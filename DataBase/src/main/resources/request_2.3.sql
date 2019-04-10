SELECT SUM(developers.salary)
FROM developers
       JOIN developers_skills ds ON developers.developer_id = ds.developer_id
       JOIN skills s ON ds.skills_id = s.skills_id
WHERE skill = 'Java';