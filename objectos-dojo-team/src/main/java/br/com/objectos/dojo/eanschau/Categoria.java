/*
 * Categoria.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public interface Categoria {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Categoria> {

    String getNome();
  }

  String getNome();

}