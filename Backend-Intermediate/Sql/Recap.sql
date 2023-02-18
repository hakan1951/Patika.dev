---- 1. At least 4 'e' or 'E' ----
Select *
From film
Where title ILIKE '%e%e%e%e%';

---- 2. Number of Films per Categories -----
Select category.name, Count(category.category_id) AS nof
From film_category JOIN film ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
Group By category.name;

---- 3. Most films of 'rating category'(column). ----
Select rating, Count(*) AS nof 
From film
Group By rating
Order By nof DESC
Limit 1;

---- 4. Three films, their names starting with 'K'; with longest length and lowest replacement_cost. ----
Select film_id, title, length, replacement_cost
From film
Where film.title LIKE 'K%'
Order By film.length DESC, replacement_cost ASC
Limit 3;

---- 5. The customer with most purchases. ----
Select customer.first_name, customer.last_name, Count(payment.payment_id) AS purchases
From payment Join customer ON payment.customer_id = customer.customer_id
Group By customer.customer_id
Order By purchases DESC
Limit 1;
