package de.ihrigb.fwla.edprestbridge.service.options;

import java.util.Optional;

import org.springframework.stereotype.Component;

import de.ihrigb.fwla.edprestbridge.persistence.model.Option;
import de.ihrigb.fwla.edprestbridge.persistence.repository.OptionRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EdpOptionService implements OptionService {

	private final static String NAME_UNWETTERMODUS = "UNWETTERMODUS";

	private final OptionRepository optionRepository;

	@Override
	public boolean isUnwetterModus() {
		return this.optionRepository.findById(NAME_UNWETTERMODUS).map(Option::getWert).map(w -> "1".equalsIgnoreCase(w))
				.orElse(false);
	}

	@Override
	public boolean isEinsatzanzeigeActive(String einsatzanzeige) {
		return this.optionRepository.findById(einsatzanzeige).isPresent();
	}

	@Override
	public Optional<Long> getEinsatzanzeigeActiveEinsatz(String einsatzanzeige) {
		return this.optionRepository.findById(einsatzanzeige).map(Option::getWert).map(Long::parseLong);
	}

	@Override
	public Optional<String> byName(String name) {
		return this.optionRepository.findById(name).map(Option::getWert);
	}
}
