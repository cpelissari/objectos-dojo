/*
 * ToArrayStringImpl.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ToArrayStringImpl implements ToArrayString {

  @Override
  public String[] of(String linha) {
    String[] res = linha.split(";");
    return res;
  }

  @Override
  public Iterator<String[]> transform(Iterator<String> linhas) {
    return Iterators.transform(linhas, new ToImpl());
  }

  private class ToImpl implements Function<String, String[]> {
    @Override
    public String[] apply(String input) {
      return of(input);
    }
  }

}