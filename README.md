MiracleTweetAPI
===============

Restful services to handle Custom tweets

1. Save a new Tweet
HTTP request:  POST http://localhost:9000/tweet
Parameters : None

Request body:

 String source = node.get("source").asText();
  	 String userName = node.get("userName").asText();
		 String text = node.get("text").asText();
		 Boolean isVisible   = node.get("isVisible").asBoolean();
		 Boolean isPortfolio = node.get("isPortfolio").asBoolean();
		 int xpos = node.get("xpos").asInt();
		 int ypos = node.get("ypos").asInt();
     
{
  "source" : "Sciworks",
  "userName" : "Jeremy",
  "isVisible": true,  
  "isPortfolio": false, 
  "xpos": 10, 
  "ypos": 10 
}

Response:
If successful, this method returns a response body with the following structure:
{

}

