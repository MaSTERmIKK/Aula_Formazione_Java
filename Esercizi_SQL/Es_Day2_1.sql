SELECT Country.Name AS Nazione, CountryLanguage.Language, CountryLanguage.Percentage
FROM Country
JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode;



--    --------------------------------------------  --

SELECT c.Name AS Nazione, cl.Language, cl.Percentage
FROM Country c
JOIN CountryLanguage cl ON c.Code = cl.CountryCode
WHERE cl.Percentage >= ALL (
    SELECT cl2.Percentage
    FROM CountryLanguage cl2
    WHERE cl2.CountryCode = cl.CountryCode
);

--    --------------------------------------------  --

SELECT Nazione, Lingua, Percentuale
FROM (
    SELECT c.Name AS Nazione, cl.Language AS Lingua, cl.Percentage AS Percentuale
    FROM Country c
    JOIN CountryLanguage cl ON c.Code = cl.CountryCode
) AS SubLingue
WHERE Percentuale >= ALL (
    SELECT cl2.Percentage
    FROM CountryLanguage cl2
    WHERE cl2.CountryCode = (
        SELECT Code FROM Country WHERE Name = SubLingue.Nazione
    )
);


