package com.designPattern.observerDesign;
//Define the Subject Interface (YouTube Channel)
public interface YoutubeChannel {

	void subscribe(Observer observer);
	
	void unsubscribe(Observer observer);
	
	void notifySubscribers(String title);
}
