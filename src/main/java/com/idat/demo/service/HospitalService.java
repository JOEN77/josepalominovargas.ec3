package com.idat.demo.service;

import java.util.List;

import com.idat.demo.dto.HospitalRequestDTO;
import com.idat.demo.dto.HospitalResponseDTO;

public interface HospitalService {
	public void guardarHospital(HospitalRequestDTO p);
	public void eliminarHospital(Integer id);
	public void editarHospital(HospitalRequestDTO p);
	public List<HospitalResponseDTO> listarHospitales();
	public HospitalResponseDTO hospitalById(Integer id);
	
}
