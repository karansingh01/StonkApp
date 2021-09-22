package stonk;

import java.io.IOException;

import org.json.simple.JSONArray;

// import javafx.fxml.FXML; uvisst om vi bruker denne 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 
import javafx.scene.Node;



public class StonkController {

    private Stage stage; 
    private Scene scene; 
    private User user;

    public void fromLoginToRegister(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("newUser.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField age;
    @FXML 
    private TextField balance; 

    @FXML
    public void registerUser(ActionEvent event) throws IOException{
        if(username.getText().isBlank() || password.getText().isBlank() || firstname.getText().isBlank() || lastname.getText().isBlank() || age.getText().isBlank()){
            throw new IllegalArgumentException("You must fill out all inputfields");
        }
        else {
            DataHandler dataHandler = new DataHandler();

            try {
                dataHandler.newUser(username.getText(), password.getText(), firstname.getText(), lastname.getText(), Integer.parseInt(age.getText()), 10000, new JSONArray());
                fromRegisterToMain(event);
            }
            catch(IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    private void showBalance(){
        balance.setText(Float.toString(user.getCash());
    }

    @FXML
    public void isLoginValid(ActionEvent event) throws IOException {
        System.out.println();
        DataHandler dataHandler = new DataHandler();
        try {
            System.out.println(username.getText().equals("username"));
            user = dataHandler.isLoginValid(username.getText().toString(), password.getText().toString());
            if(user.equals(null)){
                throw new IllegalArgumentException("Password is incorrect");
            }
            else {
                fromLoginToMain(event);
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        } 
    }


    public void fromLoginToMain(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();


    }

    public void fromRegisterToMain(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField searchbar;
    //Generates a page for each stock
    @FXML
    public void generateStockPage(){
        Stonk stock = new Stonk();
        stock.getStockInfo(searchbar.getText());
        Stage stonkStage = new Stage();
        stonkStage.setTitle(stock.getName());
        
        Label price = new Label("Price : " + stock.getPrice());
        Label ticker = new Label(stock.getTicker().toUpperCase());
        Button buy = new Button("Buy stock");
        
        TextField buyCount = new TextField();
        buyCount.setId("buyCount");
        buyCount.setPromptText("Amount of stocks");
        
        VBox x = new VBox(ticker,price,buyCount,buy);
        stonkStage.setScene(new Scene(x));
        stonkStage.show();
    }
public static void main(String[] args) {
    DataHandler d = new DataHandler();
    d.getAllUsers();
}

}
