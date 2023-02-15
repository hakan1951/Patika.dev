--1--
(Select first_name From actor)
Union
(Select first_name From customer);

--2--
(Select first_name From actor)
Intersect
(Select first_name From customer);

--3--
(Select first_name From actor)
Except
(Select first_name From customer);

--4.1--
(Select first_name From actor)
Union All
(Select first_name From customer);

--4.2--
(Select first_name From actor)
Intersect All
(Select first_name From customer);

--4.3--
(Select first_name From actor)
Except All
(Select first_name From customer);