package com.nada.series.dto;

import java.util.Date;

import jakarta.persistence.ManyToOne;

import com.nada.series.entities.Image;
import com.nada.series.entities.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SerieDTO {

	private Long idSerie;
	private String nomSerie;
	private String langue;
	private Date dateDiffusion;
	private Type type;
	private Image image;
}
