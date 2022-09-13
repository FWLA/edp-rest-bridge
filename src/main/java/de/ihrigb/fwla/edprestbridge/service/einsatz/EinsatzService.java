package de.ihrigb.fwla.edprestbridge.service.einsatz;

import java.util.List;
import java.util.Optional;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatz;

public interface EinsatzService {

	List<Einsatz> getAllOpen();

	Optional<Einsatz> getEinsatz(long einsatznummer);
}
