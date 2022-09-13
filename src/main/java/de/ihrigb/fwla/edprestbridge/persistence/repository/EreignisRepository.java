package de.ihrigb.fwla.edprestbridge.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.ihrigb.fwla.edprestbridge.persistence.model.Ereignis;

public interface EreignisRepository extends ReadOnlyRepository<Ereignis, Long> {

	@Query("SELECT e FROM Ereignis e WHERE CURRENT_TIMESTAMP BETWEEN BEGINN AND ENDE")
	List<Ereignis> getCurrentItems();

	@Query("SELECT e FROM Ereignis e WHERE ORT = :ort AND CURRENT_TIMESTAMP BETWEEN BEGINN AND ENDE")
	List<Ereignis> getCurrentItems(@Param("ort") String ort);
}
