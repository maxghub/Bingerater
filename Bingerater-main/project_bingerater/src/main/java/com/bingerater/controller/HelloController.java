package com.bingerater.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SplittableRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bingerater.model.Task;

@Controller
public class HelloController {
	
	//Getting spring class jdbcTemplate Object Special way
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/moviereq")
	public String firstreq(HttpServletRequest req,HttpServletResponse res,Task task_ref) throws SQLException, ClassNotFoundException {
		
		String test1 = req.getParameter("mov_var");
//		System.out.println(test1);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =jdbcTemplate.getDataSource().getConnection();
		
		String query1 = "select * from movie_details where mov_name = ?";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setString(1, test1);
		ResultSet rs = ps1.executeQuery();
		
		if(rs.next()) {
			List l = new ArrayList();
			l.add(rs.getInt(1));
			l.add(rs.getString(2));
			l.add(rs.getString(3));
			l.add(rs.getString(4));
			l.add(rs.getString(5));
			l.add(rs.getString(6));
			l.add(rs.getString(7));
			l.add(rs.getString(8));
			
			
			String query2 = "select avg(current_rating) as A,count(*) as B from rating where m_id=?";
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setInt(1, rs.getInt(1));
			ResultSet rs1 = ps2.executeQuery();
			
			if(rs1.next()) {
				l.add(rs1.getDouble("A"));
				l.add(rs1.getInt("B"));
				req.setAttribute("lst", l);
				con.close();
				return "result";
			}
			else {
				req.setAttribute("lst", l);
				con.close();
				return "result";
				
			}
			
		}
		else {
			//increasing database html
			req.setAttribute("out", "Sorry! We are Increasing Our database");
			return "Error_jsp";
		}
	}
	
	@GetMapping("/update_rate")
	public String updateReq(HttpServletRequest req,HttpServletResponse res,Task task_ref) throws SQLException{
		
		String new_rate = req.getParameter("point");
//		System.out.println(new_rate);
		String mov_id = req.getParameter("mov_id_f");
//		System.out.println(mov_id);
		String user_id = req.getParameter("user_id_f");
//		System.out.println(user_id);
		
		Connection con= jdbcTemplate.getDataSource().getConnection();
		String query1 = "update rating set current_rating='"+ new_rate +"' where m_id='"+ mov_id +"' and user_id ='"+user_id+"'";
		PreparedStatement ps1 = con.prepareStatement(query1);
		int i = ps1.executeUpdate();
		if(i>=0) {
			con.close();
			return "Done";
		}
		else {
			req.setAttribute("out", "try again");
			return "Error_jsp";
		}
		
	}
	
	@GetMapping("/first_rate")
	public String firstRateReq(HttpServletRequest req,HttpServletResponse res,Task task_ref) throws SQLException{
		
		String new_rate = req.getParameter("point");
//		System.out.println(new_rate);
		String mov_id = req.getParameter("mov_id_f");
//		System.out.println(mov_id);
		String user_id = req.getParameter("user_id_f");
//		System.out.println(user_id);
		
		Connection con= jdbcTemplate.getDataSource().getConnection();
		String query2 = "insert into rating(m_id,user_id,current_rating) values(?,?,?)";
		PreparedStatement stmt1 = con.prepareStatement(query2);
		stmt1.setString(1,mov_id);
		stmt1.setString(2, user_id);
		stmt1.setString(3, new_rate);
		int row = stmt1.executeUpdate();
		if(row>=0) {
			con.close();
			return "Done";
		}
		else {
			req.setAttribute("out", "try again");
			return "Error_jsp";
		}
	}
	
	
	@GetMapping("/login")
	public String login_req(HttpServletRequest req,HttpServletResponse res) {
		
		String mov_id = req.getParameter("mov_id_c");
//		System.out.println("catch in login "+mov_id);
		req.setAttribute("mov_id_t", mov_id);
		
		return "login1";
	}
	
	@GetMapping("/signUp")
	  public String signUp(HttpServletRequest req) {
		
		String mov_id_c = req.getParameter("mov_id");
//		System.out.println("catch in signUp "+mov_id_c);
		req.setAttribute("mov_id_t", mov_id_c);
	
		return "index1";
	  }
	
	  @PostMapping("/signup")
	  public String signUp1(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		
		String mov_id_c = req.getParameter("mov_id");
//		System.out.println("catch in signup :"+mov_id_c);
		
		String email = req.getParameter("email");
		String psw = req.getParameter("psw");
		
		Connection con= jdbcTemplate.getDataSource().getConnection();
		String query1 = "Select * from signup where email=?";
		PreparedStatement stmt = con.prepareStatement(query1);
		stmt.setString(1,email);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			req.setAttribute("out", "You are already signedup");
			return "Error_jsp";
		} 
		else {
		  String otp= "";
		  otp = generateOtp(6);
		  System.out.println("your otp is " + otp);
		  String query2 = "insert into signup(EMAIL,PSW, otp) values(?,?,?)";
		  PreparedStatement stmt1 = con.prepareStatement(query2);
		  stmt1.setString(1,email);
		  stmt1.setString(2, psw);
		  stmt1.setString(3, otp);
		  int row = stmt1.executeUpdate(); 
		  if (row >=1) {
			  //Important
			sendMail(email, "Your Otp for our Portal is " + otp, "OTP for Verification");
			req.setAttribute("email", email);
		  }
		}
		
