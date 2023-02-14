CREATE TABLE IF NOT EXISTS city(
    id INTEGER,
    name VARCHAR(17),
    countrycode VARCHAR(3),
    district VARCHAR(20),
    population INTEGER
);

insert into city (id, name, countrycode, district, population) values (3976, 'Wichita', 'USA', 'Kansas', 184002);
insert into city (id, name, countrycode, district, population) values (3259, 'Long Beach', 'USA', 'California', 150760);
insert into city (id, name, countrycode, district, population) values (3727, 'Dallas', 'USA', 'Texas', 182521);
insert into city (id, name, countrycode, district, population) values (3458, 'Hartford', 'USA', 'Connecticut', 157777);
insert into city (id, name, countrycode, district, population) values (3236, 'Los Angeles', 'USA', 'California', 167366);
insert into city (id, name, countrycode, district, population) values (3358, 'Atlanta', 'USA', 'Georgia', 125291);
insert into city (id, name, countrycode, district, population) values (3983, 'Cleveland', 'USA', 'Ohio', 197639);
insert into city (id, name, countrycode, district, population) values (3313, 'Orlando', 'USA', 'Florida', 153559);
insert into city (id, name, countrycode, district, population) values (3335, 'Louisville', 'USA', 'Kentucky', 133932);
insert into city (id, name, countrycode, district, population) values (3110, 'Great Neck', 'USA', 'New York', 192317);
insert into city (id, name, countrycode, district, population) values (3109, 'Atlanta', 'USA', 'Georgia', 143369);
insert into city (id, name, countrycode, district, population) values (3989, 'Silver Spring', 'USA', 'Maryland', 193855);
insert into city (id, name, countrycode, district, population) values (3714, 'Lynchburg', 'USA', 'Virginia', 147600);
insert into city (id, name, countrycode, district, population) values (3390, 'Newton', 'USA', 'Massachusetts', 94003);
insert into city (id, name, countrycode, district, population) values (3637, 'Carson City', 'USA', 'Nevada', 190629);
insert into city (id, name, countrycode, district, population) values (3313, 'Phoenix', 'USA', 'Arizona', 118181);
insert into city (id, name, countrycode, district, population) values (3801, 'Newport Beach', 'USA', 'California', 130799);
insert into city (id, name, countrycode, district, population) values (3264, 'Fort Wayne', 'USA', 'Indiana', 96656);
insert into city (id, name, countrycode, district, population) values (3186, 'Fort Wayne', 'USA', 'Indiana', 121320);
insert into city (id, name, countrycode, district, population) values (3184, 'Saint Louis', 'USA', 'Missouri', 91244);

Select * From city Where (countrycode = 'USA') AND (population > 100000) LIMIT 5;