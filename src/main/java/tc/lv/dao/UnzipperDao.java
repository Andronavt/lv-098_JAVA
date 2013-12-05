package tc.lv.dao;

import java.util.List;

import tc.lv.domain.Unzipper;

public interface UnzipperDao {

    List<Unzipper> findAll();

    String findDirByName(String name);

}
