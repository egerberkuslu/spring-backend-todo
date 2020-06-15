package com.example.kafe.message.response;

public class JwtResponseWithName {
	   private String token;
	   private String type = "Bearer";
	   private String username = ""; 
	 
	    public JwtResponseWithName(String accessToken,String username) {
	        this.token = accessToken;
	        this.username = username;
	    }
	 
	    public String getAccessToken() {
	        return token;
	    }
	 
	    public void setAccessToken(String accessToken) {
	        this.token = accessToken;
	    }
	 
	    public String getTokenType() {
	        return type;
	    }
	 
	    public void setTokenType(String tokenType) {
	        this.type = tokenType;
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

	
	    
}
