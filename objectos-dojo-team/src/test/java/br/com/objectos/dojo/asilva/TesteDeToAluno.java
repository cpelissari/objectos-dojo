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

import org.testng.annotations.Test;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeToAluno {

  private final ToAluno aluno = new ToAlunoImpl();

  public void deve_gerar_aluno() {

    String[] entrada = new String[] { "Solange Gomes", "Banco de dados", "123456789" };

    Aluno res = aluno.of(entrada);

    assertThat(res.getNome(), equalTo("123456789"));
    assertThat(res.getNomeMateria(), equalTo("Solange Gomes"));
    assertThat(res.getRa(), equalTo("Banco de dados"));
  }

}