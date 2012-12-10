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
 * @author Jeremy Toussaint
 * 
 */

@Entity
public class TeacherTweet extends Model {

	// adopted from Twitter JSON Schema
	@Id
	public String id = new ObjectId().toString();
	public String ownerName;
	public String text;
	public String createdAt;
	// custom fields
	public Boolean isVisible;
	public int xpos;
	public int ypos;
	public String taskId;

	public static Model.Finder<String, TeacherTweet> find() {
		return new Model.Finder<String, TeacherTweet>(String.class, TeacherTweet.class);
	}

	// empty constructor for fetch queries
	public TeacherTweet() {
	}

	public TeacherTweet(String ownerName, String taskId, String text, Boolean isVisible, int xpos, int ypos) {
		this.createdAt = new Date().toString();
		this.ownerName = ownerName;
		this.taskId = taskId;
		this.text = text;
		this.isVisible = isVisible;
		this.xpos = xpos;
		this.ypos = ypos;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("createdAt", createdAt).add("taskId", taskId)
				.add("ownerName", ownerName).add("text", text).add("isVisible", isVisible).add("xpos", xpos)
				.add("ypos", ypos).toString();
	}
}
