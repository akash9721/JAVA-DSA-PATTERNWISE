package com.designPattern.observerDesign;

public class ObserverDesignPatternMain {

	public static void main(String[] args) {
		YoutubeCreateor channel = new YoutubeCreateor();
		
		YouTubeUser user1 = new YouTubeUser("akash");
		YouTubeUser user2 = new YouTubeUser("vikash");
		YouTubeUser user3 = new YouTubeUser("ravi");
		
		channel.subscribe(user1);
		channel.subscribe(user2);
		channel.subscribe(user3);
		
		channel.notifySubscribers("microservices");
		
		System.out.println();
		channel.unsubscribe(user1);
		channel.notifySubscribers("design pattern");
		
	}
}

+++++++++++++++++++++++++++++++++output+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
akash received notification: new Video uploaded of microservices
vikash received notification: new Video uploaded of microservices
ravi received notification: new Video uploaded of microservices

vikash received notification: new Video uploaded of design pattern
ravi received notification: new Video uploaded of design pattern
