drop view if exists ListTableSorted;

create view ListTableSorted as
	select TVModel, DateUpdated, Price
	from TVPrices
	order by DateUpdated desc;

select * from ListTableSorted;