/**
 *  Tweet.java
 */


package models;

import java.util.Date;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Id;
import leodagdag.play2morphia.Model;



/**
 * @author Muhammad Fahied
 *
 */



public class Tweet extends Model
{
	
	//adopted from Twitter JSON Schema
	@Id
	public String id;
	public String source;
	public String createdAt;
	public String userId;
	public String text;
	//custom fields
	public Boolean isVisible;
	public Boolean isPortfolio;
	public int xpos;
	public int ypos;
	
	public static Model.Finder<ObjectId, Tweet> find()
	{
		
		return new Model.Finder<ObjectId, Tweet>(ObjectId.class, Tweet.class);
	
	}

	
	//empty constructor for fetch queries
	public Tweet() {}
	
	
	public Tweet(String source, String userId, String text, Boolean isVisible, Boolean isPortfolio, int xpos, int ypos)
	{
		this.source      = source;
		this.createdAt   = new Date().toString();
		this.userId      = userId;
		this.text        = text;
		this.isVisible   = isVisible;
		this.isPortfolio = isPortfolio;
		this.xpos        = xpos;
		this.ypos        = ypos;
		
	}

	
	
	
	

}
