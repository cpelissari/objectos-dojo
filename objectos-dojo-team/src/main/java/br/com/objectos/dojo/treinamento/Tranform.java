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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class Tranform {

  public List<String> de(List<Integer> ints) {
    List<String> list = newArrayList();

    for (Integer numero : ints) {
      String res = new IntegerToString(numero).toString();
      list.add(res);
    }

    return list;
  }

}