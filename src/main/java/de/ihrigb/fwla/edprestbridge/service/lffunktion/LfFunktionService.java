package de.ihrigb.fwla.edprestbridge.service.lffunktion;

import java.util.List;
import java.util.Optional;

import de.ihrigb.fwla.edprestbridge.persistence.model.LfFunktion;

public interface LfFunktionService {

	List<String> getEinsatzanzeigen();

	Optional<LfFunktion> getEinsatzanzeige(String einsatzanzeige);
}
