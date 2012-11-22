package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.ArticleURL;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ArticleURLs extends Controller {

	public static Result fetchArticleURLByGroupId(String groupId) {

		List<ArticleURL> articleUrls = ArticleURL.find()
				.filter("groupId", groupId).asList();

		return ok(toJson(articleUrls));

	}

	public static Result saveArticleUrl() {

		JsonNode node = ctx().request().body().asJson();
		String groupId = node.get("groupId").asText();
		String articleUrl = node.get("articleUrl").asText();

		ArticleURL articleURL = new ArticleURL(articleUrl, groupId);
		articleURL.insert();

		return ok(toJson(articleURL));

	}

	public static Result updateArticleUrl() {

		JsonNode node = ctx().request().body().asJson();
		String groupId = node.get("groupId").asText();
		String articleUrl = node.get("articleUrl").asText();

		ArticleURL articleURL = ArticleURL.find().filter("groupId", groupId).get();
		if (articleURL != null) {
			articleURL.articleUrl = articleUrl;
			articleURL.update();
			return ok(toJson(articleURL));
		} else {
			ObjectNode rObj = Json.newObject();
			rObj.put("status", "wrongId");
			return ok(rObj);
		}

	}

}
