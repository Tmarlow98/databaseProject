package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.sql.*;

public class Controller {

    @FXML
    private Label lblfirst;

    @FXML
    private Label lblLast;

    @FXML

    public void connect(javafx.event.ActionEvent actionEvent) {
        final String DATABASE_URL = "jdbc:derby:lib\\lib\\books";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM AUTHORS";

        // use try-with-resources to connect to and query the database
        try (
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL, "deitel", "deitel");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            if (resultSet.next()) {
                lblfirst.setText(resultSet.getString(1));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}


