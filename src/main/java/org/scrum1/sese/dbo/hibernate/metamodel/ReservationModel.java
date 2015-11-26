package org.scrum1.sese.dbo.hibernate.metamodel;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Invoice;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;

@StaticMetamodel(ReservationImpl.class)
public class ReservationModel {

	public static volatile SingularAttribute<ReservationImpl, Long> id;
	public static volatile SingularAttribute<ReservationImpl, Customer> customer;
	public static volatile SingularAttribute<ReservationImpl, Room> room;
	public static volatile SingularAttribute<ReservationImpl, LocalDate> checkin;
	public static volatile SingularAttribute<ReservationImpl, LocalDate> checkout;
	public static volatile SingularAttribute<ReservationImpl, Integer> discount;
	public static volatile SingularAttribute<ReservationImpl, Invoice> invoice;

}
