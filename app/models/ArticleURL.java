package models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Objects;

import leodagdag.play2morphia.Model;

@Entity
public class ArticleURL extends Model {

	@Id
	public String id = new ObjectId().toString();
	public String articleUrl;
	public String groupId;

	public static Model.Finder<String, ArticleURL> find() {

		return new Model.Finder<String, ArticleURL>(String.class,
				ArticleURL.class);

	}

	public ArticleURL() {
		// TODO Auto-generated constructor stub
	}

	public ArticleURL(String articleUrl, String groupId) {

		this.articleUrl = articleUrl;
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("articleUrl", articleUrl).add("groupId", groupId)
				.toString();
	}

}
