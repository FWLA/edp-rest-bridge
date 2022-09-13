package de.ihrigb.fwla.edprestbridge.web;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ihrigb.fwla.edprestbridge.service.einsatz.EinsatzService;
import de.ihrigb.fwla.edprestbridge.service.lffunktion.LfFunktionService;
import de.ihrigb.fwla.edprestbridge.service.options.OptionService;
import de.ihrigb.fwla.edprestbridge.web.EinsatzController.EinsatzWM;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/einsatzanzeigen")
public class EinsatzanzeigeController {

	private final LfFunktionService lfFunktionService;
	private final OptionService optionService;
	private final EinsatzService einsatzService;

	@GetMapping
	ResponseEntity<ValueContainer<List<String>>> list() {
		return ResponseEntity.ok(ValueContainer.build(this.lfFunktionService.getEinsatzanzeigen()));
	}

	@GetMapping("/{einsatzanzeige}")
	ResponseEntity<ValueContainer<EinsatzanzeigeWM>> status(@PathVariable("einsatzanzeige") String einsatzanzeigeId) {
		return ResponseEntity.of(lfFunktionService.getEinsatzanzeige(einsatzanzeigeId)
				.map(
						einsatzanzeige -> {
							Optional<Long> einsatzanzeigeWert = optionService.getEinsatzanzeigeActiveEinsatz(
									einsatzanzeige.getFunktion().toUpperCase(Locale.GERMAN));
							EinsatzWM einsatzWM = einsatzanzeigeWert.flatMap(this.einsatzService::getEinsatz)
									.map(EinsatzWM::new).orElse(null);
							return new EinsatzanzeigeWM(einsatzanzeigeId, einsatzWM);
						})
				.map(ValueContainer::build));
	}

	@Getter
	@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
	static class EinsatzanzeigeWM {
		private final String einsatzanzeige;
		private final EinsatzWM einsatz;
	}
}
