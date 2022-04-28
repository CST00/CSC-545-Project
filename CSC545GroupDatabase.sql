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
    recipe varchar(20),
    primary key(day,mealtype)
);

create table Recipe(
    recipeName varchar(20) primary key,
    instructions varchar(100),
    category varchar(30)
);

create table Ingredient(
    ingredientName varchar(20) primary key,
    ingredientGroup varchar(20)
);

create table Nutrition(
    ingredientName varchar(20),
    servingSize varchar(20),
    calories int,
    protein int,
    fat int,
    carbs int,
    primary key(ingredientName,servingSize)
);

create table Stock(
    ingredientName varchar(20) primary key,
    inStock varchar(6)
);

create table Needs(
    recipeName varchar(20),
    ingredientName varchar(20),
    primary key(recipeName,ingredientName)
);

--insert values
insert into Meal values('Sunday','Breakfast','Omelette');

insert into Recipe values('Omelette','Crack eggs, put on stove, top with cheese, cook until solid', 'placeholder');

insert into Ingredient values('Egg','placeholder');
insert into Ingredient values('Cheddar','Dairy');

insert into Nutrition values('Egg','1 egg',70,6,5,1);
insert into Nutrition values('Cheddar', '2 tbsp', 110,7,9,1);

insert into Stock values('Egg','true');
insert into Stock values('Cheddar','false');

insert into Needs values('Omelette','Egg');
insert into Needs values('Omelette','Cheddar');

--select data
select * from Meal;
select * from Recipe;
select * from Ingredient;
select * from Nutrition;
select * from Stock;
select * from Needs;