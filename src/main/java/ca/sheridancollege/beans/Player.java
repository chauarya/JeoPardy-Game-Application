package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data


public class Player implements Serializable{
 
	private static final long serialVersionUID = 8962487030131375660L;
	
	
	private String name;
     private int score;
     private String catagory;
     private  int value;
    
     
     
}