package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.Product;

@Repository
@Transactional
public class HibernateProductDaoImpl extends AggregateBaseDao<Product> implements ProductDao {

	public HibernateProductDaoImpl(){}
	
	public HibernateProductDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}

	public void saveProductEntity(Product prod) {
		saveNew(prod);
	}

	public void deleteProductEntityById(Product prod) {
		delete(prod);		
	}

	@Override
	public Product findEntityByRefId(String refId) {
		final String hql = "SELECT P FROM Product P WHERE P.refId=:refId";
		final Query query = getSession().createQuery(hql).setParameter("refId", refId);
		final Product prod = executeQuery(query, "Product");
		return prod;
	}

}