		req.setAttribute("mov_id_t", mov_id_c);
		return "SignupSuccess";
	  }
	  
	  private static void sendMail(String emailTo, String body, String subject) {
		  //send mail through this below server
		  	//Making properties object
		    Properties p = new Properties();
			p.put("mail.smtp.host",       "smtp.gmail.com");//openly available
			p.put("mail.smtp.port",       "465");
			p.put("mail.smtp.ssl.enable", "true");
			p.put("mail.smtp.auth",       "true");
			//Enter your email id and password
			MailAuthenticator m = new MailAuthenticator(" write email "," write pass");
			
			Session session = Session.getInstance(p, m);
			session.setDebug(true);
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom("utkarshkumar6740@gmail.com");
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
				msg.setSubject(subject);
				msg.setText(body);
				//send message
				Transport.send(msg);
			} catch (MessagingException e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}
		  }

	  public String generateOtp(int size) {
		StringBuilder sb = new StringBuilder();
		SplittableRandom sp = new SplittableRandom();
	    for (int i =0 ; i<size; i++) {
			 int rn = sp.nextInt(0,9);
			 sb.append(rn);
		 }
		return sb.toString();
	  }
 
	  @PostMapping("/signin")
	  public String signin(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		
		String mov_id_c = req.getParameter("mov_id"); 
//		System.out.println("catch in signin :"+mov_id_c);
		
		String email = req.getParameter("email");
		String psw = req.getParameter("psw");
		
//		System.out.print(email+" "+psw);
	
		Connection con= jdbcTemplate.getDataSource().getConnection();	
		PreparedStatement stmt = con.prepareStatement("Select * from signup where email=?");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();		

		
		if (rs.next()) {
		   if(rs.getInt("is_verify") == 0) {
			   req.setAttribute("out", "You are not verified");
				return "Error_jsp";
		   }
		   if((rs.getString("PSW")).equals(psw)) {	
			   List l_id = new ArrayList();
			   int id = rs.getInt("user_id");
			   l_id.add(id);
			   
			   Statement stmt_1 = con.createStatement();
			   String str_up = "Select current_rating from rating where m_id='"+ mov_id_c +"' and user_id ='"+id+"'";
			   ResultSet rs_new = stmt_1.executeQuery(str_up);	
			   
			   //fetching movie name and images
			   Statement stmt_2 = con.createStatement();
			   String str_up_2 = "Select mov_name,mov_img_path from movie_details where m_id='"+ mov_id_c +"'";
			   ResultSet rs_new_2 = stmt_2.executeQuery(str_up_2);	
	
			   //updating movie
			   if(rs_new.next()) {
				   List l_val = new ArrayList();
				   l_val.add(rs_new.getInt("current_rating"));
				   
				   //User_id and movie_id
				   l_val.add(rs.getInt("user_id"));
				   l_val.add(mov_id_c);
				   if(rs_new_2.next()) {
					   l_val.add(rs_new_2.getString("mov_name"));
					   l_val.add(rs_new_2.getString("mov_img_path"));
				   }
				   
				   req.setAttribute("rate", l_val);
				   return "update_movie";  
			   }
			 //adding movie
			   else {
				   List l_first = new ArrayList();
				   
				   l_first.add(rs.getInt("user_id"));
				   l_first.add(mov_id_c);
				   if(rs_new_2.next()) {
					   l_first.add(rs_new_2.getString("mov_name"));
					   l_first.add(rs_new_2.getString("mov_img_path"));
				   }
				   req.setAttribute("rate", l_first);
				   
				   return "first_time_rate";  
			   } 
			   
		   } 
		   else {
			   req.setAttribute("out", "Your psw is not correct please check");
			   return "Error_jsp";
		   }
		}
		else {
			req.setAttribute("out", "You are NOT signedup");
			return "Error_jsp";
		}
	  }

	@PostMapping("/otpVerification")
	public String otpVerification(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		
		String mov_id_c= req.getParameter("mov_id");
		System.out.println("catch in otpverification :"+mov_id_c);
		
		String email = req.getParameter("email");
		String otp = req.getParameter("otp");
		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_movie","newuser","Admin123@");
		
		Connection con= jdbcTemplate.getDataSource().getConnection();
		Statement stmt = con.createStatement();
		String query1 = "Select otp from signup where email='"+ email + "'";
		ResultSet rs = stmt.executeQuery(query1);
		
		boolean varify_acc_var =false;
		boolean varify_otp_var =false;
		if(rs.next()) {
			if(rs.getString("otp").equals(otp)) {
				Statement stmt1 = con.createStatement();
				String query2 = "update signup set is_verify=1 where email='"+ email + "'";
				stmt1.executeUpdate(query2);
//				req.setAttribute("test", "Your account is verified now");

				varify_acc_var=true;
				varify_otp_var=true;
			} 
			else {
				req.setAttribute("out", "Your otp is not valid");
				return "Error_jsp";
			}
		} 
		else {
			req.setAttribute("out", "Your otp is not generated");
			return "Error_jsp";
			
		}
		
		if(varify_acc_var==true && varify_otp_var==true) {
			req.setAttribute("mov_id_t", mov_id_c);
			return "login1";
		}
		else
			return "Error_jsp";
		}
	 
	
}
