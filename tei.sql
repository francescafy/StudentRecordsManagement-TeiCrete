drop database if exists tei;
create database tei;
use tei;

create table users(
idusers int not null AUTO_INCREMENT,
login varchar(45),
password varchar(45),
email  varchar(45),
firstname  varchar(45), 
lastname  varchar(45),
primary key(idusers));

create table teacher(
idteacher int,
eidikotita varchar(45),
endiaferonta  varchar(45),
tilefono  varchar(45),
primary key(idteacher),
constraint foreign key(idteacher) references users(idusers) on update cascade on delete cascade);

create table student(
idstudent int,
AM varchar(45),
examino int,
primary key(idstudent),
constraint foreign key(idstudent) references users(idusers) on update cascade on delete cascade);

create table lesson(
idlesson int not null AUTO_INCREMENT,
name varchar(45),
description varchar(45),
primary key(idlesson));

create table teaches(
idteaches int,
lesson_idlesson int,
teacher_idteacher int,
primary key(idteaches, lesson_idlesson, teacher_idteacher),
constraint foreign key(lesson_idlesson) references lesson(idlesson) on update cascade on delete cascade,
constraint foreign key(teacher_idteacher) references teacher(idteacher) on update cascade on delete cascade);

create table enrollment(
idenrollment int,
lesson_idlesson int,
student_idstudent int,
grade float,
status varchar(15),
primary key(idenrollment, lesson_idlesson, student_idstudent),
constraint foreign key(lesson_idlesson) references lesson(idlesson) on update cascade on delete cascade,
constraint foreign key(student_idstudent) references student(idstudent) on update cascade on delete cascade);

create table prerequisite(
lesson_idlesson1 int,
lesson_idlesson2 int,
primary key(lesson_idlesson1,lesson_idlesson2),
constraint foreign key(lesson_idlesson1) references lesson(idlesson) on update cascade on delete cascade,
constraint foreign key(lesson_idlesson2) references lesson(idlesson) on update cascade on delete cascade);

insert into users values(null, 'abc', '000', 'tp4669@edu.teicrete.gr', 'Georgia', 'Athanasaki'),
						(null, 'def', '001', 'tp1000@edu.teicrete.gr', 'Francesca', 'Fyrigou'),
                        (null, 'ghi', '002', 'tp1500@edu.teicrete.gr', 'Dimitios', ' Gionakis'),
                        (null, 'jkl', '003', 'tp1600@edu.teicrete.gr', 'Maria', 'Callas'),
                        (null, 'mno', '004', 'tp1700@edu.teicrete.gr', 'Charles', 'Chaplin'),
                        (null, 'pqr', '005', 'tp1800@edu.teicrete.gr', 'Johnny', 'Depp'),
                        (null, 'stu', '006', 'tp1900@edu.teicrete.gr', 'Michael', 'Jackson'),
                        (null, 'vxz', '007', 'tp2000@edu.teicrete.gr', 'Jack', 'Nicholson'),
                        (null, 'ab1', '008', 'tp2100@edu.teicrete.gr', 'Ozzy', 'Osbourne'),
                        (null, 'def1', '009', 'tp2200@edu.teicrete.gr', 'Hugh', 'Jackman'),
                        (null, 'ghi1', '010', 'tp2300@edu.teicrete.gr', 'Al', 'Pacino'),
                        (null, 'jkl1', '011', 'tp2400@edu.teicrete.gr', 'Neil', ' Armstrong');
                        
insert into teacher values(1, 'Μathematician', 'Αlgebra', '+302810636985'),
							(3, 'Physicist', 'Ilektromagnitismos','+30310258471'),
                            (5, 'Computer', 'Internet Applications','+30210479132'),
                            (6, 'Computer', 'Software','+302810194080'),
                            (2, 'Computer', 'DataBases', '+302810678732');

insert into student values(2, 'tp1000', 10),
							(4, 'tp1600', 8),
                            (7, 'tp1900', 6),
                            (8, 'tp2000', 3),
                            (9, 'tp2100', 3),
                            (10, 'tp2200', 2),
                            (11, 'tp2300', 2),
                            (12, 'tp2400', 1);
                            
insert into lesson values(null, 'Grammiki', 'Praxeis me pinakes'),
							(null, 'Diakrita', 'Peperasmenes mhxanes'),
                            (null, 'Efarmosmena', 'Metasxhmatismos Laplace'),
							(null, 'Apeirostikos', 'Olokliromata'),
                            (null, 'Vaseis Dedomenon', 'Ontotites-Susxetiseis'),
                            (null, 'Leitourgika', 'Diergasies'),
                            (null, 'Algorithmoi', 'Taxinomisi'),
                            (null, 'Polimesa', 'Eikona-hxos'),
                            (null, 'Fusikh 1', 'Nomoi Newton');
                            
insert into teaches values(1, 1, 1),
							(2, 2, 1),
                            (3, 3, 1),
                            (4, 4, 1),
                            (5, 5, 6),
                            (6, 6, 5),
                            (7, 7, 6),
                            (8, 8, 6),
                            (9, 9, 3);
						
insert into enrollment values(1, 1, 2, 5.5, 'Pass'),
						(2, 1, 7, 8, 'Pass'),
                        (3, 3, 10, 6, 'Pass'),
                        (4, 9, 10, 4.5, 'Fail'),
                        (5, 8, 9, 3, 'Fail'),
                        (6, 2, 4, 7, 'Pass'),
                        (7, 4, 8, 6, 'Pass'),
                        (8, 4, 10, 8.5, 'Pass'),
                        (9, 4, 2, 7.2, 'Pass'),
                        (10, 1, 2, 5, 'Pass');
                        
insert into prerequisite values(4, 1),
								(4,2),
                                (4,3),
                                (4,9),
                                (5,7);

select* from users;
select* from teacher;
select* from student;
select* from lesson;
select* from teaches;
select* from enrollment;
select* from prerequisite;

SELECT * FROM users
left JOIN teacher ON users.idusers = teacher.idteacher;

SELECT * FROM users
left JOIN teacher ON users.idusers = teacher.idteacher
WHERE teacher.idteacher IS NULL;