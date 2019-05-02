package bookexchanger.api.repository;

import bookexchanger.api.entities.AnnounceBoardEntity;
import bookexchanger.api.models.AnnounceDataResponse;

import java.sql.SQLException;
import java.util.List;

public interface AnnounceBoardRepository extends GeneralRepository<AnnounceBoardEntity,Integer>{

    List<AnnounceDataResponse> selectAll2() throws SQLException;
}
