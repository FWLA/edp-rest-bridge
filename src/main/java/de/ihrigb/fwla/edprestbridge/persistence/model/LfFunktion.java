package de.ihrigb.fwla.edprestbridge.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LF_FUNKTIONEN")
public class LfFunktion {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "FUNKTION")
	private String funktion;

	@Column(name = "ALLGEMEIN")
	private boolean allgemein;

	@Column(name = "USERLEVEL")
	private String userlevel;
}
