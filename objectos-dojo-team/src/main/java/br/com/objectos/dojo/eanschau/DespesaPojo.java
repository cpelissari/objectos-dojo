/*
 * DespesaPojo.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class DespesaPojo implements Despesa {

  private final String descricao;
  private final double valor;
  private final LocalDate data;
  private final PeriodicidadeTipo tipo;
  private final Categoria categoria;

  public DespesaPojo(Construtor construtor) {
    descricao = construtor.getDescricao();
    valor = construtor.getValor();
    data = construtor.getData();
    tipo = construtor.getTipo();
    categoria = construtor.getCategoria();
  }

  @Override
  public String getDescricao() {
    return descricao;
  }

  @Override
  public double getValor() {
    return valor;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public PeriodicidadeTipo getTipo() {
    return tipo;
  }

  @Override
  public Categoria getCategoria() {
    return categoria;
  }

}