package com.designPattern.observerDesign;

//Concrete Observer
public class YouTubeUser implements Observer{

	private String name;
	
	public YouTubeUser(String name) {
		this.name=name;
	}
	
	@Override
	public void update(String videoTitle) {
		System.out.println(name +" received notification: new Video uploaded of "+videoTitle);
	}

}
