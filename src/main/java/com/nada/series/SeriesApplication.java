package com.nada.series;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nada.series.entities.Serie;

import aj.org.objectweb.asm.Type;

@SpringBootApplication
public class SeriesApplication implements CommandLineRunner  {
	
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Serie.class,Type.class);
		}

	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}
