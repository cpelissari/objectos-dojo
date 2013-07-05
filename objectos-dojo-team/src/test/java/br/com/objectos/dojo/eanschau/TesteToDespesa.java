/*
 * TesteToDespesa.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteToDespesa {

  private final ToDespesa desp = new ToDespesaImpl();

  public void deve_gerar_despesa() {
    String[] entrada = { "mercado xyz", "5.5", "25/07/2013", "VARIAVEL", "Mercado" };

    Despesa res = desp.of(entrada);

    assertThat(res.getDescricao(), equalTo("mercado xyz"));
    assertThat(res.getValor(), equalTo(5.5d));
    assertThat(res.getData(), equalTo(new LocalDate(2013, 7, 25)));
    assertThat(res.getTipo(), equalTo(PeriodicidadeTipo.VARIAVEL));
    assertThat(res.getCategoria().getNome(), equalTo("Mercado"));
  }

}