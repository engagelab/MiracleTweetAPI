/**
 *  SimQuestion.java
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
public class SimQuestion extends Model {

	@Id
	public String id = new ObjectId().toString();
	public String question;
	public String answer;
	public String taskId;
	public String groupId;
	
	public static Model.Finder<String, SimQuestion> find() {
		return new Model.Finder<String, SimQuestion>(String.class, SimQuestion.class);
	}

	// empty constructor for fetch queries
	public SimQuestion() {
	}

	public SimQuestion(String question, String answer, String taskId, String groupId) {
		this.question = question;
		this.answer = answer;
		this.taskId = taskId;
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("question", question).add("answer", answer)
				.add("taskId", taskId).add("groupId", groupId).toString();
	}
}
