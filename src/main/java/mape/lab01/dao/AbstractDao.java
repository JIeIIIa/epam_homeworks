package mape.lab01.dao;

import mape.lab01.persistence.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public abstract class AbstractDao<T> {
    private static final Logger LOG = LogManager.getLogger(AbstractDao.class);

    protected Optional<T> findById(String sql, Integer id,
                                   ResultSetEntityExtractor<T> mapper) {
        T entity = null;
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                entity = mapper.map(resultSet);
            }
        } catch (Exception e) {
            LOG.error("Exception while getting entity by id");
        }

        return Optional.ofNullable(entity);
    }

    protected List<T> findAll(String sql, ResultSetEntityExtractor<T> mapper) {
        List<T> result = new ArrayList<>();
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while(resultSet.next()) {
                T entity = mapper.map(resultSet);

                result.add(entity);
            }

        } catch (Exception e) {
            LOG.error("Exception while getting entity by id");
        }

        return result;
    }

    protected boolean executeUpdate(String sql, T t, PrepareStatementFiller<T> paramsMapper) {
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            paramsMapper.fill(ps, t);

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            LOG.error("Exception while modifing data: " + t);
        }
        return false;
    }
}
