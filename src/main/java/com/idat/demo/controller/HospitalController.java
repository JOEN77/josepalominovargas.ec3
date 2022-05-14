package com.idat.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.demo.dto.HospitalRequestDTO;
import com.idat.demo.dto.HospitalResponseDTO;
import com.idat.demo.service.HospitalService;

@RestController
@RequestMapping("/hospital/v2")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<HospitalResponseDTO>>listar(){
		
		return new ResponseEntity<List<HospitalResponseDTO>>(service.listarHospitales(),HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar (@RequestBody HospitalRequestDTO hospital){
		service.guardarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@RequestMapping (method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable Integer id){
		HospitalResponseDTO hospital = service.hospitalById(id);
		if(hospital !=null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody HospitalRequestDTO hospital){
		HospitalResponseDTO hospita = service.hospitalById(hospital.getIdHospital());
		if(hospita !=null) {
			service.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new  ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
