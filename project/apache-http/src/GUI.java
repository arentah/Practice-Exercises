import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends Application {

    private ArrayList<Client> clientArrayList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {

        BorderPane outerBorderPane = new BorderPane();
        outerBorderPane.setPadding(new Insets(10, 10, 10, 10));

        BorderPane innerBorderPane = new BorderPane();
        innerBorderPane.setPadding(new Insets(20, 10, 10, 10));

        TextArea outputTextArea = new TextArea();
        BorderPane.setMargin(outputTextArea, new Insets(10, 10, 10, 10));
        outputTextArea.setPadding(new Insets(2, 2, 2, 2));
        BorderPane.setAlignment(outputTextArea, Pos.CENTER);
        innerBorderPane.setCenter(outputTextArea);

        Label promptLabel = new Label("Please enter a zip code...");
        promptLabel.setFont(new Font("Times New Roman", 18));
        BorderPane.setAlignment(promptLabel, Pos.TOP_LEFT);
        outerBorderPane.setCenter(innerBorderPane);

        Text title = new Text();
        title.setText("Authorized IRS e-file Providers");
        title.setFont(new Font("Times New Roman", 30));
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        outerBorderPane.setTop(title);

        TextField inputTextField = new TextField();
        inputTextField.setPromptText("Enter 5 digit zip code");
        Button submitButton = new Button("Submit");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(inputTextField, submitButton);
        hBox.setSpacing(5.0);

        ToggleGroup sortToggleGroup = new ToggleGroup();
        RadioButton sortLastName = new RadioButton("Sort by last name");
        sortLastName.setToggleGroup(sortToggleGroup);
        sortLastName.setUserData("sortedLastName");
        RadioButton sortPhoneNumber = new RadioButton("Sort by phone number");
        sortPhoneNumber.setToggleGroup(sortToggleGroup);
        sortPhoneNumber.setUserData("sortedPhoneNumber");
        Label outputPrompt = new Label("Please choose output");
        outputPrompt.setFont(new Font("Times New Roman", 18));

        ToggleGroup outputToggleGroup = new ToggleGroup();
        RadioButton block = new RadioButton("block");
        block.setToggleGroup(outputToggleGroup);
        block.setUserData("block");
        RadioButton CSV = new RadioButton("CSV");
        CSV.setToggleGroup(outputToggleGroup);
        CSV.setUserData("CSV");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 0, 0, 0));
        vBox.setSpacing(5);
        vBox.getChildren().addAll(outputPrompt, block, CSV, promptLabel, hBox, sortLastName, sortPhoneNumber);
        innerBorderPane.setLeft(vBox);

        sortLastName.setOnAction(event -> {
            outputTextArea.clear();
            outputTextArea.setText("Please enter zip code or press submit...");
        });

        sortPhoneNumber.setOnAction(event -> {
            outputTextArea.clear();
            outputTextArea.setText("Please enter zip code or press submit...");
        });

        submitButton.setOnAction(event -> {
            String zip_code;
            if (outputToggleGroup.getSelectedToggle() != null) {
                outputTextArea.clear();
                zip_code = inputTextField.getText();
                clientArrayList.clear();
                if (zip_code.length() != 5)
                    outputTextArea.setText("Invalid zip code");
                else {
                    HttpClientIRS httpClientIRS = new HttpClientIRS();
                    httpClientIRS.get(Integer.parseInt(zip_code));
                    clientArrayList = httpClientIRS.getClientArrayList();
                    if (clientArrayList.size() == 0)
                        outputTextArea.setText("There does not seem to be any authorized " +
                                "e-file providers at zip code: " + inputTextField.getText() + "...");
                    else
                        outputTextArea.setText(printClientArrayList(outputToggleGroup.getSelectedToggle().getUserData().toString(),
                                sortToggleGroup.getSelectedToggle()));
                }
            } else {
                outputTextArea.clear();
                outputTextArea.setText("Please select an output format...");
            }
        });

        Scene scene = new Scene(outerBorderPane, 800, 450);
        primaryStage.setTitle("Authorized IRS e-file Providers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sortPhoneNumber() {
        for (int i = 0; i < clientArrayList.size() - 1; i++) {
            String num1 = clientArrayList.get(i).getPhone_number();
            for (int j = i + 1; j < clientArrayList.size(); j++) {
                String num2 = clientArrayList.get(j).getPhone_number();
                int compare = num1.compareTo(num2);
                if (compare > 0) {
                    Collections.swap(clientArrayList, i, j);
                    num1 = clientArrayList.get(i).getPhone_number();
                }
            }
        }
    }

    private void sortLastName() {
        for (int i = 0; i < clientArrayList.size() - 1; i++) {
            char[] charArray = new StringBuilder(clientArrayList.get(i).getName()).reverse().toString().toCharArray();
            String lastName = getLastName(charArray);
            for (int j = i + 1; j < clientArrayList.size(); j++) {
                if (i == j)
                    continue;
                char[] charArray2 = new StringBuilder(clientArrayList.get(j).getName()).reverse().toString().toCharArray();
                String lastName2 = getLastName(charArray2);
                int compare = lastName.compareTo(lastName2);
                if (compare > 0) {
                    Collections.swap(clientArrayList, i, j);
                    lastName = getLastName(new StringBuilder(clientArrayList.get(i).getName()).reverse().toString().toCharArray());
                }
            }
        }
    }

    private String getLastName(char[] nameArray) {
        StringBuilder lastName = new StringBuilder();
        for (int j = 0; j < nameArray.length; j++) {
            if (nameArray[j] >= 65 && nameArray[j] <= 90)
                lastName.append(nameArray[j]);
            else break;
        }
        return lastName.reverse().toString();
    }

    private String printClientArrayList(String outputFlag, Toggle sortFlag) {
        StringBuilder sb = new StringBuilder();
        if (sortFlag == null) {
            if (outputFlag.equals("block"))
                sb = printStandardHelper(sb, "block");
            else if (outputFlag.equals("CSV"))
                sb = printStandardHelper(sb, "CSV");
        } else {
            String flag = sortFlag.getUserData().toString();
            if (flag.equals("sortedLastName")) {
                if (outputFlag.equals("block")) {
                    sortLastName();
                    sb = printSortedLastNameHelper(sb, "block");
                } else if (outputFlag.equals("CSV")) {
                    sortLastName();
                    sb = printSortedLastNameHelper(sb, "CSV");
                }
            } else if (flag.equals("sortedPhoneNumber")) {
                if (outputFlag.equals("block")) {
                    sortPhoneNumber();
                    sb = printSortedPhoneNumberHelper(sb, "block");
                } else if (outputFlag.equals("CSV")) {
                    sortPhoneNumber();
                    sb = printSortedPhoneNumberHelper(sb, "CSV");
                }
            }
        }
        return sb.toString();
    }

    private StringBuilder printStandardHelper(StringBuilder sb, String type){
        String spacing = type.equals("block") ? "\n" : ", ";
        for(Client client : clientArrayList){
            sb.append(client.getBusiness()).append(spacing);
            sb.append(client.getAddress()).append(spacing);
            sb.append(client.getName()).append(spacing);
            sb.append(client.getPhone_number()).append(spacing);
            sb.append(client.getType()).append("\n\n");
        }
        return sb;
    }

    private StringBuilder printSortedLastNameHelper(StringBuilder sb, String type){
        String spacing = type.equals("block") ? "\n" : ", ";
        for(Client client : clientArrayList){
            sb.append(client.getName()).append(spacing);
            sb.append(client.getAddress()).append(spacing);
            sb.append(client.getBusiness()).append(spacing);
            sb.append(client.getPhone_number()).append(spacing);
            sb.append(client.getType()).append("\n\n");
        }
        return sb;
    }

    private StringBuilder printSortedPhoneNumberHelper(StringBuilder sb, String type){
        String spacing = type.equals("block") ? "\n" : ", ";
        for(Client client : clientArrayList){
            sb.append(client.getPhone_number()).append(spacing);
            sb.append(client.getBusiness()).append(spacing);
            sb.append(client.getAddress()).append(spacing);
            sb.append(client.getName()).append(spacing);
            sb.append(client.getType()).append("\n\n");
        }
        return sb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
