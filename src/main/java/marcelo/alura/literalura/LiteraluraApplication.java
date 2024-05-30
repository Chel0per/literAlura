package marcelo.alura.literalura;

import marcelo.alura.literalura.services.ApiGutendex;
import marcelo.alura.literalura.services.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication  implements CommandLineRunner {

	@Autowired
	private ApiGutendex api;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserInput input = new UserInput();;

		input.greetUser();
		int userChoice = 0;

		while (userChoice != 5){
			userChoice = input.getUserChoice();
			switch (userChoice) {
				case 1:
					api.chooseBookWithFilter();
					break;
				case 2:
					api.listBooks();
					break;
				case 3:
					api.listBooksByAuthor();
					break;
				case 4:
					api.listBooksByLanguage();
					break;
				default:
					userChoice = 5;
					break;
			}
		}


	}

}
