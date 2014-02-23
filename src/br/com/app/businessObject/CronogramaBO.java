package br.com.app.businessObject;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.app.bean.CronogramaBean;
import br.com.app.bean.TipoDemandaBean;
import br.com.app.dao.TipoDemandaDAO;

public class CronogramaBO 
{
	private ArrayList<CronogramaBean> lista = null ;
	
	public boolean preparaInsertCronograma(CronogramaBean crb)
			throws SQLException {
		System.out
		.println("Verificando se a data do início dos testes é pelo menos maior ou igual ao dia corrente.");
		if ((crb.getDataInicioPrevista() )
				|| (crb.getDescTipoDemanda().length() == 0)) {
			System.out.println("Erro : Nome ou tamanho inválidos. Nome : "
					+ crb.getNomeTipoDemanda() + " | Desc : "
					+ crb.getDescTipoDemanda());
			return false;
		} else {
			TipoDemandaDAO d = new TipoDemandaDAO();
			System.out.println("Sucesso na validação de tamanho.");
			return d.insereTipoDemanda(crb);
		}
	}

}
