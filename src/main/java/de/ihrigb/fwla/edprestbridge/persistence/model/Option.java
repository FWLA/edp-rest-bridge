package de.ihrigb.fwla.edprestbridge.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OPTIONEN")
public class Option {

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "WERT")
	private String wert;
}
