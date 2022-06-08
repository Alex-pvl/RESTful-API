package ru.alexpvl.restspringboot.service;

import ru.alexpvl.restspringboot.model.Client;

import java.util.List;

public interface ClientService {
	/**
	 * Создает нового клиента
	 * @param client - клиент для создания
	 */
	void create(Client client);

	/**
	 * Получение списка всех клиентов
	 * @return список всех клиентов
	 */
	List<Client> getAll();

	/**
	 * Получение клиента по ID
	 * @param id - ID клиента
	 * @return экземпляр клиента
	 */
	Client get(Integer id);

	/**
	 * Обновить объект клиента по ID
	 * @param client - обновляемый клиент
	 * @param id - ID обновляемого клиента
	 * @return true - успешное обновление, иначе false
	 */
	boolean update(Client client, Integer id);

	/**
	 * Удалить клиента по ID
	 * @param id - ID удаляемого клиента
	 * @return true - успешное удаление, иначе - false
	 */
	boolean delete(Integer id);
}
