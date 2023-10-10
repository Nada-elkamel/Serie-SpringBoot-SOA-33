package com.nada.series.service;

import java.util.List;

import com.nada.series.dto.SerieDTO;
import com.nada.series.entities.Serie;
import com.nada.series.entities.Type;

public interface SerieService {

	SerieDTO saveSerie(SerieDTO s);
	
	SerieDTO updateSerie(SerieDTO s);
	
	void deleteSerie(Serie s);
	void deleteSerieById(Long id);
	SerieDTO getSerie(Long id);
	List<SerieDTO> getAllSeries();
	
	List<Serie> findByNomSerie(String nom);
	List<Serie> findByNomSerieContains(String nom);
	List<Serie> findByNomLangue (String nom, String langue);
	List<Serie> findByType (Type type);
	List<Serie> findByTypeIdType(Long id);
	List<Serie> findByOrderByNomSerieAsc();
	List<Serie> trierSeriesNomsLangue();
	
	SerieDTO convertEntityToDto (Serie serie);
	Serie convertDtoToEntity(SerieDTO serieDTO);


}
