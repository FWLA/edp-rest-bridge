package de.ihrigb.fwla.edprestbridge.service.einsatzmittel;

import java.util.List;

import org.springframework.stereotype.Component;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatzmittel;
import de.ihrigb.fwla.edprestbridge.persistence.repository.EinsatzmittelRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EdpEinsatzmittelService implements EinsatzmittelService {

	private final EinsatzmittelRepository einsatzmittelRepository;

	@Override
	public List<Einsatzmittel> getAll() {
		return this.einsatzmittelRepository.findAll();
	}

	@Override
	public List<Einsatzmittel> getByEinsatznummer(long einsatznummer) {
		return this.einsatzmittelRepository.findByEinsatznummer(einsatznummer);
	}

	@Override
	public List<Einsatzmittel> getByStatusAndStandort(int status, String standort) {
		return this.einsatzmittelRepository.findByStatusAndStandort(status, standort);
	}
}
