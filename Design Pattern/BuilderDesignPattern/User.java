package com.designPattern.builderDesign;

 class User {

	// make immutable object
	//required parameters
	private final String userId;
	private final String userName;
	
	// Optional parameters
    private final String email;
    private final String phoneNumber;
    private final int age;
    private final String address;
    
    
    //create private constructor only builder class can called
    private User(UserBuilder builder) {
    	this.userId = builder.userId;
    	this.userName=builder.userName;
    	this.email=builder.email;
    	this.age=builder.age;
    	this.phoneNumber=builder.phoneNumber;
    	this.address=builder.address;
    }
	
	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", age=" + age + ", address=" + address + "]";
	}


	//create inner static class for creating object
	public static class UserBuilder{
		
		//required parameter
		private final String userId;
		private final String userName;
		
		// Optional parameters (initialized to default values)
	    private String email="";
	    private String phoneNumber="";
	    private int age=0;
	    private String address="";
	    
	    //public constructor with required parameter
	    public UserBuilder(String userId,String userName) {
	    	this.userId=userId;
	    	this.userName=userName;
	    }
	    
	   //Methods for setting optional parameters
	   public UserBuilder setEmail(String email) {
		   this.email=email;
		   return this; // Return builder instance
	   }


	   public UserBuilder setPhoneNumber(String phoneNumber) {
		   this.phoneNumber = phoneNumber;
		   return this;
	   }


	   public UserBuilder setAge(int age) {
		   this.age = age;
		   return this;
	   }

	   public UserBuilder setAddress(String address) {
		   this.address = address;
		   return this;
	   }
	   
	   // Build method to return final User object
	   public User build() {
		   return new User(this);
	   }	    
	}
}
