package de.ihrigb.fwla.edprestbridge.persistence.repository;

import java.util.List;
import java.util.Optional;

import de.ihrigb.fwla.edprestbridge.persistence.model.LfFunktion;

public interface LfFunktionRepository extends ReadOnlyRepository<LfFunktion, Long> {

	List<LfFunktion> findByUserlevel(String userlevel);

	Optional<LfFunktion> findOneByFunktionAndUserlevel(String funktion, String userlevel);
}
