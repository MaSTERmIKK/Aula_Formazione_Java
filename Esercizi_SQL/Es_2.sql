-- Creazione della tabella (solo se non esiste già)
CREATE TABLE Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione INT
);

-- 1) Inserimento dati
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione) VALUES
  (1, 'Il Nome della Rosa', 'Umberto Eco', 'Storico', 18.50, 1980),
  (2, 'Clean Code', 'Robert C. Martin', 'Tecnico', 32.90, 2008),
  (3, 'La Divina Commedia', 'Dante Alighieri', 'Classico', 15.00, 1320),
  (4, 'The Pragmatic Programmer', 'Andrew Hunt', 'Tecnico', 29.99, 1999),
  (5, 'Il Piccolo Principe', 'Antoine de Saint-Exupéry', 'Fiaba', 12.00, 1943),
  (6, '1984', 'George Orwell', 'Distopico', 14.20, 1949);

-- 2) Query con GROUP BY: numero libri e prezzo medio per genere
SELECT 
    genere, 
    COUNT(*) AS numero_libri, 
    ROUND(AVG(prezzo), 2) AS prezzo_medio
FROM Libri
GROUP BY genere
ORDER BY genere;

-- 3) Query con ORDER BY: libri dopo il 2010 ordinati per anno desc e prezzo asc
SELECT titolo, autore, prezzo, anno_pubblicazione
FROM Libri
WHERE anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC, prezzo ASC;
