package br.com.app.businessObject;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.app.bean.TipoDemandaBean;
import br.com.app.dao.TipoDemandaDAO;

public class TipoDemandaBO {
	private ArrayList<TipoDemandaBean> lista = null;

	public boolean preparaInsertTipoDemanda(TipoDemandaBean t)
			throws SQLException {
		System.out
		.println("Verificação do tamanho dos valores dos campos NOME e DESC.");
		if ((t.getNomeTipoDemanda().length() == 0)
				|| (t.getDescTipoDemanda().length() == 0)) {
			System.out.println("Erro : Nome ou tamanho inválidos. Nome : "
					+ t.getNomeTipoDemanda() + " | Desc : "
					+ t.getDescTipoDemanda());
			return false;
		} else {
			TipoDemandaDAO d = new TipoDemandaDAO();
			System.out.println("Sucesso na validação de tamanho.");
			return d.insereTipoDemanda(t);
		}
	}

	public ArrayList<TipoDemandaBean> preparaListTipoDemanda()
			throws SQLException 
	{
		System.out.println("Invocando listagem de tipos de demandas : ");

		TipoDemandaDAO d = new TipoDemandaDAO();
		
		lista = d.listaTipoDemanda();
		
		return lista ;
	}

	public TipoDemandaBean pesquisaTipoDemanda(String nomeTipoDemanda) throws SQLException 
	{
		System.out.println("Pesquisa tipo demanda por nome parecido com "+nomeTipoDemanda);
		
		TipoDemandaDAO d = new TipoDemandaDAO();
		
		TipoDemandaBean tdb = d.pesquisaTipoDemanda(nomeTipoDemanda);
		
		return tdb;
		
	}

	public TipoDemandaBean pesquisaTipoDemandaBean(int idTipoDemanda) throws SQLException 
	{
		
System.out.println("Pesquisa tipo demanda por nome parecido com "+idTipoDemanda);
		
		TipoDemandaDAO d = new TipoDemandaDAO();
		
		TipoDemandaBean tdb = d.pesquisaTipoDemanda(idTipoDemanda);
		
		return tdb;
		
	}
}