package de.ihrigb.fwla.edprestbridge.service.einsatz;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatz;
import de.ihrigb.fwla.edprestbridge.persistence.repository.EinsatzRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EdpEinsatzService implements EinsatzService {

	private static final String STATUS_OPEN = "OFFEN";

	private final EinsatzRepository einsatzRepository;

	@Override
	public List<Einsatz> getAllOpen() {
		return this.einsatzRepository.findByStatus(STATUS_OPEN);
	}

	@Override
	public Optional<Einsatz> getEinsatz(long einsatznummer) {
		return this.einsatzRepository.findById(einsatznummer);
	}
}
