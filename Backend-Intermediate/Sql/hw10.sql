--1--
Select city.city, country.country
From city Left Join country ON city.country_id = country.country_id;

--2--
Select customer.first_name, customer.last_name, payment.payment_id
From payment Right Join customer ON payment.customer_id = customer.customer_id;

--3--
Select customer.first_name, customer.last_name, rental.rental_id
From rental Full Join customer ON rental.customer_id = customer.customer_id;