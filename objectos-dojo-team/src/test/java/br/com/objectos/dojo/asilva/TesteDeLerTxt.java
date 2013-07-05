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
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeLerTxt {

  private final LerTxt ler = new LerTxtImpl();

  public void deve_ler_txt() throws IOException, URISyntaxException {

    File file = TxtsFalso.getFile("/Aluno/Ler.txt");

    String txt = ler.ler(file);
    String separador = System.getProperty("line.separator");
    String[] rs = txt.split(separador);

    List<String> seilamano = ImmutableList.copyOf(rs);

    assertThat(seilamano.size(), equalTo(3));
    assertThat(seilamano.get(0), equalTo("Solange Gomes;Banco de dados;123456789"));
    assertThat(seilamano.get(1), equalTo("Aline Barroso;Algoritmos;789456123"));
    assertThat(seilamano.get(2), equalTo("Kaio Duro;Coe;578946123"));
  }

}