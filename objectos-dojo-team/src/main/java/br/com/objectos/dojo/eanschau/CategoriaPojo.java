/*
 * CategoriaPojo.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class CategoriaPojo implements Categoria {

  private final String nome;

  public CategoriaPojo(String nome) {
    this.nome = nome;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return nome;
  }

}