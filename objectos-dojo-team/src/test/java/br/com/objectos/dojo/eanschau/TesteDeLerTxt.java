/*
 * TesteDeLerTxt.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeLerTxt {

  private final LerTxt lerTxt = new LerTxtImpl();

  public void deve_ler_txt() throws IOException, URISyntaxException {
    File file = TxtsFalso.getFile("/despesa/despesa_test.txt");

    String txt = lerTxt.of(file);

    String sep = System.getProperty("line.separator");
    String[] arr = txt.split(sep);

    List<String> res = ImmutableList.copyOf(arr);

    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("Teste; /"));
    assertThat(res.get(1), equalTo("operação txt txt"));
    assertThat(res.get(2), equalTo("/ é ó ;"));
  }

}