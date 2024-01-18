package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLiteStarbucksLoader implements StarbucksLoader {

    private final Connection connection;
    private static final String queryAll = "select * from Starbucks where Beverage_category  = \"Smoothies\"";

    public SQLiteStarbucksLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Starbucks> loadAll() {

        try {

            return load(queryAll());

        } catch (SQLException e) {

            return Collections.emptyList();

        }
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(queryAll);
    }

    private List<Starbucks> load(ResultSet resultSet) throws SQLException {

        List<Starbucks> list = new ArrayList<>();

        while (resultSet.next()) {

            list.add(starbucksFrom(resultSet));

        }

        return list;

    }

    private Starbucks starbucksFrom(ResultSet resultSet) throws SQLException {

        return new Starbucks(
                resultSet.getString("BEVERAGE_CATEGORY"),
                resultSet.getString("BEVERAGE"),
                resultSet.getString("BEVERAGE_PREP"),
                resultSet.getString("CALORIES"));

    }

}