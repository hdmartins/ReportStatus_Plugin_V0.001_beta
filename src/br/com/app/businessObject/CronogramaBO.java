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
		.println("Verificando se a data do início dos testes é pelo menos maior ou igual ao dia corrente.");

//		verificar se a data início prevista ou se a data fim prevista  está vazia
		if (crb.getDataInicioPrevista() == null)
		{
			throw new Throwable("Campo Data início Prevista não pode ser nulo.");
		}
		if (crb.getDataInicioPrevista() == null)
		{
			throw new Throwable("Campo Data Fim Prevista não pode ser nulo.");
		}
//		verificar se a data de inicio previsto é menor ou igual ao dia corrente
		if(crb.getDataInicioPrevista().toString().equals(String.valueOf(Calendar.DAY_OF_YEAR)))
		{
			
		}
//		verificar se a data de fim previsto é menor ou igual ao dia corrente e maior ou igual a data de inicio previsto
//		verificar se a data de inicio realizada está vazia
//		verificar se a data de fim realizada está vazia
		
		return false;
	}

}
