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
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeTransform {

  public void deve_transformar_lista_integer_to_lista_string() {
    List<Integer> ints = newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<String> prova = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    Tranform tranform = new Tranform();
    List<String> res = tranform.de(ints);

    assertThat(res.size(), equalTo(10));
    assertThat(res, equalTo(prova));
  }

  public void deve_transformar_lista_integer_to_lista_string_transform() {
    List<Integer> ints = newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<String> prova = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    Tranform tranform = new Tranform();
    List<String> res = tranform.de(ints, new IntegerToString());

    assertThat(res.size(), equalTo(10));
    assertThat(res, equalTo(prova));
  }

  public void deve_transformar_lista_integer_to_lista_string_transform_2() {
    List<Integer> ints = newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<String> prova = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    List<String> res = transform(ints, new IntegerToString());

    assertThat(res.size(), equalTo(10));
    assertThat(res, equalTo(prova));
  }

}