SELECT SUM(developers.salary), project_name
FROM developers
       JOIN developers_projects dp ON developers.developer_id = dp.developer_id
       JOIN projects p ON dp.project_id = p.project_id
GROUP BY project_name
ORDER BY SUM(developers.salary) DESC
LIMIT 1;
