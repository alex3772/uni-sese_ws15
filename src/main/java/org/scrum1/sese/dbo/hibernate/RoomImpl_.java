package org.scrum1.sese.dbo.hibernate;

import java.util.List;

import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.scrum1.sese.dbo.Reservation;

@StaticMetamodel(RoomImpl.class)
public class RoomImpl_ extends AbstractDatabaseObjectID_ {

	public static volatile SingularAttribute<RoomImpl, String> name;
	public static volatile SingularAttribute<RoomImpl, Integer> maxPersons;
	public static volatile SingularAttribute<RoomImpl, Double> priceSR;
	public static volatile SingularAttribute<RoomImpl, Double> priceDR;
	public static volatile SingularAttribute<RoomImpl, Double> priceTR;
	public static volatile SingularAttribute<RoomImpl, Double> priceSROneChild;
	public static volatile SingularAttribute<RoomImpl, Double> priceSRTwoChildren;
	public static volatile SingularAttribute<RoomImpl, Double> priceDROneChild;
	public static volatile PluralAttribute<RoomImpl, List<Reservation>, ReservationImpl> reservations;
	public static volatile PluralAttribute<RoomImpl, List<DefectImpl>, DefectImpl> defects;

}
