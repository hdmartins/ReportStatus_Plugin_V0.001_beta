package br.com.app.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.app.bean.TipoDemandaBean;
import br.com.app.businessObject.TipoDemandaBO;

@RunWith(Suite.class)
@SuiteClasses({})
public class TipoDemandaTestSuite 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Informe nome do tipo de demanda : ");
		String nome = in.nextLine();
		
		System.out.println("Informe desc do tipo de demanda : ");
		String desc = in.nextLine();
		
		
		TipoDemandaBean tdb = new TipoDemandaBean();
		
		tdb.setNomeTipoDemanda(nome);
		tdb.setDescTipoDemanda(desc);
		
		
		Assert.assertTrue(insereTipoDemandaTest(tdb));
	}
	
	public static boolean insereTipoDemandaTest(TipoDemandaBean tdb) throws SQLException 
	{
		Assert.assertNotNull(tdb.getNomeTipoDemanda());
		
		Assert.assertNotNull(tdb.getDescTipoDemanda());
		
		TipoDemandaBO b = new TipoDemandaBO();
		
		b.preparaInsertTipoDemanda(tdb);
		
		return true;
		
	}
}
