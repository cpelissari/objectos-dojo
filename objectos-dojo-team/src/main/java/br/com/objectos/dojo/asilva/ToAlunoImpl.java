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

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
public class ToAlunoImpl implements ToAluno {

  @Override
  public Aluno of(String[] entrada) {
    return new Construtor(entrada).novaInstancia();
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
      String nome = linhas[2];
      return nome;
    }

    @Override
    public String getNomeMateria() {
      String nomeMateria = linhas[0];
      return nomeMateria;
    }

    @Override
    public String getRa() {
      String ra = linhas[1];
      return ra;
    }

  }

}