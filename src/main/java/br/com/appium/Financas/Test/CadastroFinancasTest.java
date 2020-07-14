package br.com.appium.Financas.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import br.com.appium.Financas.core.DriverFactory;
import br.com.appium.Financas.page.DespesaPage;
import br.com.appium.Financas.page.ReceitaPage;
import br.com.appium.Financas.page.ResumoPage;

public class CadastroFinancasTest {
	
	@After
	public void encerraAppium() {

		DriverFactory.killDriver();
	}

	ResumoPage resumo = new ResumoPage();
	DespesaPage despesa = new DespesaPage();
	ReceitaPage receita = new ReceitaPage();

	@Test
	public void cadastrarDespesas() {

		resumo.ButtonCadastrarFinancas();

		despesa.acessarDespesas("Adiciona despesa");
		despesa.informarValor("123.76");
		despesa.informarData("09/07/2020");
		despesa.selecionarCategoria("Comunicações");
		despesa.clicarPorTexto("ADICIONAR");

		assertEquals("Comunicações",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_categoria']")));
		assertEquals("R$  123,76",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_valor']")));
		assertEquals("09/07/2020",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_data']")));

	}

	@Test
	public void cadastrarReceitas() {

		resumo.ButtonCadastrarFinancas();

		receita.acessarReceita("Adiciona receita");
		receita.informarValor("1500.76");
		receita.informarData("11/07/2020");
		receita.selecionarCategoria("Salário");
		receita.clicarPorTexto("ADICIONAR");

		assertEquals("Salário",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_categoria']")));
		assertEquals("R$  1.500,76",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_valor']")));
		assertEquals("11/07/2020",
				resumo.getTexto(By.xpath("//*[@resource-id='com.antoni.financask:id/transacao_data']")));

	}

	@Test
	public void validarTotalDespesaReceita() {

		resumo.ButtonCadastrarFinancas();

		despesa.acessarDespesas("Adiciona despesa");
		despesa.informarValor("123.76");
		despesa.informarData("09/07/2020");
		despesa.selecionarCategoria("Comunicações");
		despesa.clicarPorTexto("ADICIONAR");

		resumo.ButtonCadastrarFinancas();

		receita.acessarReceita("Adiciona receita");
		receita.informarValor("1500.76");
		receita.informarData("11/07/2020");
		receita.selecionarCategoria("Salário");
		receita.clicarPorTexto("ADICIONAR");

		assertEquals("R$  1.377,00", resumo.getTotal());
	}

}
