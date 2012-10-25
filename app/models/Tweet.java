/**
 *  Tweet.java
 */


package models;

import java.util.Date;

import org.bson.types.ObjectId;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Objects;

import leodagdag.play2morphia.Model;



/**
 * @author Muhammad Fahied
 *
 */


@Entity
public class Tweet extends Model
{
	
	//adopted from Twitter JSON Schema
	@Id
	public String id = new ObjectId().toString();
	public String source;
	public String createdAt;
	public String userName;
	public String ownerName;
	public String text;
	//custom fields
	public Boolean isVisible;
	public int xpos;
	public int ypos;
	
	public static Model.Finder<String, Tweet> find()
	{
		
		return new Model.Finder<String, Tweet>(String.class, Tweet.class);
	
	}

	
	//empty constructor for fetch queries
	public Tweet() {}
	
	
	public Tweet(String source, String userName, String ownerName, String text, Boolean isVisible, int xpos, int ypos)
	{
		this.source      = source;
		this.createdAt   = new Date().toString();
		this.userName    = userName;
		this.ownerName   = ownerName;
		this.text        = text;
		this.isVisible   = isVisible;
		this.xpos        = xpos;
		this.ypos        = ypos;
		
	}

	
	
	
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        		.add("id", id)
                .add("source", source)
                .add("createdAt", createdAt)
                .add("userName", userName)
                .add("ownerName", ownerName)
                .add("text", text)
                .add("isVisible", isVisible)
                .add("xpos", xpos)
                .add("ypos", ypos)
                .toString();
    }
	

}
