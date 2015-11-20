package org.scrum1.sese.dbo;


/**
 * The interface {@link DatabaseObject} represents java pojo's
 * for database persistence.
 *
 * @author Thomas Petz
 *
 */
public interface DatabaseObject {

	/**
	 * Indicates if the object is persisted in the
	 * database or not.
	 *
	 * @return <code>true</code>, when object is persisted,
	 * 		   else <code>false</code>.
	 */
	public boolean isPersisted();

}
