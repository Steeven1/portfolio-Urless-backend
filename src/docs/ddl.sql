CREATE TABLE customers(
	id uniqueidentifier  PRIMARY KEY DEFAULT NEWID(),
	ci CHAR(10),
	email VARCHAR(100),
	password VARCHAR(100),
	firstname VARCHAR(50),
	lastname VARCHAR(50),	
);

INSERT INTO customers
(ci, email, password, firstname, lastname)
VALUES('2350060915', 'alfred@espe.edu.c', '123', 'Steeven', 'Engracia');

CREATE TABLE urls(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	raw_url VARCHAR(100),
	short_url VARCHAR(50),
	customer_id uniqueidentifier,
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE SEQUENCE url_index
    START WITH 1
    INCREMENT BY 1;

-- cursor for urls with pagination
DECLARE 
	@id BIGINT,
	@raw_url VARCHAR(100),
	@short_url VARCHAR(50)

DECLARE
	list_urls CURSOR LOCAL STATIC READ_ONLY
	FOR SELECT id, raw_url, short_url FROM urls;
OPEN list_urls;
	FETCH NEXT FROM list_urls
		INTO @id, @short_url, @raw_url
		WHILE (@@FETCH_status = 0)
			BEGIN 
				PRINT str(@id) +' , '+@raw_url+' , '+@short_url
				FETCH NEXT FROM list_urls INTO @id, @short_url, @raw_url
			END
CLOSE list_urls
DEALLOCATE list_urls

-- OFFSET FETCH for pagination
DECLARE @Pagina INT = 1;
DECLARE @RegistrosPorPagina INT = 10;
DECLARE @Offset INT = (@Pagina - 1) * @RegistrosPorPagina;

SELECT *
FROM urls
ORDER BY id -- ¡Siempre debes ordenar!
OFFSET @Offset ROWS
FETCH NEXT @RegistrosPorPagina ROWS ONLY;


-- Clave-based pagination or also named cursor-based pagination 

-- limit must be grether than 0 and less than 100
DECLARE @pageSize INT = 4;
DECLARE @lastShortUrl VARCHAR(50) = 'https://fake-api3.com/';
DECLARE @hasMore BIT;
DECLARE @lastId BIGINT;


SET @lastId = (
	SELECT MAX(lastIDs.id) FROM (
	SELECT TOP (@pageSize) id
	FROM urls 
	ORDER BY id ASC
	) AS lastIDs(id)
)
PRINT str(@lastId)

--SET @lastId = 1;

SET @hasMore = CASE 
    WHEN EXISTS (SELECT 1 FROM urls WHERE id < @LastId) THEN 1
    ELSE 0 END;

PRINT str(@hasMore)

-- Obtener próxima 
SELECT TOP (@pageSize)id, short_url, raw_url
FROM urls
WHERE id > @lastId
ORDER BY id ASC;


SELECT * FROM urls;
INSERT INTO urls (raw_url, short_url ,customer_id)
VALUES 
('https://fake-api2.com/',	'http://127.0.0.1/urls/0000004','F9793CB6-AC58-4B19-8B8E-1B4FBF0D8BB2'),
('https://fake-api3.com/',	'http://127.0.0.1/urls/0000005','F9793CB6-AC58-4B19-8B8E-1B4FBF0D8BB2');







