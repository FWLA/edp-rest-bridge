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
@Table(name = "EM_EINSAETZE")
public class EmEinsatz {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "RUFNAME")
	private String rufname;

	@Column(name = "EINSATZNUMMER")
	private long einsatznummer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DISPONIERT")
	private Date disponiert;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATUS5")
	private Date status3;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATUS6")
	private Date status4;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATUS1")
	private Date status1;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATUS2")
	private Date status2;
}
