/**
 *  Question.java
 */

package models;

import leodagdag.play2morphia.Model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Objects;

/**
 * @author Jeremy Toussaint
 * 
 */

@Entity
public class Question extends Model {

	// adopted from Twitter JSON Schema
	@Id
	public String id = new ObjectId().toString();
	public String ownerName;
	public String text;
	// custom fields
	public String taskId;
	public int xpos;
	public int ypos;

	public static Model.Finder<String, Question> find() {
		return new Model.Finder<String, Question>(String.class, Question.class);
	}

	// empty constructor for fetch queries
	public Question() {
	}

	public Question(String ownerName, String text, String taskId, int xpos,
			int ypos) {
		this.ownerName = ownerName;
		this.text = text;
		this.taskId = taskId;
		this.xpos = xpos;
		this.ypos = ypos;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("ownerName", ownerName).add("text", text)
				.add("taskId", taskId).add("xpos", xpos).add("ypos", ypos)
				.toString();
	}
}
