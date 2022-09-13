package de.ihrigb.fwla.edprestbridge.service.einsatzmittel;

import java.util.List;

import de.ihrigb.fwla.edprestbridge.persistence.model.Einsatzmittel;

public interface EinsatzmittelService {

	List<Einsatzmittel> getAll();

	List<Einsatzmittel> getByEinsatznummer(long einsatznummer);

	List<Einsatzmittel> getByStatusAndStandort(int status, String standort);
}
