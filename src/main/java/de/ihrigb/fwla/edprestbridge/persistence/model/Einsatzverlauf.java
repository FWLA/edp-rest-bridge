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
@Table(name = "EINSATZVERLAUF")
public class Einsatzverlauf {

	@Id
	@Column(name = "ID")
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ADD_TIMESTAMP")
	private Date addTimestamp;

	@Column(name = "ADD_USER")
	private String addUser;

	@Column(name = "VERLAUFID")
	private int verlaufId;

	@Column(name = "EINSATZNUMMER")
	private long einsatznummer;

	@Column(name = "TYP")
	private String typ;

	@Column(name = "VON")
	private String von;

	@Column(name = "AN")
	private String an;

	@Lob
	@Column(name = "EINTRAG")
	private String eintrag;
}
