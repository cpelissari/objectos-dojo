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

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteToArrayString {

  private final ToArrayString toArray = new ToArrayStringImpl();

  public void deve_converter_array_string() {
    String linha = "11;01/01/1998;01 02 03 04 05 06";

    String[] linhas = toArray.of(linha);
    List<String> res = ImmutableList.copyOf(linhas);

    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("11"));
    assertThat(res.get(1), equalTo("01/01/1998"));
    assertThat(res.get(2), equalTo("01 02 03 04 05 06"));
  }

}