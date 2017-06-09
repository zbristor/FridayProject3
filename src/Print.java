import java.util.ArrayList;

public class Print {
	private ArrayList Education;
	private ArrayList Work;
	private ArrayList Person;
public void print(String name, String email, ArrayList e, ArrayList f, ArrayList g)
{
	System.out.println("===========================================================");
	System.out.println(name);
	System.out.println(email);
	System.out.println();
	System.out.println("Education");
	for(int i=0; i<e.size();i++)
	{
		//e.set(e.size()-1, "");
		System.out.println(e.get(i));
	}
	System.out.println();
	System.out.println("Experience");
	for(int j=0; j<f.size(); j++)
	{
		//f.set(f.size()-1, "");
		System.out.println(f.get(j));
	}
	System.out.println();
	System.out.println("Skills");
	for(int k=0; k<g.size(); k++)
	{
		//g.set(g.size()-1, "");
		System.out.println(g.get(k));
	}
}
}
// COde for database below
/*
create schema Resume;
use Resume;

create table Person(
	PersonID int not null auto_increment,
    FirstName varchar(100),
    LastName varchar(100),
    Email varchar(100),
    -- SkillID int,
    primary key(PersonID)
    );
create table PersEdu(
	PersonID int,
    EduID int,
    primary key(PersonID, EduID)
    );
create table Education(
	EduID int not null auto_increment,
    Degree varchar(100),
    School varchar(100),
    Year varchar(100),
    primary key(EduID)
    );
create table PersWork(
	PersonID int,
    WorkID int,
    primary key(PersonID, WorkID)
    );
create table Work(
	WorkID int not null auto_increment,
    Position varchar(100),
    Company varchar(100),
    StartTime varchar(100),
    EndTime varchar(100),
    Duty1 varchar(100) null,
    Duty2 varchar(100) null,
    Duty3 varchar(100) null,
    primary key(WorkID)
    );
create table WorkDuties(
	WorkID int,
    DutyID int,
    primary key(WorkID,DutyID)
    );
create table Duties(
	DutyID int not null auto_increment,
    DutyName varchar(100),
    primary key(DutyID)
    );
create table PersSkill(
	PersonID int,
    SkillID int,
    primary key(PersonID,SkillID)
    );
create table Skills(
	SkillID int not null auto_increment,
    SkillName varchar(100),
    primary key(SkillID)
    );
    
    
insert into Person(FirstName,LastName,Email)values('z','z','z');
insert into Education(Degree,School,Year)values(?,?,?);
insert into Skills(SkillName)values(?);
insert into Work(Position,Company,StartTime,EndTime,Duty1,Duty2)values('z','z','z','z','z','z');
insert into PersWork(PersonID,WorkID)values(2,3);

*/