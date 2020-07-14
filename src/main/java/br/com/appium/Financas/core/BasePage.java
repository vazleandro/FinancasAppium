package br.com.appium.Financas.core;

import static br.com.appium.Financas.core.DriverFactory.getDrive;

import org.openqa.selenium.By;

public class BasePage {

	public void clicar(By by) {

		getDrive().findElement(by).click();

	}

	public void clicarPorTexto(String texto) {

		clicar(By.xpath("//*[@text='" + texto + "']"));

	}

	public void escrever(By by, String texto) {

		getDrive().findElement(by).sendKeys(texto);
	}
}
