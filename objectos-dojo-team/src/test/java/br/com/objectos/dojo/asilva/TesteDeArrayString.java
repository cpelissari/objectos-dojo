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
public class TesteDeArrayString {

  private ToArrayString toArray;

  public void deve_converter_array_string() {
    String linha = "Solange Gomes;Banco de dados;123456789";

    String[] arr = toArray.de(linha);
    List<String> res = ImmutableList.copyOf(arr);

    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("Solange Gomes"));
    assertThat(res.get(1), equalTo("Banco de dados"));
    assertThat(res.get(2), equalTo("123456789"));
  }

}