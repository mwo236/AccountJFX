import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class AccountInfo {
	public String name;
	public int age;
	public String email;
	public String dob;
	public String address;
}

public class AccountJFX extends Application {
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Account");

		GridPane grid = new GridPane();
		Scene myScene = new Scene(grid, 400, 400);

		Label instruction = new Label("To create an account,\nplease enter your information\nin the fields below");

		Label lname = new Label("Name");
		TextField fname = new TextField();

		Label lage = new Label("Age");
		TextField fage = new TextField();

		Label lemail = new Label("Email");
		TextField femail = new TextField();

		Label ldob = new Label("Date\nof\nBirth");
		TextField fdob = new TextField();

		Label laddress = new Label("Address");
		TextField faddress = new TextField();


		Button btn = new Button("Create!");

		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				AccountInfo info = new AccountInfo();
				info.name = fname.getText();
				try {
					info.age = Integer.parseInt(fage.getText());
				} catch(Exception e) { //Error occurred 
					System.out.println("An error occurred!");
					return; 
				}
				info.email = femail.getText();
				info.dob = fdob.getText();
				info.address = faddress.getText();

				Scene nextScene = callbackScene(primaryStage, info);
				primaryStage.setScene(nextScene);
			}
		});

		grid.add(instruction, 1, 0);

		grid.add(lname, 0, 1);
		grid.add(fname, 1, 1);

		grid.add(lage, 0, 2);
		grid.add(fage, 1, 2);

		grid.add(lemail, 0, 3);
		grid.add(femail, 1, 3);

		grid.add(ldob, 0, 4);
		grid.add(fdob, 1, 4);

		grid.add(laddress, 0, 5);
		grid.add(faddress, 1, 5);

		grid.add(btn, 0, 6);
		primaryStage.setScene(myScene);

		// Show stage and scene
		primaryStage.show();
	}

	Scene callbackScene(Stage primaryStage, AccountInfo input) {
		GridPane grid = new GridPane();

		Label message = new Label("Thank you! Your account has been created with the following details:\n\tName:\t\t" + input.name + "\n\tAge:\t\t\t" + input.age + "\n\tDate of Birth:\t" + input.dob + "\n\tEmail:\t\t" + input.email + "\n\tAddress:\t\t" + input.address + "");

		grid.add(message, 0, 0);

		Scene scene = new Scene(grid, 400, 400);
		return scene;
	}
}
