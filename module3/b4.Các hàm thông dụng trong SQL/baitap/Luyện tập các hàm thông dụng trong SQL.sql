use quanlysinhvien;

select  *,max(Credit) as 'điểm cao'
from subject;

select subject.SubId,subject.SubName,avg(mark)
from mark 
join student on mark.StudentId=student.StudentId 
join subject on mark.SubId=subject.SubId
group by subject.SubId,subject.SubName
having AVG(Mark) > ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

SELECT M.StudentId, S.StudentName,  max(M.Mark) as Điểm
FROM Mark M  join Student S on S.StudentId = M.StudentId
GROUP BY M.StudentId
order by Điểm desc;