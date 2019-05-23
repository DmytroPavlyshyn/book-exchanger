package bookexchanger.api.repository;


import bookexchanger.api.entities.UserAnnounceBookEntity;

import java.sql.SQLException;
import java.util.List;

public interface UserAnnounceBookRepository {
    List<UserAnnounceBookEntity> selectAll() throws SQLException;
    UserAnnounceBookEntity findById(Integer id) throws SQLException;
}
