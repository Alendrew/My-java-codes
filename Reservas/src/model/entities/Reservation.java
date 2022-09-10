package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	public static final DateTimeFormatter DATE_PATTERN_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final LocalDate date = LocalDate.now();
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCheckin(LocalDate checkin) {
		if(checkin.isBefore(date)) {
			throw new DomainException("Check-in date must be equals current date or after current date");
		}
		this.checkin = checkin;
	}

	public void setCheckout(LocalDate checkout) {
		if(checkout.isEqual(checkin) || checkout.isBefore(date)) {
			throw new DomainException("Check-out date must be after current date and check-in date");
		}
		this.checkout = checkout;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public String duration() {
		Long period = getCheckin().until(getCheckout(), ChronoUnit.DAYS);
		StringBuilder sb = new StringBuilder(period.toString() + " nights");
		return sb.toString(); 
	}
	
	public void updateDates(LocalDate checkin,LocalDate checkout) {
		if(checkin.isBefore(date) || checkout.isBefore(date)) {
			throw new DomainException("Reservation dates for update must be future dates"); 
		}
		if(checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Reservation: ");
		sb.append("Room " + roomNumber + ", ");
		sb.append("check-in: " + checkin.format(DATE_PATTERN_BR) + ", ");
		sb.append("check-out: " + checkout.format(DATE_PATTERN_BR) + ", ");
		sb.append(duration());
		return sb.toString();
	}
}
