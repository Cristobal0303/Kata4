package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:Starbucks.db");
        List<Starbucks> starbucks = new SQLiteStarbucksLoader(connection).loadAll();

        for (Starbucks starbucks1 : starbucks) {

            System.out.println(starbucks1);

        }

    }

}