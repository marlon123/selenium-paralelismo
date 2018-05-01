package br.mg.marlon.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.marlon.core.BaseTest;
import br.mg.marlon.pages.HomePage;
import br.mg.marlon.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
