package br.com.app.bean;

public class DemandaBean 
{
	private int 			idDemanda			;
	private int 			numDemanda			;
	private String 			nomeDemanda			;
	private TipoDemandaBean tipoDemanda 		;
	private String			descDemanda			;
	private CronogramaBean	cronogramaDemanda 	;

	public int getIdDemanda() {
		return idDemanda;
	}
	public void setIdDemanda(int idDemanda) {
		this.idDemanda = idDemanda;
	}
	public int getNumDemanda() {
		return numDemanda;
	}
	public void setNumDemanda(int numDemanda) {
		this.numDemanda = numDemanda;
	}
	public String getNomeDemanda() {
		return nomeDemanda;
	}
	public void setNomeDemanda(String nomeDemanda) {
		this.nomeDemanda = nomeDemanda;
	}
	public TipoDemandaBean getTipoDemanda() {
		return tipoDemanda;
	}
	public void setTipoDemanda(TipoDemandaBean tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}
	public String getDescDemanda() {
		return descDemanda;
	}
	public void setDescDemanda(String descDemanda) {
		this.descDemanda = descDemanda;
	}
	public CronogramaBean getCronogramaDemanda() {
		return cronogramaDemanda;
	}
	public void setCronogramaDemanda(CronogramaBean cronogramaDemanda) {
		this.cronogramaDemanda = cronogramaDemanda;
	}	
}