package de.ihrigb.fwla.edprestbridge.persistence.repository;

import java.util.List;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatzmittel;

public interface EinsatzmittelRepository extends ReadOnlyRepository<Einsatzmittel, String> {

	List<Einsatzmittel> findByEinsatznummer(long einstznummer);

	List<Einsatzmittel> findByStatusAndStandort(int status, String standort);
}
