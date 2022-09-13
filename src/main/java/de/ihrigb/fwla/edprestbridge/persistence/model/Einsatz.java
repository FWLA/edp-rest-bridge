package de.ihrigb.fwla.edprestbridge.persistence.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "EINSAETZE")
public class Einsatz {

	@Id
	@Column(name = "EINSATZNUMMER")
	private long einsatznummer;

	@Column(name = "STATUS")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EROEFF")
	private Date eroeff;

	@Column(name = "EROEFF_BENUTZER")
	private String eroeffBenutzer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDE")
	private Date ende;

	@Column(name = "ENDE_BENUTZER")
	private String endeBenutzer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MELDUNGSEINGANG")
	private Date meldungseingang;

	@Column(name = "MELDUNGSEINGANG_BENUTZER")
	private String meldungseingangBenutzer;

	@Column(name = "MELDUNG")
	private String meldung;
	
	@Column(name = "EINSATZART")
	private String einsatzart;

	@Column(name = "STICHWORT")
	private String stichwort;

	@Column(name = "STICHWORT_KLARTEXT")
	private String stichwortKlartext;

	@Column(name = "ORT")
	private String ort;

	@Column(name = "ORTSTEIL")
	private String ortsteil;

	@Column(name = "PLZ")
	private String plz;

	@Column(name = "STRASSE")
	private String strasse;

	@Column(name = "HAUSNUMMER")
	private String hausnummer;

	@Column(name = "OBJEKTNAME")
	private String objektname;

	@Column(name = "BEMERKUNG")
	private String bemerkung;

	@Column(name = "INTERNE_NUMMER")
	private String interneNummer;

	@Column(name = "KOORDX")
	private Float koordX;

	@Column(name = "KOORDY")
	private Float koordY;

	@Column(name = "MELDEBILD")
	private String meldebild;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MELDUNG_LST")
	private Date meldungLst;

	@Column(name = "ALARM_LST")
	private Time alarmLst;
}
