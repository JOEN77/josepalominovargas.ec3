package com.idat.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.demo.dto.ClienteRequestDTO;
import com.idat.demo.dto.ClienteResponseDTO;
import com.idat.demo.model.Cliente;
import com.idat.demo.service.ClienteService;


@RestController
@RequestMapping("/cliente/v2")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@RequestMapping (method = RequestMethod.GET, path = "/listarcliente")
	public ResponseEntity<List<ClienteResponseDTO>>listar(){
		return new ResponseEntity<List<ClienteResponseDTO>>(service.listarCliente(),HttpStatus.OK);
		
	}
	@RequestMapping (method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar (@RequestBody ClienteRequestDTO cliente){
		service.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path ="/editar")
	public ResponseEntity <Void> editar (@RequestBody ClienteRequestDTO cliente){
		ClienteResponseDTO client = service.clienteById(cliente.getIdcliente());
		if(client !=null) {
			service.editar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
    	
	
	
	@RequestMapping (method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar (@PathVariable Integer id){
		ClienteResponseDTO paciente = service.clienteById(id);
		if(paciente != null ) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	 
}
