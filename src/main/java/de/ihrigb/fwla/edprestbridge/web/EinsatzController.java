package de.ihrigb.fwla.edprestbridge.web;

import java.sql.Time;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatz;
import de.ihrigb.fwla.edprestbridge.service.einsatz.EinsatzService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/einsaetze")
class EinsatzController {

	private final EinsatzService einsatzService;

	@GetMapping("/{einsatznummer}")
	ResponseEntity<ValueContainer<EinsatzWM>> getOne(@PathVariable("einsatznummer") long einsatznummer) {
		return ResponseEntity
				.of(this.einsatzService.getEinsatz(einsatznummer).map(EinsatzWM::new).map(ValueContainer::build));
	}

	@Getter
	static class EinsatzWM {
		private final long einsatznummer;
		private final String status;
		private final Date eroeff;
		private final String eroeffBenutzer;
		private final Date ende;
		private final String endeBenutzer;
		private final Date meldungseingang;
		private final String meldungseingangBenutzer;
		private final String meldung;
		private final String einsatzart;
		private final String stichwort;
		private final String stichwortKlartext;
		private final String ort;
		private final String ortsteil;
		private final String plz;
		private final String strasse;
		private final String hausnummer;
		private final String objektname;
		private final String bemerkung;
		private final String interneNummer;
		private final Float koordX;
		private final Float koordY;
		private final String meldebild;
		private final Date meldungLst;
		private final Time alarmLst;

		EinsatzWM(Einsatz e) {
			this.einsatznummer = e.getEinsatznummer();
			this.status = e.getStatus();
			this.eroeff = e.getEroeff();
			this.eroeffBenutzer = e.getEroeffBenutzer();
			this.ende = e.getEnde();
			this.endeBenutzer = e.getEndeBenutzer();
			this.meldungseingang = e.getMeldungseingang();
			this.meldungseingangBenutzer = e.getMeldungseingangBenutzer();
			this.meldung = e.getMeldung();
			this.einsatzart = e.getEinsatzart();
			this.stichwort = e.getStichwort();
			this.stichwortKlartext = e.getStichwortKlartext();
			this.ort = e.getOrt();
			this.ortsteil = e.getOrtsteil();
			this.plz = e.getPlz();
			this.strasse = e.getStrasse();
			this.hausnummer = e.getHausnummer();
			this.objektname = e.getObjektname();
			this.bemerkung = e.getBemerkung();
			this.interneNummer = e.getInterneNummer();
			this.koordX = e.getKoordX();
			this.koordY = e.getKoordY();
			this.meldebild = e.getMeldebild();
			this.meldungLst = e.getMeldungLst();
			this.alarmLst = e.getAlarmLst();
		}
	}
}
