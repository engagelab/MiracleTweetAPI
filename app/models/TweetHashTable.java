/**
 *  TweetHashTable.java
 */
package models;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

import leodagdag.play2morphia.Model;


/**
 * @author Muhammad Fahied
 *
 */


public class TweetHashTable extends Model
{
	
	@Id
	public String id;
	
	public String hashTag;
	
	@Reference()
    public List <Tweet> tweets;
	
	public static Model.Finder<ObjectId, TweetHashTable> find()
	{
		
		return new Model.Finder<ObjectId, TweetHashTable>(ObjectId.class, TweetHashTable.class);
	
	}
	    
	    
	//empty constructor for fetch queries
	public TweetHashTable(){ }
	

}
