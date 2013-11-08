package tc.lv.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;

@Repository
public class SourceDaoImpl implements SourceDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public void creat(String sourceName, Date sourceDateAdded, Double rank,
			String dirname, String listType) {
		entityManager.persist(new Source(sourceName, sourceDateAdded, rank,
				dirname, listType));
	}

	@Override
	public void creat(String sourceName, String url, Date sourceDateAdded,
			Double rank, String dirname, String listType, Date updated,
			String parser, Collection<IpAddress> ipSet) {
		entityManager.persist(new Source(sourceName, url, sourceDateAdded,
				rank, dirname, listType, updated, parser, ipSet));
	}

	@Override
	public Source loadByName(String sourceName) {
		Query query = entityManager.createNamedQuery("Source.findByName",
				Source.class);
		query.setParameter("sourceName", sourceName);
		return (Source) query.getSingleResult();
	}

	@Override
	public List<Source> loadAll() {
		return entityManager.createQuery("from Source").getResultList();
	}

	@Override
	public void delete(String sourceName) {
		sourceName = sourceName.trim();
		Query query = entityManager.createNamedQuery("Source.findByName",
				Source.class).setParameter("sourceName", sourceName);
		Source tempSource = (Source) query.getSingleResult();
		entityManager.remove(tempSource);
	}

}
