use quanlysinhvien;
select *
from student
where StudentName like'h%';

select *
from class
where  Month(StartDate)=12;

select *
from subject
where Credit between 3 and 5;

SET SQL_SAFE_UPDATES = 0;
update student
set ClassId=2
where StudentName='Hung';

select student.StudentName, subject.SubName, mark.Mark
from((student
inner join subject on student.StudentId=subject.SubId)
inner join mark on student.StudentId=mark.MarkId)
order by Mark DESC ,StudentName asc; 