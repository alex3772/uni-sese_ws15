package org.scrum1.sese.dbo;

/**
 * The interface {@link DatabaseObjectID} is for java pojo's
 * with generated primary key.
 *
 * @author Thomas Petz
 *
 */
public interface DatabaseObjectID extends DatabaseObject {

	/**
	 * The database id as {@link Long}. This id is also the primary key
	 * of the database. If {@link DatabaseObjectID} is not persisted the
	 * id is <code>null</code>.
	 *
	 * @return The id as {@link Long} or <code>null</code>.
	 */
	public Long getId();

}
