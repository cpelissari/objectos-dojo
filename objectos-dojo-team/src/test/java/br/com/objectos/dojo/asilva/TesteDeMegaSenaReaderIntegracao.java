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
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeMegaSenaReaderIntegracao {

  private MegaSenaReader reader;

  @BeforeClass
  public void prepararReader() {
    ModuloMegaSena modulo = new ModuloMegaSena();
    Injector injector = Guice.createInjector(modulo);
    reader = injector.getInstance(MegaSenaReader.class);
  }

  public void deve_gerar_iterator_mega_sena() throws URISyntaxException {
    File file = TxtsFalso.getFile("/Mega/resultado.txt");

    Iterator<MegaSena> iter = reader.of(file);

    List<MegaSena> res = ImmutableList.copyOf(iter);

    assertThat(res.size(), equalTo(3));
    MegaSena r0 = res.get(0);
    assertThat(r0.getNumeroConcurso(), equalTo(11));
    assertThat(r0.getDataSorteio(), equalTo(new LocalDate(2013, 7, 5)));
    assertThat(r0.getResultado(), equalTo("01 02 03 04 05 06"));

    MegaSena r1 = res.get(1);
    assertThat(r1.getNumeroConcurso(), equalTo(12));
    assertThat(r1.getDataSorteio(), equalTo(new LocalDate(2013, 9, 5)));
    assertThat(r1.getResultado(), equalTo("11 22 53 14 45 55"));

    MegaSena r2 = res.get(2);
    assertThat(r2.getNumeroConcurso(), equalTo(100));
    assertThat(r2.getDataSorteio(), equalTo(new LocalDate(2016, 6, 5)));
    assertThat(r2.getResultado(), equalTo("18 31 55 21 52 05"));
  }

}
