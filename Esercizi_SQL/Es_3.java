-- 1. Totale vendite per categoria
SELECT categoria, COUNT(*) AS numero_vendite
FROM Vendite
GROUP BY categoria;

-- 2. Prezzo medio per categoria
SELECT categoria, ROUND(AVG(prezzo_unitario), 2) AS prezzo_medio
FROM Vendite
GROUP BY categoria;

-- 3. Quantità totale venduta per ogni prodotto
SELECT prodotto, SUM(quantita) AS totale_quantita
FROM Vendite
GROUP BY prodotto;

-- 4. Prezzo massimo e minimo venduto nella tabella
SELECT 
    MAX(prezzo_unitario) AS prezzo_massimo, 
    MIN(prezzo_unitario) AS prezzo_minimo
FROM Vendite;

-- 5. Numero totale di righe nella tabella
SELECT COUNT(*) AS totale_vendite
FROM Vendite;

-- 6. I 5 prodotti più costosi
SELECT prodotto, prezzo_unitario
FROM Vendite
ORDER BY prezzo_unitario DESC
LIMIT 5;

-- 7. I 3 prodotti meno venduti per quantità totale
SELECT prodotto, SUM(quantita) AS totale_venduta
FROM Vendite
GROUP BY prodotto
ORDER BY totale_venduta ASC
LIMIT 3;
