-- 1 --
Select title, description
From film;

-- 2 --
Select *
From film
Where film.length>60 AND film.length<75;

-- 3 --
Select *
From film
Where (rental_rate=0.99)AND(replacement_cost=12.99 OR replacement_cost=28.99);

-- 4 --
Select last_name
From customer
Where first_name = 'Mary';

-- 5 --
Select
From film
Where (NOT film.length > 50) AND ((rental_rate<>2.99 OR rental_rate<>4.99));