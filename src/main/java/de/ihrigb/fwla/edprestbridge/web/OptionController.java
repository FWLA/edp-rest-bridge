package de.ihrigb.fwla.edprestbridge.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ihrigb.fwla.edprestbridge.service.options.OptionService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/optionen")
class OptionController {

	private final OptionService optionService;

	@GetMapping
	ResponseEntity<ValueContainer<OptionsWM>> getAll() {
		return ResponseEntity.ok(ValueContainer.build(OptionsWM.build(optionService)));
	}

	@GetMapping("/{name}")
	ResponseEntity<?> getOne(@PathVariable("name") String name) {
		return ResponseEntity.of(this.optionService.byName(name).map(ValueContainer::build));
	}

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PRIVATE)
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static class OptionsWM {

		static OptionsWM build(OptionService optionService) {
			OptionsWM wm = new OptionsWM();
			wm.setUnwettermodus(optionService.isUnwetterModus());
			return wm;
		}

		private boolean unwettermodus;
	}
}
