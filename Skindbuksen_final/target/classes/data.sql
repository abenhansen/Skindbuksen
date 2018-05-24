INSERT INTO Skindbuksen.users (`username`, `password`, `roles`)
SELECT 'admin', 'admin', 'admin'
WHERE NOT EXISTS (SELECT * FROM Skindbuksen.users);