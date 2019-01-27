package com.springMVC.hibernateAssignment;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.accolite.model.Address;
import com.accolite.model.ContractEmployee;
import com.accolite.model.Employee;
import com.accolite.model.Like;
import com.accolite.model.PermanentEmployee;
import com.accolite.model.Person;
import com.accolite.model.Post;
import com.accolite.model.PostDetails;
import com.accolite.utils.Initializer;

public class App 
{	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = Initializer.getSessionFactory();
		Session session = sessionFactory.openSession();
		Person person = new Person();
		Set<Address> addresses = new HashSet<Address>();
		Address resaddress = new Address();
		resaddress.setStreet("Mangayamma Rao peta");
		resaddress.setCity("Pithapuram");
		person.setName("Sai");
		Address busaddress = new Address();
		busaddress.setStreet("Gachibowli");
		busaddress.setCity("Hyderabad");
		addresses.add(resaddress);
		addresses.add(busaddress);
		person.setAddresses(addresses);
		
		Post post = new Post();
		post.setTitle("I love python");
		PostDetails pd = new PostDetails();
		pd.setCreatedBy("Sai");
		pd.setCreatedOn(new Date());
		pd.setPost(post);
		Like like1 = new Like();
		like1.setLikedby("Naveen");
		like1.setLikedtime(new Date());
		Like like2 = new Like();
		like2.setLikedby("Kiran");
		like2.setLikedtime(new Date());
		post.getLikes().add(like1);
		post.getLikes().add(like2);
		
		PermanentEmployee pe = new PermanentEmployee();
        pe.setEmpId(243);
        pe.setName("Sai");
        pe.setDesignation("Software Engineer");
        pe.setDepartment("Full Stack Developer");
		
        ContractEmployee ce = new ContractEmployee();
        ce.setEmpId(124);
        ce.setName("Vinay");
        ce.setWorkingDays(28);
        ce.setContractorName("Sai");
        
//		person.setResidentaddress(resaddress);
//		person.setBusinessaddress(busaddress);
//		session.save(address);
		session.beginTransaction();
		
		session.save(person); //saving an object , Transactional state
		session.persist(post);
		session.save(pe);//create
		session.save(ce);
		session.save(pd);
		session.getTransaction().commit();
		
		String hql = "FROM Employee WHERE name = 'Sai'";
		List<Employee> employeeList = session.createQuery(hql).list();//HQL
		System.out.println(Arrays.asList(employeeList));
		
		hql = "from Employee where name = :name";
		System.out.println(Arrays.asList(session.createQuery(hql).setString("name", "Sai").list()));
		
		Query q1 = session.getNamedQuery("getid");
		q1.setInteger("id",1);
		List<Person> list1 = q1.list();
		System.out.println(Arrays.asList(list1));
		
		Query query = session.createQuery("From Person");
		query.setFirstResult(0);
		query.setMaxResults(3);
		List<Person> personList = query.list();
		employeeList = session.createQuery("FROM Employee").list();//read,select
		for(Employee e:employeeList)
			System.out.println(e);
		session.delete(post);//delete
//		Person updateperson = session.get(Person.class, 1);
//		updateperson.setName("Sai Chavali");//update , Persistent state
//		Query queryObj = session.createQuery("DELETE FROM Person");//delete all,query obj
//		queryObj.executeUpdate();
		Criteria cr = session.createCriteria(Employee.class); //criteria api
		cr.add(Restrictions.ilike("designation", "software%")); //restrictions
		List<Employee> results = cr.list();
		System.out.println(Arrays.asList(results));
		
		System.out.println(session.get(Person.class, 1));//retrieving objects from session
		System.out.println(session.get(PostDetails.class, new Long(1)));
		cr = session.createCriteria(Like.class);
		System.out.println(cr.setProjection(Projections.max("likedtime")).uniqueResult());
		session.close();//detached state
    }
}
