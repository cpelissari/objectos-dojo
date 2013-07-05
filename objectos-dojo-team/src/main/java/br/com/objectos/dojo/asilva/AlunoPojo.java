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
public class AlunoPojo implements Aluno {

  private final String nome;
  private final String nomeMateria;
  private final String ra;

  public AlunoPojo(Construtor construtor) {
    nome = construtor.getNome();
    nomeMateria = construtor.getNomeMateria();
    ra = construtor.getRa();
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public String getNomeMateria() {
    return nomeMateria;
  }

  @Override
  public String getRa() {
    return ra;
  }

}