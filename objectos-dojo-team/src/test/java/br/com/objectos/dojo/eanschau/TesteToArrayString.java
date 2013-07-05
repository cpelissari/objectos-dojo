/*
 * TesteToArrayString.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteToArrayString {

  private final ToArrayString toArray = new ToArrayStringImpl();

  public void deve_converter_para_array_string() {
    String linha = "mercado xyz;5.5;25/07/2013;VARIAVEL;Mercado";

    String[] linhas = toArray.of(linha);
    List<String> res = ImmutableList.copyOf(linhas);

    assertThat(res.get(0), equalTo("mercado xyz"));
    assertThat(res.get(1), equalTo("5.5"));
    assertThat(res.get(2), equalTo("25/07/2013"));
    assertThat(res.get(3), equalTo("VARIAVEL"));
    assertThat(res.get(4), equalTo("Mercado"));
  }

}