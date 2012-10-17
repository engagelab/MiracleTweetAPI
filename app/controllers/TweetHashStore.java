/**
 * TweetHashStore
 */
package controllers;

import static play.libs.Json.toJson;

import models.Tweet;
import models.TweetHashTable;
import org.codehaus.jackson.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;




/**
 * @author Muhammad Fahied
 * @version 1.0
 */




public class TweetHashStore extends Controller
{
	
	
	
	
	
	
	 public static Result addTweetToHashTable() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String hashTag = node.get("hashTag").asText();
		 String tweetId = node.get("tweetId").asText();
		 
		 TweetHashTable table = TweetHashTable.find().filter("hashTag", hashTag).get();
		 if (table == null) {
			 table = new TweetHashTable(hashTag);
		}

		 Tweet tweet = Tweet.find().byId(tweetId);
		 table.tweets.add(tweet);
		return ok(toJson("OK"));
		
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public static Result findTweetsByHashTag() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
	
		 String hashTag = node.get("hashTag").asText();
		 
		 
		 TweetHashTable table = TweetHashTable.find().filter("hashTag", hashTag).get();
		 if (table == null) {
			 table = new TweetHashTable(hashTag);
		}

		return ok(toJson(table.tweets));
		
	  }
	 

	 
	 

}
