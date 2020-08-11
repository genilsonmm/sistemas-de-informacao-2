package com.Contacts.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Contacts.dto.ContactDTO;
import com.Contacts.model.Contacts;
import com.Contacts.model.Response;
import com.Contacts.repository.ContactRepository;

@CrossOrigin()
@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	private ContactRepository contactRepository;
	private ModelMapper modelMapper;
	
	public ContactController() {
		contactRepository = new ContactRepository();
		modelMapper = new ModelMapper();
	}
	
	@GetMapping()
	public ResponseEntity<Response<List<ContactDTO>>> obtainAll() {
		Response<List<ContactDTO>> response = new Response<List<ContactDTO>>();
		List<ContactDTO> contactsDTO = Arrays.asList(modelMapper.map(contactRepository.getAll(), ContactDTO[].class));
		response.setData(contactsDTO);
		response.setStatus(HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}
	
	@PutMapping()
	public ResponseEntity<Response<ContactDTO>> edit(@RequestBody ContactDTO contactDTO) {
		Response<ContactDTO> response = new Response<ContactDTO>();
		try {
			Contacts contact = modelMapper.map(contactDTO, Contacts.class);
			Contacts updatedContact = contactRepository.edit(contact);
			ContactDTO updatedContactDTO = modelMapper.map(updatedContact, ContactDTO.class);			
			response.setData(updatedContactDTO);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Response<Contacts>> register(@Valid @RequestBody Contacts contact, BindingResult result) {				
		Response<Contacts> response = new Response<Contacts>();
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				String key = String.valueOf(response.getErrors().size() + 1); 
				response.getErrors().put(key, error.getDefaultMessage());
			}
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(response);
		}
		Contacts newContact = new Contacts();
		newContact.setName(contact.getName());
		contactRepository.add(newContact);
		response.setData(newContact);
		response.setStatus(HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable int cpf){
		Response<Integer> response = new Response<Integer>();
		try {
			contactRepository.remove(cpf);
			response.setData(cpf);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.ok(response);
		}
	}
}