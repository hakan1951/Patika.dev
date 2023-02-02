--1--
Select country
From country
Where country.country LIKE 'A%a';

--2--
Select country
From country
Where country.country LIKE '_____%n';

--3--
Select title
From film
Where title ILIKE '%t%t%t%t%';

--4--
Select *
From film
Where film.title LIKE 'C%' AND film.length>90 AND rental_rate=2.99;
