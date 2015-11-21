package org.scrum1.sese.dbo.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Defect;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;

@Entity(name = "room")
@Table(name = "room")
@Access(AccessType.FIELD)
public class RoomImpl extends AbstractDatabaseObjectID implements Room {

	private static final long serialVersionUID = -1203556222992423224L;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "maxpersons", nullable = false)
	private Integer maxPersons;

	@Column(name = "price_sr", nullable = true)
	private Double priceSR;

	@Column(name = "price_dr", nullable = true)
	private Double priceDR;

	@Column(name = "price_tr", nullable = true)
	private Double priceTR;

	@Column(name = "price_sr_one_child", nullable = true)
	private Double priceSROneChild;

	@Column(name = "price_sr_two_children", nullable = true)
	private Double priceSRTwoChildren;

	@Column(name = "price_dr_one_child", nullable = true)
	private Double priceDROneChild;

	@OneToMany(mappedBy = "room", targetEntity = ReservationImpl.class)
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "room", targetEntity = DefectImpl.class)
	private List<Defect> defects;


	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getMaxPersons() {
		return this.maxPersons;
	}

	@Override
	public void setMaxPersons(Integer maxPersons) {
		this.maxPersons = maxPersons;
	}

	@Override
	public Double getPriceSR() {
		return this.getPriceSR();
	}

	@Override
	public void setPriceSR(Double price) {
		this.priceSR = price;
	}

	@Override
	public Double getPriceDR() {
		return this.getPriceDR();
	}

	@Override
	public void setPriceDR(Double price) {
		this.priceDR = price;
	}

	@Override
	public Double getPriceTR() {
		return this.priceTR;
	}

	@Override
	public void setPriceTR(Double price) {
		this.priceTR = price;
	}

	@Override
	public Double getPriceSROneChild() {
		return this.priceSROneChild;
	}

	@Override
	public void setPriceSROneChild(Double price) {
		this.priceSROneChild = price;
	}

	@Override
	public Double getPriceSRTwoChildren() {
		return this.priceSRTwoChildren;
	}

	@Override
	public void setPriceSRTwoChildren(Double price) {
		this.priceSRTwoChildren = price;
	}

	@Override
	public Double getPriceDROneChild() {
		return this.priceDROneChild;
	}

	@Override
	public void setPriceDROneChild(Double price) {
		this.priceDROneChild = price;
	}

	@Override
	public List<Reservation> getReservations() {
		if(reservations == null) {
			this.reservations = new ArrayList<>();
		}
		return this.reservations;
	}

	@Override
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void addReservation(Reservation reservation) {
		getReservations().add(reservation);
	}

	@Override
	public void removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
	}

	@Override
	public List<Defect> getDefects() {
		if(defects == null) {
			this.defects = new ArrayList<>();
		}
		return this.defects;
	}

	@Override
	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}

	@Override
	public void addDefect(Defect defect) {
		getDefects().add(defect);
	}

	@Override
	public void removeDefect(Defect defect) {
		getDefects().remove(defect);
	}

}
