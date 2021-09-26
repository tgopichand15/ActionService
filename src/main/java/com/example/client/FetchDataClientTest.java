package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/*public class FetchDataClientTest {

	public static void main(String[] args) {
		Issues issues = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	issues = session.get(Issues.class, 1);
	    	System.out.println(issues);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

       public static List<UnresolvedIssues> getunresolveduissues(){
            Query query = session.createQuery("From UnreolsvedIssues");
            List<UnresolvedIssues> l=query.list();
            return l;
	    }

	    //fetch list of tickets
	    public static ArrayList<String> fetchticketDetails(){
	    	Query query=session.createQuery("from Tickets");

	    	ArrayList<Tickets> a=query.list();
	    	ArrayList<String> ticketnumbers=new ArrayList<String>();
	    	foreach(Tickets t:a){
	    		String y=t.getTicketNumber();
	    		ticketnumbers.add(y);
			}

			return ticketnumbers;

		}

	    //fetchticket details with ticketnumber from tickets tables
	    public static Tickets fetchticketdetails(String ticketnumber){
	    	Query query=session.createQuery("from Tickets where id=:id");
	    	query.setParmeter("id",ticketnumber);
	    	return query.uniqueResult();
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
	    
	  }
}*/
