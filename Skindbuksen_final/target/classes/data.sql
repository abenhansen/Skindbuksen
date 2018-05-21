INSERT INTO Skindbuksen.users (`username`, `password`, `role`)
SELECT 'admin', 'admin', 'admin'
WHERE NOT EXISTS (SELECT * FROM Skindbuksen.users);