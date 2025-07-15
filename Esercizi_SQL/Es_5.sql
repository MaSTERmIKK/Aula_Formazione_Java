-- Creazione tabelle (se non esistono già)
CREATE TABLE Clienti (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    citta VARCHAR(100)
);

CREATE TABLE Ordini (
    id INT PRIMARY KEY,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7,2),
    FOREIGN KEY (id_cliente) REFERENCES Clienti(id)
);

-- 1) INNER JOIN: clienti con almeno un ordine
SELECT 
    c.nome AS cliente,
    o.data_ordine,
    o.importo
FROM Clienti AS c
INNER JOIN Ordini AS o
    ON c.id = o.id_cliente;

-- 2) LEFT JOIN: tutti i clienti, anche senza ordini
SELECT 
    c.nome AS cliente,
    o.data_ordine,
    o.importo
FROM Clienti AS c
LEFT JOIN Ordini AS o
    ON c.id = o.id_cliente;

-- 3) RIGHT JOIN: tutti gli ordini, anche senza cliente (possibile dato errato)
SELECT 
    c.nome AS cliente,
    o.data_ordine,
    o.importo
FROM Clienti AS c
RIGHT JOIN Ordini AS o
    ON c.id = o.id_cliente;
