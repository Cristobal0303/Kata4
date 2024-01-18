package software.ulpgc.kata4;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

public interface StarbucksLoader {

    List<Starbucks> loadAll();

}