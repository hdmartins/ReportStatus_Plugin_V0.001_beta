package br.com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.app.bean.TipoDemandaBean;
import br.com.app.dao.factory.ConnectionFactoryOracle;

public class TipoDemandaDAO {
	private Connection connDB = null;
	private String sql = "";
	private ArrayList<TipoDemandaBean> lista = null;

	// Realiza inserção de um tipo de demanda na tabela.
	public boolean insereTipoDemanda(TipoDemandaBean t) throws SQLException {
		System.out.println("Preparação da query : " + sql.length());
		sql = "insert into TIPO_DEMANDA (ID_TIPO_DEMANDA_PK, NOME_TIPO_DEMANDA, DESC_TIPO_DEMANDA) values(TIPO_DEMANDA_SEQ.nextval,?,?)";

		System.out.println(sql);
		System.out.println("Valores dos campos \n Nome : "
				+ t.getNomeTipoDemanda() + " \n Desc : "
				+ t.getDescTipoDemanda());

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement prepStmt = connDB.prepareStatement(sql);

		prepStmt.setString(1, t.getNomeTipoDemanda());
		prepStmt.setString(2, t.getDescTipoDemanda());

		System.out.println("Statement preparado : " + sql);

		boolean statusExecucao = prepStmt.execute();
		System.out.println(statusExecucao);
		return statusExecucao;
	}

	// Realiza a pesquisa por todos os tipos de demanda cadastrados na tabela
	public ArrayList<TipoDemandaBean> listaTipoDemanda() throws SQLException {

		sql = "SELECT ID_TIPO_DEMANDA_PK, NOME_TIPO_DEMANDA, DESC_TIPO_DEMANDA FROM TIPO_DEMANDA ORDER BY ID_TIPO_DEMANDA_PK ASC";
		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		System.out.println("Executando query " + sql);
		ResultSet set = statement.executeQuery();

		lista = new ArrayList<TipoDemandaBean>();

		while (set.next()) {
			TipoDemandaBean tdb = new TipoDemandaBean();

			tdb.setIdTipoDemanda(set.getInt(1));
			tdb.setNomeTipoDemanda(set.getString(2));
			tdb.setDescTipoDemanda(set.getString(3));

			lista.add(tdb);
		}

		System.out.println("Elementos na lista : " + lista.size());
		return lista;
	}

	// Realiza pesquisa por tipo de demanda pelo nome
	public TipoDemandaBean pesquisaTipoDemanda(String nomeTipoDemanda)
			throws SQLException {
		sql = "SELECT ID_TIPO_DEMANDA_PK, NOME_TIPO_DEMANDA, DESC_TIPO_DEMANDA FROM TIPO_DEMANDA WHERE NOME_TIPO_DEMANDA LIKE %?%";
		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		statement.setString(1, nomeTipoDemanda);

		System.out.println("Executando query " + sql);
		ResultSet set = statement.executeQuery();

		TipoDemandaBean tdb = new TipoDemandaBean();

		if (set.next()) {
			tdb.setIdTipoDemanda(set.getInt(1));
			tdb.setNomeTipoDemanda(set.getString(2));
			tdb.setDescTipoDemanda(set.getString(3));
		}
		return tdb;
	}

	// Realiza pesquisa por tipo de demanda pelo identificador
	public TipoDemandaBean pesquisaTipoDemanda(int idTipoDemanda)
			throws SQLException {
		sql = "SELECT ID_TIPO_DEMANDA_PK, NOME_TIPO_DEMANDA, DESC_TIPO_DEMANDA FROM TIPO_DEMANDA WHERE ID_TIPO_DEMANDA = ?";
		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		statement.setInt(1, idTipoDemanda);

		System.out.println("Executando query " + sql);
		ResultSet set = statement.executeQuery();

		TipoDemandaBean tdb = new TipoDemandaBean();

		if (set.next()) {
			tdb.setIdTipoDemanda(set.getInt(1));
			tdb.setNomeTipoDemanda(set.getString(2));
			tdb.setDescTipoDemanda(set.getString(3));
		}
		return tdb;
	}

	// Realiza atualização dos dados de um tipo de demanda
	public boolean atualizaTipoDemanda(TipoDemandaBean tdb) throws SQLException {

		sql = "UPDATE TIPO_DEMANDA " + "SET"
				+ "NOME_TIPO_DEMANDA = ?, DESC_TIPO_DEMANDA = ?"
				+ "WHERE ID_TIPO_DEMANDA = ?";

		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		statement.setString(1, tdb.getNomeTipoDemanda());
		statement.setString(2, tdb.getDescTipoDemanda());
		statement.setInt(3, tdb.getIdTipoDemanda());

		System.out.println("Executando query " + sql);
		// ResultSet set = statement.executeQuery();
		int i = statement.executeUpdate();

		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}
	// Realiza a remoçao de um tipo de demanda doa tabela pelo identificador
	// Não implementado. Ainad serã decidido como realizar essa operação
}