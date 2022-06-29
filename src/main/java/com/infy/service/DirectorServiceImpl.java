package com.infy.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entity.Director;
import com.infy.repository.DirectorRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service("directorService")
@Transactional
public class DirectorServiceImpl implements DirectorService{
	@Autowired
	private DirectorRepository directorRepository;

	@Override
	public void updateDirectorDetails(String firstName, String lastName, String newAddress, Integer newContact) {
		Integer rowsAffected = directorRepository.updateDetails(newAddress, newContact, firstName, lastName);
		System.out.println("Number of rows affected: " + rowsAffected);
		
	}

	@Override
	public void getMoviesThroughDirectorName(String firstName, String lastName) {
		Optional<Director> director = directorRepository.findByFirstNameAndLastName(firstName, lastName);
		if (director.isEmpty()) {
			System.out.println("Director not found");
		} else {
			//director.get().getMovies().forEach(System.out::println);
		}

		
	}

}
