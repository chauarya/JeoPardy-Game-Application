package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data


public class Question implements Serializable{
 
	private static final long serialVersionUID = 8962487030131375660L;
	
	 private String catagory;
     private  int value;
     
     private  String question;
     private  String answer1;
     private String answer2;
     private String answer3;
     private String answer4;
     private String ans;
    
    
     
}