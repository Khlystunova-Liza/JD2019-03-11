package by.it.khlystunova.project.java.dao;

import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CoffemachineDao extends AbstractDao<Coffemachine> {
    @Override
    public boolean create(Coffemachine coffemachine) throws SQLException {
        String sql;
        sql = String.format(Locale.ENGLISH,
                "INSERT INTO `coffemachines`( `Name`, `Firm`, `Power`, `Size`, `Weight`," +
                        " `WaterContainer`, `BeansContainer`, `Color`, `Price`)" +
                        " VALUES ('%s','%s','%s','%s',%f,"
                        + "'%s','%s','%s',%f)",
                coffemachine.getName(), coffemachine.getFirm(),
                coffemachine.getPower(), coffemachine.getSize(),
                coffemachine.getWeight(),
                coffemachine.getWaterContainer(),
                coffemachine.getBeansContainer(),coffemachine.getColor(),
                coffemachine.getPrice()
        );
        long id = executeCreate(sql);
        if (id > 0)
            coffemachine.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Coffemachine coffemachine) throws SQLException {
        String sql;
        sql = String.format(Locale.ENGLISH,
                "UPDATE `coffemachines` SET `Name`='%s'," +
                        "`Firm`='%s',`Power`='%s',`Size`='%s'," +
                        "`Weight`='%f',`WaterContainer`='%s'," +
                        "`BeansContainer`='%s'," +
                        "`Color`='%s',`Price`='%f' WHERE 1",
                coffemachine.getName(), coffemachine.getFirm(),
                coffemachine.getPower(), coffemachine.getSize(), coffemachine.getWeight(),
                coffemachine.getWaterContainer(),
                coffemachine.getBeansContainer(),coffemachine.getColor(),
                coffemachine.getPrice()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Coffemachine coffemachine) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `coffemachines` WHERE `id`=%d",
                coffemachine.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Coffemachine> getAll(String where) throws SQLException {
        List<Coffemachine> coffemachines = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `coffemachines` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Coffemachine coffemachine = new Coffemachine(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("firm"),
                        resultSet.getString("power"),
                        resultSet.getString("size"),
                        resultSet.getDouble("weight"),
                        resultSet.getString("waterContainer"),
                        resultSet.getString("beansContainer"),
                        resultSet.getString("color"),
                        resultSet.getDouble("price")
                );
                coffemachines.add(coffemachine);
            }
            }
        return coffemachines;
    }

    @Override
    public List<Coffemachine> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Coffemachine read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Coffemachine> coffemachines = getAll(where);
        if (coffemachines.size() == 1)
            return coffemachines.get(0);
        else
            return null;
    }
}
