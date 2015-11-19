package org.scrum1.sese.dbo.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.scrum1.sese.dbo.DatabaseObjectID;

@MappedSuperclass
public abstract class AbstractDatabaseObjectID implements Serializable, DatabaseObjectID {

	private static final long serialVersionUID = -7900862692775004815L;

	@Id
	@Column(name = "id")
	private Long id;

	/* (non-Javadoc)
	 * @see org.scrum1.sese.dbo.DatabaseObjectID#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Returns a hashcode as int of this object. The calculation
	 * of the hashcode is (hashcode of id) + (hashcode of class).
	 *
	 * @return The hashcode of the object.
	 */
	@Override
	public int hashCode() {
		return this.getId().hashCode() + this.getClass().hashCode();
	}

	/**
	 * Compares this object with another. Two objects are equal, when
	 * they are from the same {@link Class} and they have the same
	 * id.
	 * It is also <code>true</code>, when they are from the same
	 * {@link Class} and both objects are not persisted yet.
	 *
	 * @return <code>true</code>, when objects equal, else <code>false</code>.
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.getClass().equals(obj)) {
			return getId().equals(((DatabaseObjectID) obj).getId());
		} else return false;
	}

}
