/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.dojo.eanschau;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ConstrutorDeDespesaFalso implements Despesa.Construtor {

  private String descricao;
  private double valor;
  private LocalDate data;
  private PeriodicidadeTipo tipo;
  private Categoria categoria;

  @Override
  public Despesa novaInstancia() {
    return new DespesaPojo(this);
  }

  public ConstrutorDeDespesaFalso descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  public ConstrutorDeDespesaFalso valor(double valor) {
    this.valor = valor;
    return this;
  }

  public ConstrutorDeDespesaFalso data(LocalDate data) {
    this.data = data;
    return this;
  }

  public ConstrutorDeDespesaFalso tipo(PeriodicidadeTipo tipo) {
    this.tipo = tipo;
    return this;
  }

  public ConstrutorDeDespesaFalso categoria(Categoria categoria) {
    this.categoria = categoria;
    return this;
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