package org.scrum1.sese.dbo.hibernate;

import java.util.List;

import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CustomerImpl.class)
public class CustomerImpl_ extends AbstractUserImpl_ {

	public static volatile SingularAttribute<CustomerImpl, String> username;
	public static volatile SingularAttribute<CustomerImpl, String> password;
	public static volatile SingularAttribute<CustomerImpl, String> companyName;
	public static volatile SingularAttribute<CustomerImpl, String> fax;
	public static volatile SingularAttribute<CustomerImpl, String> web;
	public static volatile SingularAttribute<CustomerImpl, String> note;
	public static volatile SingularAttribute<CustomerImpl, Integer> discount;
	public static volatile PluralAttribute<CustomerImpl, List<ReservationImpl>, ReservationImpl> reservations;

}
