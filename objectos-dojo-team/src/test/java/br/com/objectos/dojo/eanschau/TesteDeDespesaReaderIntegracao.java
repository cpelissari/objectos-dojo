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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeDespesaReaderIntegracao {

  private DespesaReader reader;

  @BeforeClass
  public void prepararReader() {
    ModuloDeTesteDespesa moduloDeTesteDespesa = new ModuloDeTesteDespesa();
    Injector injector = Guice.createInjector(moduloDeTesteDespesa);
    reader = injector.getInstance(DespesaReader.class);
  }

  public void deve_gerar_interator_despesa() throws URISyntaxException {
    File file = TxtsFalso.getFile("/despesa/despesa_falso.txt");

    Iterator<Despesa> iter = reader.of(file);

    List<Despesa> res = ImmutableList.copyOf(iter);

    assertThat(res.size(), equalTo(3));

    Despesa r0 = res.get(0);
    assertThat(r0.getDescricao(), equalTo("mercado xyz"));
    assertThat(r0.getValor(), equalTo(5.5));
    assertThat(r0.getData(), equalTo(new LocalDate(2013, 7, 5)));
    assertThat(r0.getTipo(), equalTo(PeriodicidadeTipo.VARIAVEL));
    assertThat(r0.getCategoria().getNome(), equalTo("Mercado"));

    Despesa r01 = res.get(1);
    assertThat(r01.getDescricao(), equalTo("despesa xyz"));
    assertThat(r01.getValor(), equalTo(15.5));
    assertThat(r01.getData(), equalTo(new LocalDate(2013, 4, 15)));
    assertThat(r01.getTipo(), equalTo(PeriodicidadeTipo.FIXA));
    assertThat(r01.getCategoria().getNome(), equalTo("Outros"));

    Despesa r02 = res.get(2);
    assertThat(r02.getDescricao(), equalTo("aluguel Junho/2013"));
    assertThat(r02.getValor(), equalTo(800.0));
    assertThat(r02.getData(), equalTo(new LocalDate(2013, 6, 5)));
    assertThat(r02.getTipo(), equalTo(PeriodicidadeTipo.FIXA));
    assertThat(r02.getCategoria().getNome(), equalTo("Habitação"));
  }

}