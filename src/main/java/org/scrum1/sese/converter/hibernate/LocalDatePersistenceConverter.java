package org.scrum1.sese.converter.hibernate;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The {@link LocalDatePersistenceConverter} is for hibernate to map {@link LocalDate}
 * to {@link Date}.
 *
 * Only annotate the attribute with <code>@Convert(converter = LocalDatePersistenceConverter.class)</code>
 *
 * @author Thomas Petz
 *
 */
@Converter
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		if(localDate != null) {
			return Date.valueOf(localDate);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public LocalDate convertToEntityAttribute(Date dbDate) {
		if(dbDate != null) {
			return dbDate.toLocalDate();
		}
		return null;
	}

}
