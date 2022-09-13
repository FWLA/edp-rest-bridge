package de.ihrigb.fwla.edprestbridge.web;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatzmittel;
import de.ihrigb.fwla.edprestbridge.persistence.repository.EinsatzmittelRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/einsatzmittel")
class EinsatzmittelController {

	private final EinsatzmittelRepository einsatzmittelRepository;

	@GetMapping
	ResponseEntity<ValueContainer<List<EinsatzmittelWM>>> find(
			@RequestParam(name = "einsatznummer", required = false) Long einsatznummer,
			@RequestParam(name = "status", required = false) Integer status,
			@RequestParam(name = "standort", required = false) String standort) {

		Einsatzmittel example = new Einsatzmittel();
		example.setEinsatznummer(einsatznummer);
		example.setStatus(status);
		example.setStandort(standort);
		Example<Einsatzmittel> ex = Example.of(example);

		return ResponseEntity.ok(ValueContainer.build(
				StreamSupport.stream(this.einsatzmittelRepository.findAll(ex).spliterator(), false)
						.map(EinsatzmittelWM::new).collect(Collectors.toList())));
	}

	@Getter
	static class EinsatzmittelWM {

		private final String rufname;
		private final String rufnameLang;
		private final int status;
		private final Date zeitstempel;
		private final String typ;
		private final String standort;
		private final String wache;
		private final Float koordX;
		private final Float koordY;
		private final String einsatz;
		private final Long einsatznummer;
		private final String s6Grund;
		private final Date s6Time;

		EinsatzmittelWM(Einsatzmittel e) {
			this.rufname = e.getRufname();
			this.rufnameLang = e.getRufnameLang();
			this.status = e.getStatus();
			this.zeitstempel = e.getZeitstempel();
			this.typ = e.getTyp();
			this.standort = e.getStandort();
			this.wache = e.getWache();
			this.koordX = e.getKoordX();
			this.koordY = e.getKoordY();
			this.einsatz = e.getEinsatz();
			this.einsatznummer = e.getEinsatznummer();
			this.s6Grund = e.getS6Grund();
			this.s6Time = e.getS6Time();
		}
	}
}
