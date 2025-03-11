package com.practicas.FS.AngularBack;




import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
@CrossOrigin("*") // Settear CORS
public class CocheController {
	
	

  private final CocheService cocheService;

  
  @PostMapping("/añadir")
  public Coche postCoche(@RequestBody Coche coche) {
	  
	  return cocheService.postCoche(coche);
	  
  }
  
  @GetMapping("/coches")
  private List<Coche> getAllCoche() {
	  return cocheService.getAllCoche();
  }

  @GetMapping("/porid/{id}")
  public ResponseEntity<Coche> getCocheById(@PathVariable ("id") Long id) {
	  Coche coche = cocheService.getCocheById(id);
	  if (coche == null)
		  return ResponseEntity.notFound().build();
	  return ResponseEntity.ok(coche);
  }
 

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Coche> actualizarCoche(@PathVariable ("id") Long id,@RequestBody Coche coche) {
	  Coche cocheExistente = cocheService.getCocheById(id);
	  if (cocheExistente == null)
		  return ResponseEntity.notFound().build();
	  cocheExistente.setMarca(coche.getMarca());
	  cocheExistente.setModelo(coche.getModelo());
	  Coche actualizarCoche = cocheService.actualizarCoche(cocheExistente);
	  return ResponseEntity.ok(actualizarCoche);
  }
  
  @DeleteMapping("/borrar/{id}")
  public ResponseEntity<?> deleteCoche(@PathVariable ("id") Long id) {
	  Coche cocheExistente = cocheService.getCocheById(id);
	  if (cocheExistente == null)
		  return ResponseEntity.notFound().build();
	  cocheService.deleteCoche(id);
	  return ResponseEntity.ok().build();
  }
  
 
  
}