package com.practicas.FS.AngularBack;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CocheService {
	
	private final CocheRepository cocheRepository;
	
	public Coche postCoche(Coche coche) {
		return cocheRepository.save(coche);
	}
	
	public List<Coche> getAllCoche() {
		return cocheRepository.findAll();
	}
	
	public Coche getCocheById(Long id) {
		return cocheRepository.findById(id).orElse(null);
	}
	
	
	public Coche actualizarCoche(Coche coche) {
		return cocheRepository.save(coche);
	}
	
	public void deleteCoche(Long id) {
		cocheRepository.deleteById(id);
	}

}
