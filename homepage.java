package airlinereservationsystem;
import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
//package AirlineReservationSystem;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Scanner;

	public class homepage {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("*************************************************************************** ");
	        System.out.println("|                                                                         | ");
	        System.out.println("|                  CHATRAPARI SHIVAJI MAHARAJ                             | ");
	        System.out.println("|                        AIRLINE                                          | ");
	        System.out.println("|                                                                         | ");
	        System.out.println("*************************************************************************** ");
	        System.out.println("");
	        System.out.println("");
	        System.out.println("");
	        System.out.println("                     Enter 1 for login.                                     ");
	        System.out.println("                     Enter 2 for New registration.                          ");
	       
	        int choice = sc.nextInt();
	        switch(choice)
	        {
	        case 1:
	        	
	        login l = new login();
	        l.login1();
	        break;
	        
	        case 2:
	        	
	        registration r = new registration();
			r.registration1();
	        break;
	        
	        default:
	        	System.out.println("Enter valid choice");
	        }
		}

	}


	
	class login {
		public static void login1(){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter login credentials");
			
			
			System.out.println("Enter your username");
      		String username = sc.next();
			
			System.out.println("Enter your password");
			 String password = sc.next();
			try 
			{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Tushar@1231");
				
				Statement st=con.createStatement();
				
				//ResultSet rs=st.executeQuery("select name,password from registration"); 
				String up="select * from registration where name='"+username+"' and password='"+password+"'";// where name="+username+"and password="+password;
				ResultSet rs=st.executeQuery(up);
				if(rs.next()==true) {
				System.out.println("registration successfull.");
				
					System.out.println("enetr in while loop");
					//if(username.equals(rs.getString("name"))& password.equals(rs.getString("password"))) {
					   	
					System.out.println("login auccessfull.");
					System.out.println("");
					System.out.println("");
					
					System.out.println("1.for flight booking.");
					System.out.println("2.for cancellation of flight.");
					System.out.println("3.for previous flight history.");
					int choice = sc.nextInt();
				
				
				 switch (choice) {

				    case 1:{// start
						//ResultSet rs=st.executeQuery("select name,password from registration"); 
						
						booking b=new booking();
						b.booking1();
						break;
						
						}//case 1 close
				    
				   case 2:{//start
					 cancel b = new cancel();
					 b.cancel1();
					 break;
					 }//case 2 close
				   case 3:{
					   System.out.println("enter registration number for flight details:");
					   int rno=sc.nextInt();
					   try 
						{
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Tushar@1231");
							
							Statement st1=con.createStatement();
				 String s="select * from booking where rno="+rno;
				 ResultSet rs1=st1.executeQuery(s);
				 while(rs1.next()) {
					 System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+" "+rs1.getInt(6));
				 }}catch (Exception e) {
					System.out.println(e);
				}
					   
				   }
				   case 4: {
					   return;
				   }
					   
				   default:
				     System.out.println("enter right choice.");	
				
				}
				}
					 
			
			else
			   {
			    System.out.println("enter right login credentials.");
			    //break;
			    }
				
				}
				 
			
			catch (Exception e) {
					
					System.out.println(e);
				}
				
			
			
				
			}//login1 method close
	
		} //login class close
	 
	 
 
	 
	 class registration {//registration class start
	 
	public static void registration1() {//registration method start
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your name : ");
		String name = sc.next();
		
		System.out.println("Enter Your surname : ");
		String surname = sc.next();
		
		System.out.println("Enter Your email : ");
		String email = sc.next();
		
		System.out.println("Enter Your mobile : ");
		Long mobile = sc.nextLong();
		
		System.out.println("Enter Your password : ");
		String password = sc.next();
		
		System.out.println("Enter Your password again to confirm: ");
		String cpassword = sc.next();
		
		if(password.equals(cpassword)) {
			
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Tushar@1231");
			
			Statement st=con.createStatement();
			//st.executeLargeUpdate("insert into registration values("+name+""+surname+""+email+""+mobile+""+password+")");
			
			String q5="insert into registration(name,surname,email,mobile,password) values(?,?,?,?,?)";
			PreparedStatement st5 = con.prepareStatement(q5,Statement.RETURN_GENERATED_KEYS);
		    st5.setString(1, name);
			st5.setString(2, surname);
			st5.setString(3, email);
			st5.setLong(4, mobile);
			st5.setString(5, password);
			
			st5.executeUpdate();
			ResultSet rs=st5.getGeneratedKeys();
			if(rs.next()) {
				System.out.println("your registration number is:"+rs.getInt(1));
			}
			con.close();
			
			//con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			//login.login1();
			
		}
		
	}

	}
 
 
 
	 class booking {
		public static void booking1(){
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter your name : ");
			String name = sc.next();
			
			System.out.println("Enter your surname : ");
			String surname = sc.next();
			
			System.out.println("Enter bfrom : ");
			String from1 = sc.next();
			
			System.out.println("Enter bto : ");
			String to1 = sc.next();
			System.out.println("Enter your registration number:");
			int rno=sc.nextInt();
			 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Tushar@1231");
				
				Statement st=con.createStatement();
				
				//String query=("insert into booking(name,surname,bfrom,bto") values(?,?,?,?);
				String q5="insert into booking(name,surname,from1,to1,rno) values(?,?,?,?,?)";
				   PreparedStatement st5 = con.prepareStatement(q5,Statement.RETURN_GENERATED_KEYS);
				st5.setString(1, name);
				st5.setString(2, surname);
				st5.setString(3, from1);
				st5.setString(4, to1);
				st5.setInt(5, rno);
				st5.executeUpdate();
				System.out.println("inserted");
				ResultSet rs=st5.getGeneratedKeys();
				if(rs.next()) {
					System.out.println("your flight registration number:"+rs.getInt(1));
				}
				con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			
			System.out.println("You have book flight from "+from1 +" to "+to1+ " successful");
		
		}
		
	}
	 class cancel {
	 public static void cancel1() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter your flight reservation number : ");
		 int id = sc.nextInt();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Tushar@1231");
				
				Statement st=con.createStatement();
				String s="delete from booking where frno="+id;
				//PreparedStatement ps=con.prepareStatement(s);
				st.executeUpdate(s);
		 }
		 catch (Exception e) {
		System.out.println(e);		
		 }
		 
	 }
	}
			






