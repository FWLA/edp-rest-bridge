package de.ihrigb.fwla.edprestbridge.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "EREIGNISSE")
public class Ereignis {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "ORT")
	private String ort;

	@Column(name = "ORTSTEIL")
	private String ortsteil;

	@Column(name = "STRASSE")
	private String strasse;

	@Column(name = "HAUSNUMMER")
	private String hausnummer;

	@Column(name = "OBJEKTNAME")
	private String objektname;

	@Column(name = "TYP")
	private String typ;

	@Column(name = "BEZEICHNUNG")
	private String bezeichnung;

	@Lob
	@Column(name = "TEXT")
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGINN")
	private Date beginn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDE")
	private Date ende;

	@Column(name ="KOORDX")
	private Float koordX;

	@Column(name = "KOORDY")
	private Float koordY;
}
