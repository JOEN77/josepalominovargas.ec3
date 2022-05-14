package com.idat.demo.service;

import java.util.List;

import com.idat.demo.dto.ClienteRequestDTO;
import com.idat.demo.dto.ClienteResponseDTO;

public interface ClienteService {

	public void guardarCliente(ClienteRequestDTO p);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO p);
	public List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);
	public void editar(ClienteRequestDTO cliente);
}
