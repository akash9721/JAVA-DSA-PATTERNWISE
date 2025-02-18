package com.designPattern.observerDesign;

import java.util.ArrayList;
import java.util.List;
//// Concrete subject
public class YoutubeCreateor implements YoutubeChannel{

	List<Observer> subscribers=new ArrayList<>();
	
	@Override
	public void subscribe(Observer observer) {
		subscribers.add(observer);
	}

	@Override
	public void unsubscribe(Observer observer) {
		subscribers.remove(observer);
	}

	@Override
	public void notifySubscribers(String videoTitle) {
		for(Observer observer:subscribers) {
			observer.update(videoTitle);
		}
	}

}
