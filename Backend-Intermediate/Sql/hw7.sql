--1--
Select rating
From film
Group By film.rating;

--2--
Select replacement_cost, Count(*)
From film
Group By film.replacement_cost
Having Count(film.replacement_cost)>50;

--3--
Select store_id, Count(*)
From customer
Group By customer.store_id;

--4--
Select country_id, Count(*)
From city
Group By country_id
Order By Count(*)
LIMIT 1;