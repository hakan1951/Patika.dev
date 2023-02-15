--1--
Select city, country
From country
Inner Join city ON city.country_id = country.country_id;

--2--
Select first_name, last_name, payment_id
From payment
Inner Join customer ON customer.customer_id = payment.customer_id;

--3--
Select first_name, last_name, rental_id
From rental
Inner Join customer ON customer.customer_id = rental.customer_id;