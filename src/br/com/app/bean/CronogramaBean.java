package br.com.app.bean;

import java.sql.Date;

public class CronogramaBean 
{
	private int 	idCronograma;
	private Date	dataInicioPrevista;
	private Date	dataInicioRealizada;
	private Date	dataFimPrevista;
	private Date	dataFimRealizada;

	public int getIdCronograma() {
		return idCronograma;
	}
	public void setIdCronograma(int idCronograma) {
		this.idCronograma = idCronograma;
	}
	public Date getDataInicioPrevista() {
		return dataInicioPrevista;
	}
	public void setDataInicioPrevista(Date dataInicioPrevista) {
		this.dataInicioPrevista = dataInicioPrevista;
	}
	public Date getDataInicioRealizada() {
		return dataInicioRealizada;
	}
	public void setDataInicioRealizada(Date dataInicioRealizada) {
		this.dataInicioRealizada = dataInicioRealizada;
	}
	public Date getDataFimPrevista() {
		return dataFimPrevista;
	}
	public void setDataFimPrevista(Date dataFimPrevista) {
		this.dataFimPrevista = dataFimPrevista;
	}
	public Date getDataFimRealizada() {
		return dataFimRealizada;
	}
	public void setDataFimRealizada(Date dataFimRealizada) {
		this.dataFimRealizada = dataFimRealizada;
	}
	
	
}
