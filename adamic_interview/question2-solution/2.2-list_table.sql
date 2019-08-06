drop view if exists ListTable;

create view ListTable as 
	select * from TVPrices;
	
select * from ListTable;
