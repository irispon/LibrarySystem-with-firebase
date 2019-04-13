package com.LivararyAdminSystem.web;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import FireBase.FirebaseManager;
import GUI.MainGUI;
import TEST.Test;



@SpringBootApplication
public class LivararyAdminSystemApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(LivararyAdminSystemApplication.class).headless(false).run(args);
		FirebaseManager.getFirebasObject();
		
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try {
					MainGUI main = new MainGUI();
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}


/*
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("server/saving-data/fireblog");
		DatabaseReference usersRef = ref.child("users");

		Map<String, User> users = new HashMap<>();
		users.put("alanisawesome", new User("334","334"));
		users.put("gracehop", new User("aa","cc"));

		usersRef.setValueAsync(users);


ª¿‘ øπ¡¶¿”.

 */