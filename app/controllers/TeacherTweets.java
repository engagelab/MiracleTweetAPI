package controllers;

import java.util.List;

import models.TeacherTweet;
import models.Tweet;
import models.TweetHashTable;
import org.codehaus.jackson.JsonNode;

import static play.libs.Json.toJson;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author Jeremy Toussaint
 * 
 */

public class TeacherTweets extends Controller {

	public static Result saveTweet() {

		JsonNode node = ctx().request().body().asJson();

		String taskId = node.get("taskId").asText();
		String ownerName = node.get("ownerName").asText();
		String text = node.get("text").asText();
		Boolean isVisible = node.get("isVisible").asBoolean();
		int xpos = node.get("xpos").asInt();
		int ypos = node.get("ypos").asInt();

		TeacherTweet tTweet = new TeacherTweet(ownerName, taskId, text, isVisible, xpos, ypos);
		tTweet.insert();

		return ok(toJson(tTweet));

	}

	public static Result updateTweet() {

		JsonNode node = ctx().request().body().asJson();
		String id = node.get("id").asText();
		TeacherTweet utTweet = TeacherTweet.find().filter("id", id).get();
		utTweet.xpos = node.get("xpos").asInt();
		utTweet.ypos = node.get("ypos").asInt();
		utTweet.isVisible = node.get("isVisible").asBoolean();
		utTweet.update();
		return ok(toJson(utTweet));

	}

	public static Result fetchTweetsByTaskId(String taskId) {
		List<TeacherTweet> tTweets = TeacherTweet.find().filter("taskId", taskId).asList();
		return ok(toJson(tTweets));
	}
}
