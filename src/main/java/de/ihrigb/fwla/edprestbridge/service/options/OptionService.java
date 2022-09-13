package de.ihrigb.fwla.edprestbridge.service.options;

import java.util.Optional;

public interface OptionService {

	boolean isUnwetterModus();

	boolean isEinsatzanzeigeActive(String einsatzanzeige);

	Optional<Long> getEinsatzanzeigeActiveEinsatz(String einsatzanzeige);

	Optional<String> byName(String name);
}
