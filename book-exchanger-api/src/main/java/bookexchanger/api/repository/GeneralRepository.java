package bookexchanger.api.repository;

import java.sql.SQLException;
import java.util.List;

public interface GeneralRepository<T, I> {
    List<T> selectAll() throws SQLException;

    T findById(I id) throws SQLException;

    T insert(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(T entity) throws SQLException;
}
