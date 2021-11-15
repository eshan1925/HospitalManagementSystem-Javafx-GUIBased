import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class MainSceneController {

    ObservableList disease = FXCollections.observableArrayList();

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private ChoiceBox<String> choicebox;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    void additems() {
        String d1 = "Fever";
        String d2 = "Cold/Cough";
        String d3 = "Corona";
        String d4 = "Migrain";
        disease.addAll(d1, d2, d3, d4);
        choicebox.getItems().addAll(disease);
    }

    @FXML
    void handleButtonActionb1(ActionEvent event) {
        String a = t1.getText();
        String b = t2.getText();
        String c = choicebox.getValue().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "eshan",
                    "<Yourpassword>");
            Statement s = con.createStatement();
            String s1 = "insert into patient(patientid,patientname,disease) values('" + a + "','" + b + "','" + c
                    + "');";
            System.out.println("Success");
            s.executeUpdate(s1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void handleButtonActionb2(ActionEvent event) {
        System.exit(0);
    }

}
