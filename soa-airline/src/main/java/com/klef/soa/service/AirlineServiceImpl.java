package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Airline;
import com.klef.soa.repository.AirlineRepository;

@Service
public class AirlineServiceImpl  implements AirlineService{

	@Autowired
	private AirlineRepository repo;
	
	@Override
	public String addAirline(Airline airline) {
					
		repo.save(airline);
		return "airline added successfully" ;
	}

	@Override
	public String updateAirline(Airline airline) {
       
		Airline air = repo.findById(airline.getAirlineId()).orElse(null);
		if (air!= null) {
			air.setName(airline.getName());
			air.setStatus(airline.getStatus());
			air.setLocation(airline.getLocation());
	        repo.save(air);
	        return " updated successfully ";
	      
			
		}
		  else {
	        	return " no record found";
	        }
		
		
	}

	@Override
	public String deleteAirline(long id) {
		
		Optional<Airline> optional = repo.findById(id);
		if(optional.isPresent()) {
			Airline air = optional.get();
			repo.delete(air);
			return "AirLine deleted Successfully" + id;
		}else {
			return "AirLine Not Found";
		}
		
				
		
	}

	@Override
	public List<Airline> displayAllAirlines() {
		return repo.findAll();

	}

	@Override
	public Airline displayById(long id) {
		return repo.findById(id).orElse(null);
	}
	@Override
	public List<Airline> displayByName(String name)
	{
	    return repo.findByName(name);
	}

	@Override
	public List<Airline> displayByType(String type)
	{
	    return repo.findByType(type);
	}

	@Override
	public long displayAirlineCount()
	{
	    return repo.count();
	}
	
	
}
