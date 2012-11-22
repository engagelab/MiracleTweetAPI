package controllers;

import java.util.List;
import models.Question;
import org.codehaus.jackson.JsonNode;

import static play.libs.Json.toJson;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * @author Jeremy Toussaint
 *
 */


public class Questions extends Controller
{

	
	
	
	
	
	 public static Result saveQuestion() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String ownerName = node.get("ownerName").asText();
		 String text = node.get("text").asText();
		 String taskId = node.get("taskId").asText();
		 int xpos = node.get("xpos").asInt();
		 int ypos = node.get("ypos").asInt();
		 
		
		 Question question = new Question(ownerName,text,taskId,xpos,ypos);
		 question.insert();

		return ok(toJson(question));
		
	  }
	 

	 
	 
	 
	 
	 
	 public static Result updateQuestion() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
		 String id = node.get("id").asText();
		 Question uquestion = Question.find().filter("id", id).get();
		 uquestion.xpos = node.get("xpos").asInt();
		 uquestion.ypos = node.get("ypos").asInt();
		 uquestion.update();
		return ok(toJson(uquestion));
		
	  }
	 

	 public static Result fetchQuestionsByTaskId(String taskId) 
	  {
		 
		 List<Question> questions = Question.find().filter("taskId", taskId).asList();

		return ok(toJson(questions));
		
	  }
}
