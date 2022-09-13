package de.ihrigb.fwla.edprestbridge.persistence.repository;

import java.util.List;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatz;

public interface EinsatzRepository extends ReadOnlyRepository<Einsatz, Long> {
	List<Einsatz> findByStatus(String status);
}
