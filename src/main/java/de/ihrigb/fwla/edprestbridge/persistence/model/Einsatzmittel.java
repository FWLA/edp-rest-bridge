package de.ihrigb.fwla.edprestbridge.persistence.model;

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
@Table(name = "EINSATZMITTEL")
public class Einsatzmittel {

	@Id
	@Column(name = "RUFNAME")
	private String rufname;

	@Column(name = "RUFNAMELANG")
	private String rufnameLang;

	@Column(name = "STATUS")
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ZEITSTEMPEL")
	private Date zeitstempel;

	@Column(name = "TYP")
	private String typ;

	@Column(name = "STANDORT")
	private String standort;

	@Column(name = "WACHE")
	private String wache;

	@Column(name = "KOORDX")
	private Float koordX;

	@Column(name = "KOORDY")
	private Float koordY;

	@Column(name = "EINSATZ")
	private String einsatz;

	@Column(name = "EINSATZNUMMER")
	private Long einsatznummer;

	@Column(name = "S6_GRUND")
	private String s6Grund;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "S6_TIME")
	private Date s6Time;
}
