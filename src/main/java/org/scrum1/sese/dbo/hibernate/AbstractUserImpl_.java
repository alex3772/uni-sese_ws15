package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.scrum1.sese.dbo.Gender;

@StaticMetamodel(AbstractUserImpl.class)
public class AbstractUserImpl_ extends AbstractDatabaseObjectID_ {

	public static volatile SingularAttribute<AbstractUserImpl, String> name;
	public static volatile SingularAttribute<AbstractUserImpl, String> surname;
	public static volatile SingularAttribute<AbstractUserImpl, Gender> gender;
	public static volatile SingularAttribute<AbstractUserImpl, LocalDate> birthDate;
	public static volatile SingularAttribute<AbstractUserImpl, String> phone;
	public static volatile SingularAttribute<AbstractUserImpl, String> email;
	public static volatile SingularAttribute<AbstractUserImpl, String> street;
	public static volatile SingularAttribute<AbstractUserImpl, String> city;
	public static volatile SingularAttribute<AbstractUserImpl, String> zipCode;

}
