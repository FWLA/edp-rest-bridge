package de.ihrigb.fwla.edprestbridge.service.ereignis;

import java.util.List;

import de.ihrigb.fwla.edprestbridge.persistence.model.Ereignis;

public interface EreignisService {

	List<Ereignis> getCurrentList();

	List<Ereignis> getCurrentList(String ort);
}
