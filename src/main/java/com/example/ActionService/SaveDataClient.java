package com.example.ActionService;

import com.example.entities.Ticket;
import com.example.entities.UnresolvedIssue;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.example.entities.Laptop;
import com.example.entities.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SaveDataClient {


	//code to insert resolved isseus
	/*private static void createissues{

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Integer id =(Integer)session.save(getLaptop());
			System.out.println("Laptop is created  with Id::"+id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}*/

		/*public static void main(String[] args) {
			try(Session session = HibernateUtil.getSessionFactory().openSession()) {
				session.beginTransaction();
				Integer id =(Integer)session.save(getStudent());
				//Integer id1=(Integer)session.save(getLaptop());
				//System.out.println("Student is created  with Id::"+id);
					session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}*/





	
	/*private static ResolvedIssues getIssue (){
		Issues issues=new Issues();
		issues.setDescription("CPU is increased");
		issues.setIssuename("CPU");
		issues.setHostname("10.20.200.190");
		issues.setCount(0);
		return issues;
	}*/


	private static UnresolvedIssue getunresolvedIssue (){
		UnresolvedIssue u=new UnresolvedIssue();
		u.setIssuename("CPU");
		u.setHostname("10.20.200.190");
		return u;
	}

   // codee to push unresolved issues
	private static void createunresolvedissues(){

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			UnresolvedIssue u=new UnresolvedIssue();
			u.setIssuename("CPU");
			u.setHostname("10.20.200.190");
			Integer id =(Integer)session.save(u);
			System.out.println("Issue is created  with Id::"+id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}


	}

	//push ticket data to DB
	public static void addTickettoDb(Ticket t) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Integer id = (Integer) session.save(t);
			System.out.println("Tickey is created  with Id::" + id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}




	private static Laptop getLaptop(){

		Laptop l=new Laptop();
		l.setId(101);
		l.setName("Dell");
		return l;

	}

	private static Student getStudent(){
       Student s=new Student();
       s.setRollno(2);
       s.setName("Tinku");
       s.setMarks(100);
		Laptop l=new Laptop();
		l.setId(101);
		l.setName("Dell");

		Laptop l1=new Laptop();
		l1.setId(102);
		l.setName("Mac");


		ArrayList<Laptop> al=new ArrayList<Laptop>();
		al.add(l);
		al.add(l1);



		s.setLaptop(al);
       return s;
	}




}
