package ca.sheridancollege.Controller;

 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.Database.DatabaseAccess;
 
import ca.sheridancollege.beans.Player;
import ca.sheridancollege.beans.Question;

@Controller
public class HomeController {
	
	@Autowired
	private DatabaseAccess da;
	
	
@GetMapping("/p1")
public String loadPage1() {
		return "Page1.html";
	}

@GetMapping("/login")
public String loginMethod(HttpSession session,@RequestParam String name) {
	 
Player p=new Player();
p.setName(name);
p.setScore(0);
session.setAttribute("Player",p);
return"Page2.html";
}

@GetMapping("/pq")
public String loadQuestion(@RequestParam String catagory,
		                   @RequestParam int value,
		                   HttpSession session){
	 
	Question ques=da.getQuestion(catagory,value);
	
	 session.setAttribute("Qe",ques);
	  
	return"Page3.html";
}


@GetMapping("/answerQuestion")
public String valuateQuestion(
		                   @RequestParam String select,
		                   HttpSession session){
	Player p=(Player) session.getAttribute("Player");
	  Question Q= (Question) session.getAttribute("Qe");
	
	  if(Q.getAns().equals(select)) {
			 p.setScore(p.getScore()+Q.getValue());
		}
		else {
			 p.setScore(p.getScore()-Q.getValue());

		}
		
	  session.setAttribute("Player",p);
	  session.setAttribute("Qe",Q);
	  
	return"Page2.html";
}

@GetMapping("/GGB")
public String goGameBord() {
	
	return "Page2.html";
}

@GetMapping("/logOut")
public String goLogOut() {
	
	return "Page1.html";
}


}