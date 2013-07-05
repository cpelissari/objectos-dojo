/*
 * TesteDeTxtIteratorGen.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeTxtIteratorGen {

  private final TxtIteratorGen gen = new TxtIteratorGenImpl();

  public void deve_iterar_txt() throws URISyntaxException {
    File file = TxtsFalso.getFile("/despesa/despesa_test.txt");

    TxtIterator res = gen.gerarDe(file);

    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.next(), equalTo("Teste; /"));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.next(), equalTo("operação txt txt"));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.hasNext(), equalTo(true));
    assertThat(res.next(), equalTo("/ é ó ;"));
    assertThat(res.hasNext(), equalTo(false));
    assertThat(res.hasNext(), equalTo(false));
    assertThat(res.hasNext(), equalTo(false));
  }

}