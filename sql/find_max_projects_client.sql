SELECT c.ID , c.NAME , COUNT(p.ID) AS project_count
FROM client c
JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.ID, c.NAME

