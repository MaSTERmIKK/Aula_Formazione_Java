-- 1. Clienti con email su dominio Gmail
SELECT * 
FROM Clienti
WHERE email LIKE '%@gmail.com';

-- 2. Clienti con nome che inizia con la lettera 'A'
SELECT * 
FROM Clienti
WHERE nome LIKE 'A%';

-- 3. Clienti con cognome di esattamente 5 lettere
SELECT * 
FROM Clienti
WHERE cognome LIKE '_____';  -- 5 underscore = 5 caratteri esatti

-- 4. Clienti con età compresa tra 30 e 40 anni inclusi
SELECT * 
FROM Clienti
WHERE eta BETWEEN 30 AND 40;

-- 5. Clienti che vivono in città che contengono 'roma' (case-insensitive)
-- Versione generica (valida su molti DBMS che non distinguono il case per default):
SELECT * 
FROM Clienti
WHERE LOWER(citta) LIKE '%roma%';

-- Nota: in MySQL il LIKE è *case-insensitive* per default su charset utf8_general_ci.
-- In PostgreSQL si può usare ILIKE (case-insensitive LIKE):
-- SELECT * FROM Clienti WHERE citta ILIKE '%roma%';
