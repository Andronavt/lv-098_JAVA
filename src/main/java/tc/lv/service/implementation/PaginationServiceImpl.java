package tc.lv.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.lv.dao.PaginationSettingsDao;
import tc.lv.domain.PaginationSettings;
import tc.lv.service.PaginationService;

@Service
public class PaginationServiceImpl implements PaginationService {

    @Autowired
    PaginationSettingsDao paginationSettingsDao;

    @Override
    public List<PaginationSettings> loadPages() {
        return paginationSettingsDao.findAll();
    }

}
