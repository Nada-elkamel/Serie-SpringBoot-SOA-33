package com.nada.series.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nada.series.entities.Serie;
import com.nada.series.entities.Type;
import com.nada.series.repos.TypeRepository;

@RestController
@RequestMapping("/api/typ")
@CrossOrigin(origins="*")
public class TypeRESTController {

	
	@Autowired
	TypeRepository typeRepository;
    
    @RequestMapping(method=RequestMethod.GET)
	public List<Type> getAllTypes()
	{
    	return typeRepository.findAll();
	}
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Type getTypeById(@PathVariable("id") Long id) {
		return typeRepository.findById(id).get();
	}
    @RequestMapping(method = RequestMethod.POST)
	public Type createType(@RequestBody Type type) {
	return typeRepository.save(type);
	}
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteType(@PathVariable("id") Long id)
	{
	typeRepository.deleteById(id);
	}
}
