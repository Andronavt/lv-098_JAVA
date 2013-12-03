package tc.lv.dao;

import java.util.List;

import tc.lv.domain.PaginationSettings;

public interface PaginationSettingsDao {

    List<PaginationSettings> findAll();

}
