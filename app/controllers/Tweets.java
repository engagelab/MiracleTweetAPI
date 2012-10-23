package controllers;

import java.util.List;
import models.Tweet;
import models.TweetHashTable;
import org.codehaus.jackson.JsonNode;
import static play.libs.Json.toJson;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * @author Muhammad Fahied
 *
 */


public class Tweets extends Controller
{

	
	
	
	
	
	 public static Result saveTweet() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String source = node.get("source").asText();
		 String userName = node.get("userName").asText();
		 String text = node.get("text").asText();
		 Boolean isVisible   = node.get("isVisible").asBoolean();
		 Boolean isPortfolio = node.get("isPortfolio").asBoolean();
		 int xpos = node.get("xpos").asInt();
		 int ypos = node.get("ypos").asInt();
		 
		
		 Tweet tweet = new Tweet(source,userName,text,isVisible, isPortfolio,xpos,ypos);
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
	 
	 
	 
	 
	 
	 
	 
	 public static Result fetchTweetsByUser(String userName) 
	  {
		 
		 List<Tweet> tweets = Tweet.find().filter("userName", userName).asList();

		return ok(toJson(tweets));
		
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 public static Result removeTweet() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String hashTag = node.get("hashTag").asText();
		 String tweetId = node.get("tweetId").asText();
		 Tweet tweet = Tweet.find().byId(tweetId);
		 //first remove reference from Tweet Hash table
		 removeTweetFromHashTable(tweet,hashTag);
		 //then Kill the object itself
		 tweet.delete();
		return ok(toJson("deleted"));
		
	  }
	 
	 
	 
	 
	 
	 
	 public static Boolean removeTweetFromHashTable(Tweet tweet, String hashTag)
	 {
		 
		 TweetHashTable table = TweetHashTable.find().filter("hashTag", hashTag).get();
		 if (table == null) {return false;}

		 table.tweets.remove(tweet);
		 table.update();
		 return true;
		 
	 }
	 


}
