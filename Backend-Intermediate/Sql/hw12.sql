--1--
Select Count(*)
From film
Where film.length > 
(Select AVG(film.length) From film);

--2--
Select Count(*)
From film
Where film.rental_rate =
(Select MAX(film.rental_rate) From film);

--3--
Select Count(*)
From film
Where (film.rental_rate = (Select MAX(film.rental_rate) From film)
	   AND
	   (film.replacement_cost = (Select MAX(film.replacement_cost) From film )));

--4--
Select customer.first_name, customer.last_name, Count(payment.customer_id) AS nop
From payment Join customer ON payment.customer_id = customer.customer_id
Group By payment.customer_id, customer.first_name, customer.last_name
Order By nop Desc;