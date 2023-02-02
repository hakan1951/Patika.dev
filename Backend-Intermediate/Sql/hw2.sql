--1--
Select *
From film
Where replacement_cost Between 12.99 And 16.99 AND (replacement_cost<16.99);

--2--
Select first_name, last_name
From actor
Where actor.first_name IN ('Penelope', 'Nick', 'Ed');

--3--
Select *
From film
Where (rental_rate IN (0.99, 2.99, 4.99)) AND (replacement_cost IN (12.99, 15.99, 28.99));