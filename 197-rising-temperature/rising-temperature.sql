SELECT today.id
FROM Weather today
INNER JOIN Weather yesterday
    ON DATEDIFF(DAY, yesterday.recordDate, today.recordDate) = 1
WHERE today.temperature > yesterday.temperature;
