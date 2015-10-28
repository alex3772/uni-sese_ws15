package org.scrum1.sese.converter.hibernate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The {@link LocalDateTimePersistenceConverter} is for hibernate to map {@link LocalDateTime}
 * to {@link Timestamp}.
 *
 * Only annotate the attribute with <code>@Convert(converter = LocalDateTimePersistenceConverter.class)</code>
 *
 * @author Thomas Petz
 *
 */
@Converter
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		if(localDateTime != null) {
			return Timestamp.valueOf(localDateTime);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbTimestamp) {
		if(dbTimestamp != null) {
			return dbTimestamp.toLocalDateTime();
		}
		return null;
	}

}
