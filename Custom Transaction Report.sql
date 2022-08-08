create database final_project;
use final_project;

create table Product(
productid bigint primary key,
productname text,
cost float,
category varchar(50)
);


create table Transaction(transactionid bigint primary key,
merchantid bigint,
customername varchar(50),
cartid bigint,
purchasedat timestamp,
billingaddress text,
totalamount float,
paymentreceived timestamp,
pincode int,
foreign key(merchantid) references Merchant(merchantid),
foreign key(cartid) references Cart(cartid)
);

create table FilterPreference(
filterid bigint primary key,
merchantid bigint,
upperlimit float,
lowerlimit float,
pincode int,
customername varchar(50),
foreign key(merchantid) references Merchant(merchantid)
);

create table Cart(cartid bigint, productid bigint,quantity int,primary key(cartid,productid));

insert into Cart values(5001,2001,2),(5001,2002,1),(5002,2003,3),(5002,2004,4),(5003,2005,1),(5003,2006,2),(5004,2007,5),(5004,2008,1),(5005,2009,4),(5005,2010,3),
(5006,2001,5),(5006,2002,1),(5007,2003,2),(5007,2004,6),(5008,2005,4),(5008,2006,3),(5009,2007,2),(5009,2008,5),(5010,2009,4),(5010,2010,6);
-- insert into Cart values(5002,2002,10),(5002,2003,5 ); 
delete from Cart;
select * from Cart;
desc Cart;

create table Merchant(merchantid bigint primary key, merchantname varchar(50), username text, password text);

desc Transaction;
desc FilterPreference;
insert into Merchant values(1001,"Rushikesh","rushikesh@gmail.com","rushikesh"),(1002,"Akshay","akshay@gmail.com","akshay"),(1003,"Prajwal","prajwal@gmail.com","prajwal");
select * from Merchant;

insert into Product values(2001,"Redmi10",14999.00,"Mobile"),(2002,"RealMe Narzo",13499.00,"Mobile"),(2003,"Samsung galaxy A13",13999.00,"Mobile");
delete from Product;
delete from Transaction;
insert into Product values(2004,"Vivo Y33",17990.00,"Mobile"),(2005,"Samsung Galaxy M32",11999.00,"Mobile"),(2006,"One Plus 10pro",55999.00,"Mobile"),(2007,"Boat Smart watch",1599.00,"Electronics"),(2008,"Noise Smart Watch",2000.00,"Electronics"),(2009,"Boat Earpodes",4000.00,"Electronics"),(2010,"Nothing one",35000.00,"Mobile");
select * from Product;
insert into Cart values(5001,2001,3),(5001,2002,4);
insert into Cart values(5002,2002,10),(5002,2003,5);
select * from Cart;

-- insert into transaction values(2345680,1001,"Rohit",5001,'2021-09-22 08:30:45',"Mumbai",156.00,'2021-10-21 04:23:45',413501);
-- /*(2345679,1002,"Ashok",2003,4,CURRENT_TIMESTAMP,"Chennai",CURRENT_TIMESTAMP,"400066");*/
-- insert into transaction values(2345681,1002,"Virat",5002,'2021-08-22 08:30:45',"Hyderabad",1000.00,'2021-10-21 04:23:45',400063);
-- insert into transaction values(2345682,1003,"Sachin",5001,'2021-08-22 08:30:45',"Chennai",2000.00,'2021-09-21 04:23:45',42009);
insert into transaction values(2345680,1001,"Rohit",5001,'2021-09-22 08:30:45',"Mumbai",43497.00,'2021-10-21 04:23:45',413701),
(2345681,1001,"Sachin",5001,'2021-08-13 09:30:45',"Hyderabad",113957.00,'2021-10-29 04:23:45',400065),
(2345682,1001,"Virat",5001,'2021-09-26 03:30:45',"Chennai",123997.00,'2021-10-28 04:23:45',40063),
(2345683,1001,"Laxman",5001,'2021-09-25 08:30:45',"Delhi",9995.00,'2021-10-27 04:23:45',400065),
(2345684,1001,"Rohit",5001,'2020-01-10 07:30:45',"Mumbai",121000.00,'2021-04-15 04:23:45',40063),
(2345685,1001,"Virat",5001,'2020-09-24 08:30:45',"Hyderabad",88494.00,'2020-10-11 04:23:45',413701),
(2345686,1001,"Shikhar",5001,'2021-02-23 08:30:45',"Chennai",135938.00,'2021-02-23 04:23:45',400065),
(2345687,1001,"Rohit",5001,'2021-06-29 06:30:45',"Delhi",215993.00,'2021-06-25 04:23:45',413701),
(2345688,1001,"Raam",5001,'2022-01-22 05:30:45',"Mumbai",13198.00,'2022-01-21 04:23:45',40063),
(2345689,1001,"lakhan",5001,'2022-07-20 04:30:45',"Hyderabad",226000.00,'2022-07-22 04:23:45',413701);
select * from transaction;

select * from Cart;

select * from Transaction inner join Cart on Transaction.cartid = Cart.cartid;

select (p.cost * c.quantity) as'totalAmount' from Product p,Cart c where p.productid = c.productid; 

select * from Transaction where purchasedat > '2022-08-04 00:00:00' and purchasedat < current_timestamp; 

insert into filterPreference values(3001,1001,100.00,5.00,400063,"Rohit");
/*(3002,1002,2000.00,1000.00,400066,"Ashok");*/

select * from Transaction where totalamount >
(select upperlimit from FilterPreference where merchantid=1001);

select * from Transaction where totalamount >100;

select * from FilterPreference;
show tables;
select customername,count(customername) from transaction group by customername order by count(customername) desc limit 1;
select * from Transaction where customername=(select customername from transaction group by customername having purchasedat > '2020-01-10 07:30:45' and purchasedat < '2022-01-10 07:30:45' order by count(customername) desc limit 1);
-- SELECT customerid, COUNT(customerid) AS CountOfCust
-- FROM TableName
-- GROUP BY customerid

