/*
 * ToArrayStringImpl.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ToArrayStringImpl implements ToArrayString {

  @Override
  public String[] of(String linha) {
    String[] res = linha.split(";");
    return res;
  }

}