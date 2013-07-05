/*
 * Despesa.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public interface Despesa {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Despesa> {

    String getDescricao();

    double getValor();

    LocalDate getData();

    PeriodicidadeTipo getTipo();

    Categoria getCategoria();

  }

  String getDescricao();

  double getValor();

  LocalDate getData();

  PeriodicidadeTipo getTipo();

  Categoria getCategoria();

}