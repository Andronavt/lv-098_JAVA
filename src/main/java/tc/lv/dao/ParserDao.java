package tc.lv.dao;

import java.util.List;

import tc.lv.domain.Parser;

public interface ParserDao {

    String findDirByName(String name);

    List<Parser> findAll(int from, int count);

}
