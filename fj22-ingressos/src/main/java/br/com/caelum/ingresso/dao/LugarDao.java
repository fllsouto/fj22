package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Lugar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by nando on 03/03/17.
 */
@Repository
public class LugarDao {

	@PersistenceContext
	private EntityManager manager;

	public Lugar findOne(Integer integer) {
		return manager.find(Lugar.class, integer);
	}

	public void save(Lugar lugar) {
		manager.persist(lugar);
	}
}
