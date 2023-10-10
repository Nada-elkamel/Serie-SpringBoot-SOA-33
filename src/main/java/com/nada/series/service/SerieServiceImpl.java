package com.nada.series.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nada.series.dto.SerieDTO;
import com.nada.series.entities.Serie;
import com.nada.series.entities.Type;
import com.nada.series.repos.ImageRepository;
import com.nada.series.repos.SerieRepository;

@Service
public class SerieServiceImpl implements SerieService {

	@Autowired
	SerieRepository serieRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public SerieDTO saveSerie(SerieDTO s) {
		 return convertEntityToDto( serieRepository.save(convertDtoToEntity(s)));
	}

//	@Override
//	public Serie updateSerie(Serie s) {
//		return serieRepository.save(s);
//	}

	@Override
	public SerieDTO updateSerie(SerieDTO s) {
		return this.convertEntityToDto(serieRepository.save(this.convertDtoToEntity(s)));

	}

	@Override
	public void deleteSerie(Serie s) {
		serieRepository.delete(s);
	}

	@Override
	public void deleteSerieById(Long id) {
		serieRepository.deleteById(id);
	}

	@Override
	public SerieDTO getSerie(Long id) {
		return convertEntityToDto(serieRepository.findById(id).get());
	}

	@Override
	public List<SerieDTO> getAllSeries() {
		return serieRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
				//OU BIEN
				/*List<Produit> prods = produitRepository.findAll();
				List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
				for (Produit p : prods)
				listprodDto.add(convertEntityToDto(p));
				return listprodDto;*/

	}

	@Override
	public List<Serie> findByNomSerie(String nom) {
		return serieRepository.findByNomSerie(nom);
	}

	@Override
	public List<Serie> findByNomSerieContains(String nom) {
		return serieRepository.findByNomSerieContains(nom);
	}

	@Override
	public List<Serie> findByNomLangue(String nom, String langue) {
		return serieRepository.findByNomLangue(nom, langue);
	}

	@Override
	public List<Serie> findByType(Type type) {
		return serieRepository.findByType(type);

	}

	@Override
	public List<Serie> findByTypeIdType(Long id) {
		return serieRepository.findByTypeIdType(id);
	}

	@Override
	public List<Serie> findByOrderByNomSerieAsc() {
		return serieRepository.findByOrderByNomSerieAsc();

	}

	@Override
	public List<Serie> trierSeriesNomsLangue() {
		return serieRepository.trierSeriesNomsLangue();
	}

	
	@Override
	public SerieDTO convertEntityToDto(Serie serie) {
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	SerieDTO serieDTO = modelMapper.map(serie, SerieDTO.class);
	 return serieDTO;
	 }

	
	@Override
	public Serie convertDtoToEntity(SerieDTO serieDTO) {
		Serie serie=modelMapper.map(serieDTO, Serie.class);
		return serie;
	}
	
}
