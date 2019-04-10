SELECT AVG(developers.salary), project_name, cost
FROM developers
       JOIN developers_projects dp ON developers.developer_id = dp.developer_id
       JOIN projects p ON dp.project_id = p.project_id
GROUP BY p.project_id
HAVING MIN(cost)
ORDER BY SUM(developers.salary) DESC LIMIT 1, 2;