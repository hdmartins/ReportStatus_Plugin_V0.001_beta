package br.com.app.bean;

import java.util.Calendar;

public class CronogramaBean 
{
	private int 		idCronograma;
	private Calendar	dataInicioPrevista;
	private Calendar	dataInicioRealizada;
	private Calendar	dataFimPrevista;
	private Calendar	dataFimRealizada;

	public int getIdCronograma() {
		return idCronograma;
	}
	public void setIdCronograma(int idCronograma) {
		this.idCronograma = idCronograma;
	}
	public Calendar getDataInicioPrevista() {
		return dataInicioPrevista;
	}
	public void setDataInicioPrevista(Calendar dataInicioPrevista) {
		this.dataInicioPrevista = dataInicioPrevista;
	}
	public Calendar getDataInicioRealizada() {
		return dataInicioRealizada;
	}
	public void setDataInicioRealizada(Calendar dataInicioRealizada) {
		this.dataInicioRealizada = dataInicioRealizada;
	}
	public Calendar getDataFimPrevista() {
		return dataFimPrevista;
	}
	public void setDataFimPrevista(Calendar dataFimPrevista) {
		this.dataFimPrevista = dataFimPrevista;
	}
	public Calendar getDataFimRealizada() {
		return dataFimRealizada;
	}
	public void setDataFimRealizada(Calendar dataFimRealizada) {
		this.dataFimRealizada = dataFimRealizada;
	}
	
	
}
