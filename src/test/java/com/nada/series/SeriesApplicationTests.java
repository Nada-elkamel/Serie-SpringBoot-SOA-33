package com.nada.series;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nada.series.entities.Serie;
import com.nada.series.entities.Type;
import com.nada.series.repos.SerieRepository;

@SpringBootTest
class SeriesApplicationTests {
	@Autowired
  private SerieRepository serieRepository;
	@Test
	public void testCreateSerie() {
		Type typ=new Type(1L,"Serie");
		Serie ser = new Serie("Legend of the blue sea","Coréen",new Date(),typ);
	    serieRepository.save(ser);
   }
	
	 @Test
	  public void testFindSerie() {
		  Serie s= serieRepository.findById(3L).get();
		  System.out.println(s);
	  }
	 @Test
	 public void testUpdateSerie() {
		 Serie s= serieRepository.findById(3L).get();
		 s.setNomSerie("annabelleeee");
		 serieRepository.save(s);
	 }
	 @Test
	 public void testDeleteSerie() {
		 serieRepository.deleteById(31L);
	 }
	 @Test
	 public void testListerTousSeries() {
		 List<Serie> sers= serieRepository.findAll();
		 for (Serie s:sers)
		 {
			 System.out.println(s);
		 }
	 }
	 
	 @Test
	  public void testFindSerieByNom() {
		 List <Serie> sers= serieRepository.findByNomSerie("Legend of the blue sea");
		 for (Serie s:sers)
		 {
			 System.out.println(s);
		 }
	  }
	 @Test
	  public void testFindSerieByNomContains() {
		 List <Serie> sers= serieRepository.findByNomSerieContains("sea");
		 for (Serie s:sers)
		 {
			 System.out.println(s);
		 }
	  }
	 @Test
	 public void testfindByNomSerieLangue()
	 {
	 List<Serie> sers = serieRepository.findByNomLangue("The 100","Anglais" );
	 for (Serie s : sers)
	 {
	 System.out.println(s);
	 }
	 }

	 @Test
	 public void testfindByType()
	 {
	 Type type = new Type();
	 type.setIdType(2L);
	 List<Serie> sers = serieRepository.findByType(type);
	 for (Serie s : sers)
	 {
	 System.out.println(s);
	 }
	 }
	 @Test
	 public void findByTypeIdType()
	 {
	 List<Serie> sers = serieRepository.findByTypeIdType(1L);
	 for (Serie s : sers)
	 {
	 System.out.println(s);
	 }
	  }
	 @Test
	 public void testfindByOrderByNomSerieAsc()
	 {
	 List<Serie> sers = 
	 serieRepository.findByOrderByNomSerieAsc();
	 for (Serie s : sers)
	 {
	 System.out.println(s);
	 }
	 }
	 @Test
	 public void testTrierSeriesNomsLangue()
	 {
	 List<Serie> sers = serieRepository.trierSeriesNomsLangue();
	 for (Serie s : sers)
	 {
	 System.out.println(s);
	 }
	 }

	
	
	}

