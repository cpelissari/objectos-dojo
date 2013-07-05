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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ToDespesaImpl implements ToDespesa {

  @Override
  public Despesa of(String[] entrada) {
    return new Construtor(entrada).novaInstancia();
  }

  private class Construtor implements Despesa.Construtor {

    private final String[] linhas;

    public Construtor(String[] linhas) {
      this.linhas = linhas;
    }

    @Override
    public Despesa novaInstancia() {
      return new DespesaPojo(this);
    }

    @Override
    public String getDescricao() {
      String des = linhas[0];
      return des;
    }

    @Override
    public double getValor() {
      String valor = linhas[1];
      return Double.parseDouble(valor);
    }

    @Override
    public LocalDate getData() {
      String data = linhas[2];

      DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
      LocalDate _data = dtf.parseLocalDate(data);
      return _data;
    }

    @Override
    public PeriodicidadeTipo getTipo() {
      String tipo = linhas[3];
      return PeriodicidadeTipo.valueOf(tipo);
    }

    @Override
    public Categoria getCategoria() {
      String categoria = linhas[4];
      return new CategoriaPojo(categoria);
    }

  }

}