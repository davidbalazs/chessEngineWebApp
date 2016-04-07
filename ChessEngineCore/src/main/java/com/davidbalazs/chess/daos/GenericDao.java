package com.davidbalazs.chess.daos;

import java.util.List;

/**
 * Generic DAO interface that has CRUD operations on generic type T.
 * 
 * @author David
 *
 * @param <T>
 *            the generic type that is used for CRUD operations
 */
public interface GenericDao<T> {
	/**
	 * Adds a new T object into database.
	 * 
	 * @param t
	 *            is the object to be added to database.
	 */
	void create(T t);

	/**
	 * Retrieves the object that has the provided id from database.
	 * 
	 * @param id
	 *            id of object to be retrieved from database.
	 * @return the object with provided id.
	 */
	T getById(Long id);

	/**
	 * Updates the object into database. The object need to have a non - null
	 * id, since the object that will be updated is the one which has the id
	 * equal to t's id. The other fields of t object have the new values to be
	 * persisted.
	 * 
	 * @param t
	 *            the object to be updated.
	 */
	void update(T t);

	/**
	 * Deletes the object that has the specified id.
	 * 
	 * @param id
	 *            id of the object to be deleted.
	 */
	void delete(Long id);

	/**
	 * Returns the list of all objects of type T that are in db.
	 * 
	 * @return the list of T objects.
	 */
	List<T> getAll();
}
