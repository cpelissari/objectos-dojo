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
package br.com.objectos.dojo.treinamento;

import com.google.common.base.Function;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class IntegerToString implements Function<Integer, String> {

  private Integer numero;

  public IntegerToString(Integer numero) {
    this.numero = numero;
  }

  public IntegerToString() {
  }

  @Override
  public String apply(Integer input) {
    return Integer.toString(input);
  }

  @Override
  public String toString() {
    return apply(numero);
  }

}