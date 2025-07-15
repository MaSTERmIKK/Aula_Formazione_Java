-- 1) DISTINCT e WHERE
SELECT DISTINCT Region
FROM Country
WHERE Continent = 'Europe';

-- 2) WHERE e ORDER BY
SELECT Name, Population
FROM City
WHERE CountryCode = 'USA' AND Population > 1000000
ORDER BY Population DESC;

-- 3) GROUP BY con aggregazioni
SELECT Continent, COUNT(*) AS Numero_Paesi, SUM(Population) AS Popolazione_Totale
FROM Country
GROUP BY Continent
ORDER BY Popolazione_Totale DESC;
