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
class ToArrayStringImpl implements ToArrayString {

  @Override
  public String[] of(String linha) {
    String[] res = linha.split(";");
    return res;
  }

  @Override
  public Iterator<String[]> transform(Iterator<String> linhas) {
    return Iterators.transform(linhas, new ToImpl());
  }

  private class ToImpl implements Function<String, String[]> {
    @Override
    public String[] apply(String input) {
      return of(input);
    }
  }

}
