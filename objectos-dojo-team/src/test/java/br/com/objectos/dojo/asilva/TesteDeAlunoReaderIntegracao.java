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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeAlunoReaderIntegracao {

  private AlunoReader alunoReader;

  @BeforeClass
  public void prepararReader() {
    ModuloAluno modulo = new ModuloAluno();
    Injector injector = Guice.createInjector(modulo);
    alunoReader = injector.getInstance(AlunoReader.class);
  }

  public void gerar_iterator_aluno() throws URISyntaxException {
    File file = TxtsFalso.getFile("/Aluno/Ler.txt");

    Iterator<Aluno> iter = alunoReader.of(file);

    List<Aluno> res = ImmutableList.copyOf(iter);

    assertThat(res.size(), equalTo(3));
    Aluno a1 = res.get(0);
    assertThat(a1.getNome(), equalTo("Solange Gomes"));
    assertThat(a1.getNomeMateria(), equalTo("Banco de dados"));
    assertThat(a1.getRa(), equalTo("123456789"));

    Aluno a2 = res.get(1);
    assertThat(a2.getNome(), equalTo("Aline Barroso"));
    assertThat(a2.getNomeMateria(), equalTo("Algoritmos"));
    assertThat(a2.getRa(), equalTo("789456123"));

    Aluno a3 = res.get(2);
    assertThat(a3.getNome(), equalTo("Kaio Duro"));
    assertThat(a3.getNomeMateria(), equalTo("Coe"));
    assertThat(a3.getRa(), equalTo("578946123"));
  }

}