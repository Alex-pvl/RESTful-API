package ru.alexpvl.restspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexpvl.restspringboot.model.Client;
import ru.alexpvl.restspringboot.service.ClientService;

import java.util.List;

@RestController
public class ClientController {
	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping(value = "/clients")
	public ResponseEntity<?> create(@RequestBody Client client) {
		clientService.create(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/clients")
	public ResponseEntity<List<Client>> read(){
		final List<Client> clients = clientService.getAll();
		return clients != null && !clients.isEmpty()
				? new ResponseEntity<>(clients, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/clients/{id}")
	public ResponseEntity<Client> read(@PathVariable(name = "id") Integer id) {
		final Client client = clientService.get(id);
		return client != null
				? new ResponseEntity<>(client, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/clients/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestParam Client client) {
		final boolean updated = clientService.update(client, id);
		return updated
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping(value = "/clients/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
		final boolean deleted = clientService.delete(id);
		return deleted
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
}
