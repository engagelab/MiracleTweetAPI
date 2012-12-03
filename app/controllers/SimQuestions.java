package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.SimQuestion;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author Jeremy Toussaint
 * 
 */

public class SimQuestions extends Controller {

	public static Result saveQuestion() {

		JsonNode node = ctx().request().body().asJson();

		String question = node.get("question").asText();
		String answer = node.get("answer").asText();
		String taskId = node.get("taskId").asText();
		String groupId = node.get("groupId").asText();
		int order = node.get("order").asInt();
		
		List<SimQuestion> sQuestions = SimQuestion.find().filter("taskId", taskId).filter("groupId", groupId).order("order").asList();
		
		if(sQuestions.size() < 3) {
			SimQuestion sQuestion = new SimQuestion(question, answer, taskId, groupId, order);
			sQuestion.insert();
			return ok(toJson(sQuestion));
		}
		else {
			ObjectNode rObj = Json.newObject();
			rObj.put("status", "array contains already 3 items");
			return ok(rObj);
		}


	}

	public static Result updateQuestion() {

		JsonNode node = ctx().request().body().asJson();
		String id = node.get("id").asText();
		SimQuestion usQuestion = SimQuestion.find().filter("id", id).get();
		usQuestion.answer = node.get("answer").asText();
		usQuestion.update();
		return ok(toJson(usQuestion));

	}

	public static Result fetchQuestionsByTaskId(String taskId, String groupId) {

		List<SimQuestion> sQuestions = SimQuestion.find().filter("taskId", taskId).filter("groupId", groupId).asList();
		return ok(toJson(sQuestions));

	}
}
