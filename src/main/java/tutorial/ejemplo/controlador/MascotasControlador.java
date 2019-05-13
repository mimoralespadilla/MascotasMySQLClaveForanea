package tutorial.ejemplo.controlador;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tutorial.ejemplo.bean.MascotasModelo;
import tutorial.ejemplo.repositorio.MascotasRepositorio;

@RestController
@RequestMapping("/mascotas")
public class MascotasControlador {

	@Autowired
	private MascotasRepositorio service;

	@GetMapping(path = "/mascotas")
	public @ResponseBody Iterable<MascotasModelo> getAllMascotas() {
		return service.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public @ResponseBody Optional<MascotasModelo> getMascotasById(@PathVariable("id") Integer id) {
		return service.findById(id);

	}

	@GetMapping(path = "/name/{name}")
	public @ResponseBody Optional<MascotasModelo> getMascotaByName(@PathVariable("name") String name) {
		return service.findByname(name);
	}

	@GetMapping(path = "/especie/{especie}")
	public @ResponseBody Iterable<MascotasModelo> getMascotasByEspecie(@PathVariable("especie") String especie) {
		return service.findByEspecie(especie);
	}

	@GetMapping(path = "/mezcla/{mezcla}")
	public @ResponseBody Iterable<MascotasModelo> getMascotasByMezcla(@PathVariable("mezcla") String mezcla) {
		return service.findByMezcla(mezcla);
	}

	@GetMapping(path = "/Especie y Mezcla/{especie} y {mezcla}")
	public @ResponseBody Iterable<MascotasModelo> getMascotasByEspeciYMezcla(@PathVariable("especie") String especie,
			@PathVariable("mezcla") String mezcla) {
		return service.findByEspecieAndMezcla(especie, mezcla);
	}

	@GetMapping(path = "/add/") // Map ONLY GET Requests
	@Transactional
	public @ResponseBody MascotasModelo addNewMascota(@RequestParam Integer id, @RequestParam int edad,
			@RequestParam String especie, @RequestParam String mezcla, @RequestParam String name,
			@RequestParam String venta) {

		MascotasModelo mascota = new MascotasModelo();
		mascota.setEdad(edad);
		mascota.setId(id);
		mascota.setEspecie(especie);
		mascota.setName(name);
		mascota.setVenta(venta);
		service.save(mascota);
		return mascota;
	}

	@GetMapping(path = "/borrar/")
	public @ResponseBody String deleteMascota(@RequestParam int id) {
		service.deleteById(id);
		return "mascota deleted";
	}
}