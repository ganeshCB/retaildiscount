package com.ganesh.shoping.model;

import java.time.LocalDateTime;

public class UserDetails{

private final UserType type;
private final String userName;
private String contactNumber;
private final LocalDateTime joiningDate;


public UserDetails(UserType type, String userName) {
    this.type = type;
    this.userName = userName;
    joiningDate = LocalDateTime.now();
}

public UserDetails(UserType type, String userName, LocalDateTime joiningDate, String contactNumber) {
    this.type = type;
    this.userName = userName;
    this.joiningDate = joiningDate;
    this.contactNumber=contactNumber;
}

public UserType getType() {
	return type;
}

public String getUserName() {
	return userName;
}

public LocalDateTime getJoiningDate() {
	return joiningDate;
}
public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}


}
