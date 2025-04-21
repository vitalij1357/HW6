SELECT
    p.ID AS project_id,
    p.START_DATE,
    p.FINISH_DATE,
    c.NAME AS client_name,
    TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) AS duration_months,
    SUM(w.SALARY) * TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) AS project_price
FROM
    project p
JOIN
    client c ON p.CLIENT_ID = c.ID
JOIN
    project_worker pw ON p.ID = pw.PROJECT_ID
JOIN
    worker w ON pw.WORKER_ID = w.ID
GROUP BY
    p.ID, p.START_DATE, p.FINISH_DATE, c.NAME
ORDER BY
    project_price DESC;