--drop tables if they already exist
drop table Meal;
drop table Recipe;
drop table Ingredient;
drop table Nutrition;
drop table Stock;
drop table Needs;

--create tables
create table Meal(
    day varchar(10),
    mealType varchar(10),
    recipeName varchar(50),
    primary key(day,mealtype)
);

create table Recipe(
    recipeName varchar(50) primary key,
    instructions varchar(100),
    category varchar(30)
);

create table Ingredient(
    ingredientName varchar(50) primary key,
    ingredientGroup varchar(20)
);

create table Nutrition(
    ingredientName varchar(50),
    servingSize varchar(20),
    calories int,
    protein int,
    fat int,
    carbs int,
    primary key(ingredientName,servingSize)
);

create table Stock(
    ingredientName varchar(50) primary key,
    inStock varchar(6)
);

create table Needs(
    recipeName varchar(50),
    ingredientName varchar(50),
    primary key(recipeName,ingredientName)
);

--insert values
insert into Meal values('Sunday','Breakfast','Omelette');
insert into Meal values('Sunday','Lunch','Burger and fries');
insert into Meal values('Monday','Dinner','Steak and fries');

insert into Recipe values('Omelette','Crack eggs, put on stove, top with cheese, cook until solid', 'vegetarian');
insert into Recipe values('Cheeseburger and fries','Put cooked patty and cheese between 2 buns, serve with fries','Meat');
insert into Recipe values('Steak and fries','Cook steak until medium rare, serve with fries','Meat');

insert into Ingredient values('Egg','Poultry');
insert into Ingredient values('Cheddar','Dairy');
insert into Ingredient values('Burger patty','Meat');
insert into Ingredient values('Burger buns','Bread');
insert into Ingredient values('American cheese','Dairy');
insert into Ingredient values('French fries','Side');
insert into Ingredient values('Steak','Meat');

insert into Nutrition values('Egg','1 egg',70,6,5,1);
insert into Nutrition values('Cheddar', '2 tbsp', 110,7,9,1);
insert into Nutrition values('Burger patty','4oz',280,19,22,0);
insert into Nutrition values('Burger buns','2 buns',100,3,1,20);
insert into Nutrition values('American cheese','1 slice',60,3,4,2);
insert into Nutrition values('French fries','100g',143,2,5,24);
insert into Nutrition values('Steak','6oz',320,34,19,1);

insert into Stock values('Egg','true');
insert into Stock values('Cheddar','false');
insert into Stock values('Burger patty','false');
insert into Stock values('Burger buns','false');
insert into Stock values('American cheese','true');
insert into Stock values('French fries','false');
insert into Stock values('Steak','false');

insert into Needs values('Omelette','Egg');
insert into Needs values('Omelette','Cheddar');
insert into Needs values('Cheeseburger and fries','Burger patty');
insert into Needs values('Cheeseburger and fries','Burger buns');
insert into Needs values('Cheeseburger and fries','American cheese');
insert into Needs values('Cheeseburger and fries','French fries');
insert into Needs values('Steak and fries','Steak');
insert into Needs values('Steak and fries','French fries');

--select data
select * from Meal;
select * from Recipe;
select * from Ingredient;
select * from Nutrition;
select * from Stock;
select * from Needs;