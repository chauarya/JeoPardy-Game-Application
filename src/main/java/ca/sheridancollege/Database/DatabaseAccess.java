package ca.sheridancollege.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
 
 import ca.sheridancollege.beans.Question;
 

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	
	public  Question getQuestion(String catagory,int value) {
		String q = " select question,answer1,answer2,answer3,answer4,correctanswer from question\r\n" + 
				"where category="+catagory+" and valueq="+value+";";
		ArrayList<Question> que = new ArrayList<Question>();
		Question qu=new Question();
		 
		List<Map<String, Object>> rows = jdbc.queryForList(q,
		new HashMap<String,Object>());
		for (Map<String, Object> row : rows) {
		 
		qu.setQuestion((String)(row.get("question")));
		qu.setAnswer1((String)(row.get("answer1")));
		qu.setAnswer2((String)(row.get("answer2")));
		qu.setAnswer3((String)(row.get("answer3")));
		qu.setAnswer4((String)(row.get("answer4")));
		qu.setAns((String)(row.get("correctanswer")));
		qu.setCatagory(catagory);
		qu.setValue(value);
		
		 que.add(qu);
		}
		return que.get(0);
	}
	
 
}