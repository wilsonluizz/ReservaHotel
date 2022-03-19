package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroquarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroquarto, Date checkIn, Date checkOut ) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException( "Erro na reserva: Data de check-Out precisa ser posterior a de Check-In");
		}
		this.numeroquarto = numeroquarto;
		this.checkIn = checkIn ;
		this.checkOut = checkOut;
	}
	public Integer getNumeroquarto() {
		return numeroquarto;
	}
	public void setNumeroquarto(Integer numeroquarto) {
		this.numeroquarto = numeroquarto;
	}
	public Date getChekIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Erro na reserva: Datas da reserva para atualização precisam ser futuras. ");
		}
		 if (!checkOut.after(checkIn)) {
			throw new DomainException( "Erro na reserva: Data de check-Out precisa ser posterior a de Check-In");
		}
		this.checkIn = checkin;
		this.checkOut = checkout;
		
	}
	
	@Override
	public String toString() {
		return " Numero do quarto: " + numeroquarto + " CheckIn: " + sdf.format(checkIn) +
				" CheckOut " + sdf.format(checkOut)+ " " + duracao() + " noites ";
	}
	
	
	
	

}
