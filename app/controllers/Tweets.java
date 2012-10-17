package controllers;

import java.util.List;

import models.Tweet;

import org.codehaus.jackson.JsonNode;

import static play.libs.Json.toJson;

import play.mvc.Controller;
import play.mvc.Result;

public class Tweets extends Controller
{

	
	
	
	 public static Result addTweet() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String source = node.get("source").asText();
		 String userId = node.get("userId").asText();
		 String text = node.get("text").asText();
		 Boolean isVisible   = node.get("isVisible").asBoolean();
		 Boolean isPortfolio = node.get("isPortfolio").asBoolean();
		 int xpos = node.get("xpos").asInt();
		 int ypos = node.get("ypos").asInt();
		 
		
		 Tweet tweet = new Tweet(source,userId,text,isVisible, isPortfolio,xpos,ypos);
		 tweet.insert();

		return ok(toJson(tweet));
		
	  }
	 
	 
	 
	 
	 public static Result updateTweet() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
		 String id = node.get("id").asText();
		
		 Tweet tweet = Tweet.find().byId(id);
		 tweet.xpos = node.get("xpos").asInt();
		 tweet.ypos = node.get("ypos").asInt();
		 tweet.isVisible   = node.get("isVisible").asBoolean();
		 tweet.isPortfolio = node.get("isPortfolio").asBoolean();
		 
		 tweet.update();

		return ok(toJson(tweet));
		
	  }
	 
	 
	 
	 public static Result fetchTweetsByGroup(String userId) 
	  {
		 
		 List<Tweet> tweets = Tweet.find().filter("userId", userId).asList();

		return ok(toJson(tweets));
		
	  }
	 
	 


}
