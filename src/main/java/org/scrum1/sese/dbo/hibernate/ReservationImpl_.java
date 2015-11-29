package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ReservationImpl.class)
public class ReservationImpl_ extends AbstractDatabaseObjectID_ {

	public static volatile SingularAttribute<ReservationImpl, CustomerImpl> customer;
	public static volatile SingularAttribute<ReservationImpl, RoomImpl> room;
	public static volatile SingularAttribute<ReservationImpl, LocalDate> checkin;
	public static volatile SingularAttribute<ReservationImpl, LocalDate> checkout;
	public static volatile SingularAttribute<ReservationImpl, Integer> discount;
	public static volatile SingularAttribute<ReservationImpl, InvoiceImpl> invoice;

}
