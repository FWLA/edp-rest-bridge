package de.ihrigb.fwla.edprestbridge.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
interface ReadOnlyRepository<D, ID> extends Repository<D, ID>, QueryByExampleExecutor<D> {
	Optional<D> findById(ID id);

	List<D> findAll();
}
