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

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

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
  public void prepararReader() throws IOException, URISyntaxException {
    ModuloDeTesteDespesa moduloDeTesteDespesa = new ModuloDeTesteDespesa();
    Injector injector = Guice.createInjector(moduloDeTesteDespesa);
    reader = injector.getInstance(DespesaReader.class);
    DespesasFalso.polularTxt();
  }

  public void deve_gerar_interator_despesa() throws URISyntaxException, IOException {
    File file = TxtsFalso.getFile("/despesa/despesasFalso.txt");

    List<Despesa> contra = DespesasFalso.getTodos();
    List<String> prova = transform(contra, new DespesaToString());

    Iterator<Despesa> iter = reader.of(file);

    List<Despesa> list = ImmutableList.copyOf(iter);
    List<String> res = transform(list, new DespesaToString());

    assertThat(res.size(), equalTo(3));
    assertThat(res, equalTo(prova));
  }

}