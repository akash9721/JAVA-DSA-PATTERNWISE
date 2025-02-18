package com.designPattern.observerDesign;
//Each subscriber (observer) must implement update() to receive notifications.
interface Observer {

	void update(String title);
}
