package br.com.app.businessObject;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.app.bean.CronogramaBean;

public class CronogramaBO 
{
	private ArrayList<CronogramaBean> lista = null ;
	
	public boolean preparaInsertCronograma(CronogramaBean crb)
			throws Throwable {
		System.out
		.println("Verificando se a data do in�cio dos testes � pelo menos maior ou igual ao dia corrente.");

//		verificar se a data in�cio prevista ou se a data fim prevista  est� vazia
		if (crb.getDataInicioPrevista() == null)
		{
			throw new Throwable("Campo Data in�cio Prevista n�o pode ser nulo.");
		}
		if (crb.getDataInicioPrevista() == null)
		{
			throw new Throwable("Campo Data Fim Prevista n�o pode ser nulo.");
		}
//		verificar se a data de inicio previsto � menor ou igual ao dia corrente
		if(crb.getDataInicioPrevista().toString().equals(String.valueOf(Calendar.DAY_OF_YEAR)))
		{
			
		}
//		verificar se a data de fim previsto � menor ou igual ao dia corrente e maior ou igual a data de inicio previsto
//		verificar se a data de inicio realizada est� vazia
//		verificar se a data de fim realizada est� vazia
		
		return false;
	}

}
