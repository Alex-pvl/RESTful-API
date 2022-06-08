package ru.alexpvl.restspringboot.service;

import org.springframework.stereotype.Service;
import ru.alexpvl.restspringboot.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {
	// хранилище клиентов
	private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

	// генератор ID
	private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

	@Override
	public void create(Client client) {
		final int clientId = CLIENT_ID_HOLDER.getAndIncrement();
		client.setId(clientId);
		CLIENT_REPOSITORY_MAP.put(clientId, client);
	}

	@Override
	public List<Client> getAll() {
		return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
	}

	@Override
	public Client get(Integer id) {
		return CLIENT_REPOSITORY_MAP.get(id);
	}

	@Override
	public boolean update(Client client, Integer id) {
		if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
			client.setId(id);
			CLIENT_REPOSITORY_MAP.put(id, client);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return CLIENT_REPOSITORY_MAP.remove(id) != null;
	}
}
