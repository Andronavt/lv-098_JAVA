package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddressImpl;
import tc.lv.domain.Source;

@Repository
public class SourceDaoImpl implements SourceDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public void delete(Source source) {

		Query query = entityManager.createNamedQuery(Source.FIND_BY_NAME)
				.setParameter(1, source);
		Source tempSource = (Source) Dao.find(query);
		for (IpAddressImpl address : tempSource.getIpSet()) {
			address.getSourceSet().remove(tempSource);
			if (address.getSourceSet().size() == 0) {
				entityManager.remove(address);
			}
		}
		tempSource.getIpSet().clear();
		entityManager.remove(tempSource);
	}

	@Override
	public Source findByName(String sourceName) {

		Query query = entityManager.createNamedQuery(Source.FIND_BY_NAME)
				.setParameter(1, sourceName);
		return (Source) Dao.find(query);
	}

	@Override
	public List<Source> getAll() {

		return entityManager.createNamedQuery(Source.GET_ALL, Source.class)
				.getResultList();
	}

	@Override
	public void save(Source source) {

		entityManager.persist(source);
	}

	@Override
	public Source update(Source source) {

		return entityManager.merge(source);
	}

}
