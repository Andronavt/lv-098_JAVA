package tc.lv.service;

import java.util.List;

import tc.lv.domain.PaginationSettings;

public interface PaginationService {

    public List<PaginationSettings> loadPages();

}
