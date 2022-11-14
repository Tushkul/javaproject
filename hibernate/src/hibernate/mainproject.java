package hibernate;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.*;
	public class mainproject {

		public static void main(String[] args) 
		{
			SessionFactory sfactory=new Configuration().configure().buildSessionFactory();
			Session sess=sfactory.openSession();
			Transaction tx=null;
			
//			for(int i=0;i<10;i++)
//			{
				tx=sess.beginTransaction();
				student stu=new student();
			sess.persist(stu);
//			if(stu.getId()==7)
//			{
//				stu.setName("Vishal");
//				stu.setAge(45);
//			}
//			System.out.println(stu.getId()+"    "+stu.getName()+"       "+stu.getAge()                  );
       sess.delete("1");
			sess.flush();
			tx.commit();
//			}
			sess.close();
		}

	}


