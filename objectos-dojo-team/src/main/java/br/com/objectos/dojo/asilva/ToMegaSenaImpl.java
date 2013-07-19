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
package br.com.objectos.dojo.asilva;

import java.util.Iterator;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
class ToMegaSenaImpl implements ToMegaSena {

  @Override
  public MegaSena of(String[] entrada) {
    return new Construtor(entrada).novaInstancia();
  }

  @Override
  public Iterator<MegaSena> transform(Iterator<String[]> colunas) {
    return Iterators.transform(colunas, new ToImpl());
  }

  private class ToImpl implements Function<String[], MegaSena> {
    @Override
    public MegaSena apply(String[] input) {
      return of(input);
    }
  }

  private class Construtor implements MegaSena.Construtor {

    private final String[] linhas;

    public Construtor(String[] linhas) {
      this.linhas = linhas;
    }

    @Override
    public MegaSena novaInstancia() {
      return new MegaSenaPojo(this);
    }

    @Override
    public int getNumeroConcurso() {
      String numero = linhas[0];
      int _numero = Integer.parseInt(numero);
      return _numero;
    }

    @Override
    public LocalDate getDataSorteio() {
      String data = linhas[1];
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
      return formatter.parseLocalDate(data);
    }

    @Override
    public String getResultado() {
      return linhas[2];
    }

  }

}
