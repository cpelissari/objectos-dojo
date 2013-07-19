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

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
public class ToAlunoImpl implements ToAluno {

  @Override
  public Aluno of(String[] entrada) {
    return new Construtor(entrada).novaInstancia();
  }

  @Override
  public Iterator<Aluno> transform(Iterator<String[]> colunas) {
    return Iterators.transform(colunas, new ToImpl());
  }

  private class ToImpl implements Function<String[], Aluno> {
    @Override
    public Aluno apply(String[] input) {
      return of(input);
    }
  }

  private class Construtor implements Aluno.Construtor {

    private final String[] linhas;

    public Construtor(String[] linhas) {
      this.linhas = linhas;
    }

    @Override
    public Aluno novaInstancia() {
      return new AlunoPojo(this);
    }

    @Override
    public String getNome() {
      String nome = linhas[0];
      return nome;
    }

    @Override
    public String getNomeMateria() {
      String nomeMateria = linhas[1];
      return nomeMateria;
    }

    @Override
    public String getRa() {
      String ra = linhas[2];
      return ra;
    }
  }

}