package mape.lab01.dao;

import mape.lab01.entity.bouquet.Accessory;

import java.util.List;
import java.util.Optional;

public class AccessoriesDao extends AbstractDao<Accessory>
        implements CrudDao<Accessory> {
    @Override
    public Optional<Accessory> findById(Integer id) {
        return findById(
                "SELECT id, accessory_name, price FROM accessories WHERE id = ?",
                id,
                extractAccessory());
    }

    @Override
    public List<Accessory> findAll() {
        return findAll(
                "SELECT id, accessory_name, price FROM accessories",
                extractAccessory());
    }

    private ResultSetEntityExtractor<Accessory> extractAccessory() {
        return rs -> {
            final Accessory accessory = new Accessory();
            accessory.setId(rs.getInt(1));
            accessory.setName(rs.getString(2));
            accessory.setPrice(rs.getInt(3));

            return accessory;
        };
    }

    @Override
    public boolean insert(Accessory accessory) {
        return executeUpdate(
                "INSERT INTO accessories(accessory_name, price) VALUES (?, ?)",
                accessory,
                (ps, a) -> {
                    ps.setString(1, a.getName());
                    ps.setInt(1, a.getPrice());
                }
        );
    }

    @Override
    public boolean update(Integer id, Accessory accessory) {
        return executeUpdate(
                "UPDATE accessories SET accessory_name = ?, price = ? WHERE id = ?",
                accessory,
                (ps, a) -> {
                    ps.setString(1, a.getName());
                    ps.setInt(1, a.getPrice());
                    ps.setInt(3, a.getId());
                });
    }

    @Override
    public boolean delete(Accessory accessory) {
        return executeUpdate(
                "DELETE FROM accessories WHERE id = ?",
                accessory,
                (ps, a) -> {
                    ps.setInt(3, a.getId());
                });
    }
}
