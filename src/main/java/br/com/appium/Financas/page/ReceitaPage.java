package br.com.appium.Financas.page;

import org.openqa.selenium.By;

import br.com.appium.Financas.core.BasePage;

public class ReceitaPage extends BasePage {
	
	public void acessarReceita(String texto) {
		clicarPorTexto(texto);
	}

	public void informarValor(String valor) {

		escrever(By.xpath("//*[@resource-id='com.antoni.financask:id/form_transacao_valor']"), valor);
	}

	public void informarData(String dia) {

		escrever(By.xpath("//*[@resource-id='com.antoni.financask:id/form_transacao_data']"), dia);
	}

	public void selecionarCategoria(String categoria) {

		clicar(By.xpath("//*[@resource-id='com.antoni.financask:id/form_transacao_categoria']"));
		clicarPorTexto(categoria);
	}


}
