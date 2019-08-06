drop view if exists UniqueDateupdatedSorted;

create view UniqueDateUpdatedSorted as
	select TVModel, Price,
		(select max(DateUpdated)) as RecentPrice
	from TVPrices
	group by TVModel;
	
select * from UniqueDateupdatedSorted;