package br.com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.app.bean.DemandaBean;
import br.com.app.bean.TipoDemandaBean;
import br.com.app.dao.factory.ConnectionFactoryOracle;

public class DemandaDAO 
{
	private Connection connDB = null;
	private String sql = "";
	private ArrayList<TipoDemandaBean> lista = null;
	
	/*
	 * Implementar a inserção dos dados de uma demanda com cronograma e com tipo de demanda utilizando os tipos definidos para o projeto. 
	 * */
	public boolean insereDemanda(DemandaBean d) throws SQLException {
		System.out.println("Preparação da query : " + sql.length());
		sql = "insert into DEMANDA (ID_DEMANDA_PK, NUM_DEMANDA, NOME_DEMANDA, DESC_DEMANDA, ID_TIPO_DEMANDA_FK, ID_CRONOGRAMA_FK) values(TIPO_DEMANDA_SEQ.nextval,?,?,?,?)";

		System.out.println(sql);
		System.out.println("Valores dos campos \n Nome : "
				+ d.getNomeDemanda() + " \n Desc : "
				+ d.getDescDemanda());

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement prepStmt = connDB.prepareStatement(sql);

		prepStmt.setInt		(1, d.getNumDemanda());
		prepStmt.setString	(2, d.getNomeDemanda());
		prepStmt.setString	(3, d.getDescDemanda());
		prepStmt.setInt		(4, d.getTipoDemanda().getIdTipoDemanda());
		prepStmt.setInt		(5, d.getCronogramaDemanda().getIdCronograma());

		System.out.println("Statement preparado : " + sql);

		boolean statusExecucao = prepStmt.execute();
		System.out.println(statusExecucao);
		return statusExecucao;
	}
}
