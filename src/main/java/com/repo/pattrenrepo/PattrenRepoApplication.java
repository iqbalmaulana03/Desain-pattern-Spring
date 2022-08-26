package com.repo.pattrenrepo;

import com.repo.pattrenrepo.model.User;
import com.repo.pattrenrepo.repository.UserRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.SQLException;


public class PattrenRepoApplication {


	public static void main(String[] args) throws SQLException {
//		SpringApplication.run(PattrenRepoApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.repo.pattrenrepo");
		context.refresh();


		UserRepository repository = context.getBean(UserRepository.class);

		// store
		repository.user(new User(1, "Iqbal", "iqbal0", "iqbal@gmail.com", "12345", "Ponorogo"));
		repository.user(new User(2, "Riani", "febri0", "riani@gmail.com", "12345", "Purwokerto"));
		repository.user(new User(3, "Abdul", "khoir1", "abdul@gmail.com", "12345", "Bandung"));

		// retrieve
		User usr = repository.retrieve(1);
		System.out.println(usr);

		// search
		User cfo = repository.search("Iqbal");
		System.out.println(cfo);

		// delete
		User editor = repository.delete(2);
		System.out.println(editor);

		// close the spring context
		context.close();
	}

}
