package de.ihrigb.fwla.edprestbridge.service.ereignis;

import java.util.List;

import org.springframework.stereotype.Component;

import de.ihrigb.fwla.edprestbridge.persistence.model.Ereignis;
import de.ihrigb.fwla.edprestbridge.persistence.repository.EreignisRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EdpEreignisService implements EreignisService {

	private final EreignisRepository ereignisRepository;

	@Override
	public List<Ereignis> getCurrentList() {
		return this.ereignisRepository.getCurrentItems();
	}

	@Override
	public List<Ereignis> getCurrentList(String ort) {
		return this.ereignisRepository.getCurrentItems(ort);
	}
}
