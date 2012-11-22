package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.EnergySource;

import org.codehaus.jackson.JsonNode;

import play.mvc.Controller;
import play.mvc.Result;

public class EnergySession extends Controller{
	
	
	
	 
	 public static Result fetchAllEnergySources() 
	  {
		 
		 List<EnergySource> sources = EnergySource.find().all();

		return ok(toJson(sources));
		
	  }
	 
	
	 public static Result saveSession() 
	  {
		 
		 JsonNode node =  ctx().request().body().asJson();
		 String energy = node.get("energy").asText();
		 Boolean inuse   = node.get("inuse").asBoolean();
		 String token = node.get("token").asText();
		 
		 EnergySource source = new EnergySource(energy, inuse, token);
		 source.insert();

		return ok(toJson(source));
		
	  }
	 
	 
	 public static Result updateSession() 
	  {
		
		 JsonNode node =  ctx().request().body().asJson();
		 String id = node.get("id").asText();
		 String token = node.get("token").asText();
		 String stat = node.get("stat").asText();
		 
		 EnergySource source = EnergySource.find().filter("id", id).get();
		 if(source != null) {
		 	if(stat.equals("pick") && !source.inuse)
			 {
				 	source.inuse = true;
			 		source.token = token;
			 		source.update();
					return ok(toJson(source));
			 }
			 else if (stat.equals("reset") && source.inuse) {
					
		 				source.inuse = false;
				 		source.token = "";
				 		source.update();
					return ok(toJson(source));
			}
			else
			{
				return ok(toJson("{\"status\":\"inuse\"}"));
			}
		}
		 else{
		 	return ok(toJson("{\"status\":\"wrongId\"}"));
		 }
		 		
		
		
	  }
	 
	 
	 
	 

}