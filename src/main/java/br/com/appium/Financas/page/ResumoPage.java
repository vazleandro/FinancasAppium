package br.com.appium.Financas.page;

import static br.com.appium.Financas.core.DriverFactory.getDrive;

import org.openqa.selenium.By;

import br.com.appium.Financas.core.BasePage;

public class ResumoPage extends BasePage {

	public void ButtonCadastrarFinancas() {

		clicar(By.className("android.widget.ImageButton"));

	}

	public String getTexto(By by) {

		return getDrive().findElement(by).getText();

	}

	public String getTotal() {

		return getDrive().findElement(By.xpath("//*[@resource-id='com.antoni.financask:id/resumo_card_total']"))
				.getText();
	}

}
