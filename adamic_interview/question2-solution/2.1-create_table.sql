drop table if exists TVPrices;

create table TVPrices (
	TVModel varchar(20),
	DateUpdated datetime,
	Price money
);
insert into TVPrices (TVModel, DateUpdated, Price)
values 
('Samsung v100', '2012/2/23 23:00', 549.99),
('Sony x300', '2012/5/22 0:00', 359.99),
('Samsung v100', '2013/1/22 10:20', 359.99),
('Samsung v100', '2013/2/22 0:00', 399.99),
('Sony x300', '2013/2/23 0:00', 329.99),
('Samsung v100', '2013/2/23 21:30', 639.99),
('Sony x300', '2013/5/23 22:00', 629.99),
('Sony x300', '2013/5/23 22:00', 629.99),
('Samsung z100', '2013/6/11 22:00', 879.99);
