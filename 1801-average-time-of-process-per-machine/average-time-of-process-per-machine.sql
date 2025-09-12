SELECT
    s.machine_id,
    ROUND( AVG( CAST(e.timestamp - s.timestamp AS DECIMAL(12,6)) ), 3 ) AS processing_time
FROM Activity AS s
JOIN Activity AS e
  ON s.machine_id = e.machine_id
 AND s.process_id  = e.process_id
WHERE s.activity_type = 'start'
  AND e.activity_type = 'end'
GROUP BY s.machine_id;
