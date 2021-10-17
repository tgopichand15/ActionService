package com.example.client;

import com.example.entities.Ticket;
import com.example.entities.UnresolvedIssue;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class FetchDataClient {

	/*public static void main(String[] args) {
		Issues issues = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	issues = session.get(Issues.class, 1);
	    	System.out.println(issues);
		} catch (HibernateException e) {
			e.printStackTrace();
		}*/

       public static List<UnresolvedIssue> getunresolveduissues(){
		   try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			   Query query = session.createQuery("From UnreolsvedIssue");
			   List<UnresolvedIssue> l = ((org.hibernate.query.Query) query).list();
			   return l;
		   }
		   catch (HibernateException e) {
			   e.printStackTrace();
		   }
		   return null;

	    }

	    //fetch list of tickets
	    public static List<String> fetchticketDetails(){
			try(Session session = HibernateUtil.getSessionFactory().openSession()) {

				Query query = session.createQuery("from Ticket");

				List<Ticket> a = ((org.hibernate.query.Query) query).list();
				List<String> ticketnumbers = new ArrayList<>();
				for (Ticket t : a) {
					String y = t.getTicketnumber();
					ticketnumbers.add(y);
				}

				return ticketnumbers;

			}catch (HibernateException e) {
				e.printStackTrace();
			}
			return null;

		}

	    //fetchticket details with ticketnumber from tickets tables
	    public static Ticket fetchticketdetails(String ticketnumber){
			try(Session session = HibernateUtil.getSessionFactory().openSession()) {

				Query query = session.createQuery("from Ticket where id=:id");
				query.setParameter("id", ticketnumber);
				return (Ticket)((org.hibernate.query.Query) query).uniqueResult();
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}


        return null;
		}






        /*private static void fetchUpdateIssueByHostname(Session session){
			Employee e=session.get(Employee.class,1);

			if(e==null){
				System.out.println("employed with provided id does not exist");
			}
			else{
				e.setSalary(50000);
				session.beginTransaction();

				session.update(e);

				session.getTransaction().commit();
				System.out.println(e);
			}
		}
	    
	  }*/
}
