package controllers;

import models.Tweet;

import org.codehaus.jackson.JsonNode;

import play.mvc.Controller;
import play.mvc.Result;

public class Tweets extends Controller
{
	
	/*
	 * 	public String source;
	public String createdAt;
	public String userId;
	public String text;
	//custom fields
	public Boolean isVisible;
	public Boolean isPortfolio;
	public int xpos;
	public int ypos;
	 * */
	 public static Result addTweet() 
	  {
		JsonNode node =  ctx().request().body().asJson();
		String source = node.get("source").asText();
		String userId = node.get("userId").asText();
		String text = node.get("text").asText();
		
		Tweet tweet = new Tweet(source,userId,text);
		
		return ok("You have reached MiracleTweetAPI");
		  
	  }
	 
	 
	 

}
