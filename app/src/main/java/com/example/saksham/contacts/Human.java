package com.example.saksham.contacts;

public class Human {
	int imageId;
	String name;
	String contact;

	public Human(String name, int imageId, String contact) {
		this.imageId = imageId;
		this.name = name;
		this.contact = contact;
	}

	public int getImageId() {
		return imageId;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	public String introduce() {
		return "Hey I'm " + name + " You can contact me on " + contact;
	}
}