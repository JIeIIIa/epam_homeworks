package mape.lab01.dao;

import mape.lab01.entity.flower.AbstractFlower;
import mape.lab01.entity.flower.Chamomile;
import mape.lab01.entity.flower.Lily;
import mape.lab01.entity.flower.Rose;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlowerDao extends AbstractDao<AbstractFlower> implements CrudDao<AbstractFlower> {
    @Override
    public Optional<AbstractFlower> findById(Integer id) {
        return findById(
                "SELECT flower_type, flower_length, freshnesslevel, " +
                        "  price, lily_size, " +
                        "  chamomile_petals, rose_thorns, id" +
                        "FROM flower " +
                        "WHERE id = ?",
                id,
                extractFlower()
        );
    }

    @Override
    public List<AbstractFlower> findAll() {
        return findAll(
                "SELECT flower_type, flower_length, freshnesslevel, " +
                        "price, lily_size, " +
                        "chamomile_petals, rose_thorns, id" +
                        "FROM flower",
                extractFlower());
    }

    private ResultSetEntityExtractor<AbstractFlower> extractFlower() {
        return rs -> {
            AbstractFlower flower;
            final String flowerType = rs.getString(1);
            switch (flowerType) {
                case "CHAMOMILE":
                    flower = new Chamomile(rs.getInt(6));
                    break;
                case "LILY":
                    flower = new Lily(rs.getInt(5));
                    break;
                case "ROSE":
                    flower = new Rose(rs.getInt(7));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown flower type: " + flowerType);

            }
            flower.setId(rs.getInt(8));
            flower.setLength(rs.getInt(2));
            flower.setFreshnessLevel(rs.getInt(3));
            flower.setPrice(rs.getInt(4));
            return flower;

        };
    }

    @Override
    public boolean insert(AbstractFlower abstractFlower) {
        return executeUpdate(
                "INSERT INTO flowers(flower_type, flower_length, freshnesslevel, " +
                        "  price, lily_size, " +
                        "  chamomile_petals, rose_thorns) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)",
                abstractFlower,
                this::fillBasicInfo);
    }

    private void fillBasicInfo(PreparedStatement ps, AbstractFlower flower) throws SQLException {
        ps.setInt(2, flower.getLength());
        ps.setInt(3, flower.getFreshnessLevel());
        ps.setInt(4, flower.getPrice());
        ps.setString(1, flower.getName());
        if (flower instanceof Rose) {
            ps.setInt(7, ((Rose) flower).getThorns());
        } else if (flower instanceof Lily) {
            ps.setInt(5, ((Lily) flower).getSize());
        }
        if (flower instanceof Chamomile) {
            ps.setInt(6, ((Chamomile) flower).getPetals());
        }
    }

    @Override
    public boolean update(Integer id, AbstractFlower abstractFlower) {
        return executeUpdate(
                "UPDATE flowers SET flower_type = ?, flower_length = ?, freshnesslevel = ?, " +
                        "  price = ?, lily_size = ?, " +
                        "  chamomile_petals = ?, rose_thorns = ? " +
                        "WHERE id = ? ",
                abstractFlower,
                (ps, f) -> {
                    fillBasicInfo(ps, f);
                    ps.setInt(8, f.getId());
                });

    }

    @Override
    public boolean delete(AbstractFlower abstractFlower) {
        return executeUpdate(
                "DELETE FROM accessories WHERE id = ?",
                abstractFlower,
                (ps, a) -> {
                    ps.setInt(3, a.getId());
                });
    }
}
