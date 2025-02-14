package com.designPattern.builderDesign;

public class BuilderPatternMain {

	public static void main(String[] args) {
		// Creating a User with required fields only
		User user1 = new User.UserBuilder("1", "akash kumar").build();
		System.out.println(user1);
		
		// Creating a User with some optional fields
        User user2 = new User.UserBuilder("102", "Smith")
                        .setEmail("smith@gmail.com")
                        .setPhoneNumber("9876543210")
                        .build();
        System.out.println(user2);
        
		// Creating a User with all optional fields
		User user3 = new User.UserBuilder("3", "sandeep")
				.setEmail("sandeep@gmail.com")
				.setAge(40)
				.setPhoneNumber("32453567644")
				.setAddress("bharthapur")
				.build();
		System.out.println(user3);
	}
}
