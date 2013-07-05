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
package br.com.objectos.dojo.cpelissari;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class TesteDeToArrayDeString {

  private final ToArrayDeString array = new ToArrayDeStringImpl();

  public void deve_transformar_string_em_array_de_string() {
    String linha = "123;01/10/2012;01 02 05 10 20 50";

    String[] _array = array.toArray(linha);
    List<String> res = ImmutableList.copyOf(_array);

    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("123"));
    assertThat(res.get(1), equalTo("01/10/2012"));
    assertThat(res.get(2), equalTo("01 02 05 10 20 50"));
  }

}