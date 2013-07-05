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
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import com.google.common.io.Resources;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeTxtIteratorGen {

  private final TxtIteratorGen gen = new TxtIteratorGenImpl();

  public void deve_iterar_txt() throws URISyntaxException {

    URL url = Resources.getResource(LerTxt.class, "/Aluno/Ler.txt");
    URI uri = url.toURI();
    // falta criar os falsos para substituir o url resources
    File file = new File(uri);

    TxtIterator rs = gen.gerar(file);

    assertThat(rs.hasNext(), is(true));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.next(), equalTo("Solange Gomes;Banco de dados;123456789"));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.next(), equalTo("Aline Barroso;Algoritmos;789456123"));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.hasNext(), is(true));
    assertThat(rs.next(), equalTo("Kaio Duro;Coe;578946123"));
    assertThat(rs.hasNext(), is(false));
    assertThat(rs.hasNext(), is(false));
    assertThat(rs.hasNext(), is(false));
  }

}