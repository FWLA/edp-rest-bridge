package de.ihrigb.fwla.edprestbridge.web;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.ihrigb.fwla.edprestbridge.persistence.model.Ereignis;
import de.ihrigb.fwla.edprestbridge.service.ereignis.EreignisService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ereignisse")
class EreignisController {

	private final EreignisService ereignisService;

	@GetMapping("/current")
	ResponseEntity<ValueContainer<List<EreignisWM>>> getCurrentItems(
			@RequestParam(name = "ort", required = false) String ort) {

		if (ort != null) {
			return ResponseEntity.ok(ValueContainer.build(
					this.ereignisService.getCurrentList(ort).stream().map(EreignisWM::new)
							.collect(Collectors.toList())));
		}

		return ResponseEntity.ok(ValueContainer.build(
				this.ereignisService.getCurrentList().stream().map(EreignisWM::new).collect(Collectors.toList())));
	}

	@Getter
	static class EreignisWM {

		private long id;
		private String ort;
		private String ortsteil;
		private String strasse;
		private String hausnummer;
		private String objektname;
		private String typ;
		private String bezeichnung;
		private String text;
		private Date beginn;
		private Date ende;
		private Float koordX;
		private Float koordY;

		EreignisWM(Ereignis ereignis) {
			this.id = ereignis.getId();
			this.ort = ereignis.getOrt();
			this.ortsteil = ereignis.getOrtsteil();
			this.strasse = ereignis.getStrasse();
			this.hausnummer = ereignis.getHausnummer();
			this.objektname = ereignis.getObjektname();
			this.typ = ereignis.getTyp();
			this.bezeichnung = ereignis.getBezeichnung();
			this.text = ereignis.getText();
			this.beginn = ereignis.getBeginn();
			this.ende = ereignis.getEnde();
			this.koordX = ereignis.getKoordX();
			this.koordY = ereignis.getKoordY();
		}
	}
}
