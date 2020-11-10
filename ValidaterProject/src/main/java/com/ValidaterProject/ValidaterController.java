/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: Controller for the validator
 * ****************************************************************************************************************/
package com.ValidaterProject;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ValidaterProject.Services.ValidaterProjectIntf;
import com.ValidaterProject.beans.User;
import com.ValidaterProject.utill.info;

import io.swagger.annotations.Api;

@Api
@RestController
public class ValidaterController {

	@Autowired
	ValidaterProjectIntf validaterProjectIntf;


	private boolean adminmake = false;

	@PostMapping(value = "/saveUser")
	public ModelAndView saveUser(@ModelAttribute User usr, Model model, HttpServletRequest request) {

		try {
			if (usr != null && usr.getFirstname() != null && usr.getLastname() != null && usr.getAddress() != null
					&& usr.getPassword() != null && usr.getEmail()!=null ) {
				usr.setRole("Client");
				User usercheck = validaterProjectIntf.alreadyregistered(usr.getEmail());
				if (usercheck == null) {
					validaterProjectIntf.SavedUser(usr);
					model.addAttribute("msg",
							"User  " + usr.getFirstname() + " " + usr.getLastname() + " saved Successfully");
					
					sendmail(usr);
					return new ModelAndView("login");
				} else {
					model.addAttribute("msg", "Email " + usr.getEmail() + " already Registered");
					return new ModelAndView("register");
				}
			} else {
				model.addAttribute("msg", "Please fill all the fields");
				return new ModelAndView("register");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return new ModelAndView("login");
	}



	
	
	@PostMapping(value = "/loginSrv")
	public ModelAndView loginSrv(@ModelAttribute User usr, Model model, HttpServletRequest request)  {


		if (adminmake == false) {
			User admin = new User();
			admin.setRole("Admin");
			admin.setFirstname("Yazan");
			admin.setLastname("Siyam");
			admin.setAddress("123 Admin land");
			admin.setEmail("admin@isp.net");
			admin.setPassword("p@ssword1");
			validaterProjectIntf.SavedUser(admin);
			adminmake = true;
		}

		try {

				User usrs = validaterProjectIntf.loginValid(usr);
				
				if (usrs.getFirstname() != null) 
				{
				model.addAttribute("user", usrs);
				return new ModelAndView("dashboard");
					
				} else
                {
					model.addAttribute("msgs","User doesn't exist");
					return new ModelAndView("login");
				}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}

	
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {  
		 HttpSession session = request.getSession(false);
		   if(session!=null)
		   {
			   response.setHeader("Cache-Control","no-store");
			    response.setHeader("Pragma","no-cache");
			    response.setHeader ("Expires", "0"); 
			    session.invalidate();
		    
		   }
		   return new ModelAndView("login");
		  
     }  
	
	
	
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
	//	sendmail();
	   return "Email sent successfully";   
	}
	
	private void sendmail(User user) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(info.email, info.password);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(info.email, false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		   msg.setSubject("Register Confirmation");
		   msg.setContent("Register Confirmation", "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Hi "+user.getFirstname()+" " +user.getLastname()+", you have successfully Registered. For login Click on Https://localhost:2222/login", "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);

		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
	
	
}
