package com.nada.series.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
   

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
    
	private String nomType;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="type")
	private List<Serie> series;
	
	 public Type(long l, String nomType) {
			this.idType=l;
			this.nomType=nomType;
			
		}
}
