package de.ihrigb.fwla.edprestbridge.service.lffunktion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import de.ihrigb.fwla.edprestbridge.persistence.model.LfFunktion;
import de.ihrigb.fwla.edprestbridge.persistence.repository.LfFunktionRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EdpLfFunktionService implements LfFunktionService {

	private static final String USERLEVEL_MONITOR = "monitor";

	private final LfFunktionRepository lfFunktionRepository;

	@Override
	public List<String> getEinsatzanzeigen() {
		return this.lfFunktionRepository.findByUserlevel(USERLEVEL_MONITOR).stream().map(LfFunktion::getFunktion)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<LfFunktion> getEinsatzanzeige(String einsatzanzeige) {
		return this.lfFunktionRepository.findOneByFunktionAndUserlevel(einsatzanzeige, USERLEVEL_MONITOR);
	}
}
