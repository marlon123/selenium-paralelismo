package br.mg.marlon.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.marlon.core.DriverFactory;
import br.mg.marlon.pages.LoginPage;
import br.mg.marlon.tests.ContaTest;
import br.mg.marlon.tests.MovimentacaoTest;
import br.mg.marlon.tests.RemoverMovimentacaoContaTest;
import br.mg.marlon.tests.ResumoTest;
import br.mg.marlon.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset(){
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		
		
		page.acessarTelaInicial();
		
		page.setEmail("");
		page.setSenha("");
		page.entrar();
		
		page.resetar();
		
		DriverFactory.killDriver();
		
	}
}
