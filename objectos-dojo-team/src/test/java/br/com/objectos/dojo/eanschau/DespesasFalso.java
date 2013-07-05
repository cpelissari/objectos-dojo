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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.joda.time.LocalDate;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class DespesasFalso {

  private static final LocalDate DATA = new LocalDate(2013, 7, 5);

  public final static Despesa DESPESA_VAR = novo()
      .descricao("mercado xyz")
      .valor(5.5d)
      .data(DATA)
      .tipo(PeriodicidadeTipo.VARIAVEL)
      .categoria(new CategoriaPojo("Mercado"))
      .novaInstancia();

  public final static Despesa DESPESA_FIXA = novo()
      .descricao("aluguel xyz")
      .valor(500.5d)
      .data(DATA.plusDays(15))
      .tipo(PeriodicidadeTipo.FIXA)
      .categoria(new CategoriaPojo("Habitação"))
      .novaInstancia();

  public final static Despesa DESPESA_EXTRA = novo()
      .descricao("Conserto xyz")
      .valor(50.5d)
      .data(DATA.plusDays(20))
      .tipo(PeriodicidadeTipo.EXTRA)
      .categoria(new CategoriaPojo("Habitação"))
      .novaInstancia();

  private static final List<Despesa> todos = ImmutableList.<Despesa> builder()
      .add(DESPESA_VAR)
      .add(DESPESA_FIXA)
      .add(DESPESA_VAR)
      .build();

  public static List<Despesa> getTodos() throws URISyntaxException, IOException {
    return todos;
  }

  public static void popularTxt() throws URISyntaxException, IOException {
    File file = TxtsFalso.getFile("/despesa/despesa_falso.txt");

  }

  private static ConstrutorDeDespesaFalso novo() {
    return new ConstrutorDeDespesaFalso();
  }

}