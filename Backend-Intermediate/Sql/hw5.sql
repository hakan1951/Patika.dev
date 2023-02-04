--1--
Select *
From film 
Where film.title LIKE '%n'
Order By film.length DESC LIMIT 5;

--2--
Select *
From film 
Where film.title LIKE '%n'
Order By film.length ASC OFFSET 5 LIMIT 5;

--3--
Select *
From customer
Where customer.store_id=1
Order By customer.last_name DESC LIMIT 4;