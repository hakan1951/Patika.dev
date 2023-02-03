--1--
Select Distinct replacement_cost
From film;

--2--
Select Count (Distinct replacement_cost
From film;

--3--
Select Count(title)
From film
Where film.title LIKE'T%' AND film.rating='G';

--4--
Select Count(country)
From country
Where country.country LIKE '_____';


Select Count(city)
From city
Where city.city ILIKE '%r';