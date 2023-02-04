--1--
Select AVG(rental_rate)
From film;

--2--
Select Count(*)
From film
Where film.title LIKE 'C%';

--3--
Select MAX(film.length)
From film
Where film.rental_rate=0.99;

--4--
Select Count(Distinct replacement_cost)
From film
Where film.length>150;