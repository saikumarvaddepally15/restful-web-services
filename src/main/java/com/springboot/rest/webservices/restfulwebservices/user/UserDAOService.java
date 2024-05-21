package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;



@Component
public class UserDAOService {
private static List<User> users = new ArrayList<>();
private static int userCount=0;
static {
	users.add(new User(++userCount,"Sai",LocalDate.now().minusYears(25)));
	users.add(new User(++userCount,"Saketh",LocalDate.now().minusYears(25)));
	users.add(new User(++userCount,"Ginaa",LocalDate.now().minusYears(25)));	
}
public List<User> findAll(){
	return users;
}

public User saveUser(User user) {
	user.setId(++userCount);
	users.add(user);
	return user;
}

public User findOne(int id) {
	Predicate<? super User> predicate = user -> user.getId() == id; 
	return users.stream().filter(predicate).findFirst().get();
}

public void deleteById(int id) {
	Predicate<? super User> predicate = user -> user.getId() == id; 
	users.removeIf(predicate);
}
}
