package br.com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.app.bean.CronogramaBean;
import br.com.app.dao.factory.ConnectionFactoryOracle;

public class CronogramaDAO 
{
	private Connection connDB = null;
	private String sql = "";
	private ArrayList<CronogramaBean> lista = null;

	// Realiza inserção de um cronograma de uma demanda na tabela.
	public boolean insereCronograma(CronogramaBean crb) throws SQLException {
		System.out.println("Preparação da query : " + sql.length());
		sql = "insert into CRONOGRAMA (ID_CRONOGRAMA_PK, DATA_INICIO_PREVISTA, DATA_INICIO_REALIZADA) values (CRONOGRAMA_SEQ.nextval,?,?)";

		System.out.println(sql);
		System.out.println("Valores dos campos \n Nome : "
				+ crb.getDataInicioPrevista() + " \n Desc : "
				+ crb.getDataFimPrevista());

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement prepStmt = connDB.prepareStatement(sql);

		prepStmt.setDate(1, crb.getDataInicioPrevista());
		prepStmt.setDate(2, crb.getDataFimPrevista());

		System.out.println("Statement preparado : " + sql);

		boolean statusExecucao = prepStmt.execute();
		System.out.println(statusExecucao);
		return statusExecucao;
	}

	// Realiza a pesquisa por todos os tipos de demanda cadastrados na tabela
	public ArrayList<CronogramaBean> listaCronograma() throws SQLException {

		sql = "SELECT ID_CRONOGRAMA_PK, DATA_INICIO_PREVISTA, DATA_INICIO_REALIZADA, DATA_FIM_PREVISTA, DATA_FIM_PREVISTA FROM CRONOGRAMA ORDER BY ID_CRONOGRAMA_PK ASC";
		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		System.out.println("Executando query " + sql);
		ResultSet set = statement.executeQuery();

		lista = new ArrayList<CronogramaBean>();

		while (set.next()) {
			CronogramaBean crb = new CronogramaBean();

			crb.setIdCronograma(set.getInt(1));
			crb.setDataInicioPrevista(set.getDate(2));
			crb.setDataFimPrevista(set.getDate(3));
			crb.setDataInicioRealizada(set.getDate(4));
			crb.setDataFimRealizada(set.getDate(5));

			lista.add(crb);
		}

		System.out.println("Elementos na lista : " + lista.size());
		return lista;
	}

	// Realiza pesquisa por tipo de demanda pelo nome
	public CronogramaBean pesquisaCronograma(int idCronograma)
			throws SQLException {
		sql = "SELECT ID_CRONOGRAMA_PK, DATA_INICIO_PREVISTA, DATA_INICIO_REALIZADA, DATA_FIM_PREVISTA, DATA_FIM_REALIZADA FROM CRONOGRAMA WHERE ID_CRONOGRAMA_PK = ?";
		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		statement.setInt(1, idCronograma);

		System.out.println("Executando query " + sql);
		ResultSet set = statement.executeQuery();

		CronogramaBean crb = new CronogramaBean();

		if (set.next()) {
			crb.setIdCronograma(set.getInt(1));
			crb.setDataInicioPrevista(set.getDate(2));
			crb.setDataInicioRealizada(set.getDate(3));
			crb.setDataInicioPrevista(set.getDate(4));
			crb.setDataInicioRealizada(set.getDate(5));
		}
		return crb;
	}

//	 Realiza pesquisa por tipo de demanda pelo identificador
//	public CronogramaBean pesquisaCronograma(int idCronograma)
//			throws SQLException {
//		sql = "SELECT ID_TIPO_DEMANDA_PK, NOME_TIPO_DEMANDA, DESC_TIPO_DEMANDA FROM TIPO_DEMANDA WHERE ID_TIPO_DEMANDA = ?";
//		System.out.println("Query Preparada : " + sql);
//
//		connDB = new ConnectionFactoryOracle().getConnection();
//
//		PreparedStatement statement = connDB.prepareStatement(sql);
//
//		statement.setInt(1, idCronograma);
//
//		System.out.println("Executando query " + sql);
//		ResultSet set = statement.executeQuery();
//
//		CronogramaBean tdb = new CronogramaBean();
//
//		if (set.next()) {
//			tdb.setIdCronograma(set.getInt(1));
//			tdb.setNomeCronograma(set.getString(2));
//			tdb.setDescCronograma(set.getString(3));
//		}
//		return tdb;
//	}

	// Realiza atualização dos dados de um tipo de demanda
	public boolean atualizaCronograma(CronogramaBean crb) throws SQLException {

		sql = "UPDATE CRONOGRAMA " + "SET"
				+ "DATA_INICIO_PREVISTA = ?, DATA_INICIO_REALIZADA = ?"
				+ "DATA_FIM_PREVISTA = ?, DATA_FIM_REALIZADA = ?"
				+ "WHERE ID_TIPO_DEMANDA = ?";

		System.out.println("Query Preparada : " + sql);

		connDB = new ConnectionFactoryOracle().getConnection();

		PreparedStatement statement = connDB.prepareStatement(sql);

		statement.setInt(1, crb.getIdCronograma());
		statement.setDate(2, crb.getDataInicioPrevista());
		statement.setDate(3, crb.getDataInicioRealizada());
		statement.setDate(4, crb.getDataFimPrevista());
		statement.setDate(5, crb.getDataFimRealizada());

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