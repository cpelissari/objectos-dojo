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
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeTxtIteratorGen {

  private final TxtIteratorGen gen = new TxtIteratorGenImpl();

  public void deve_iterar_um_txt() throws URISyntaxException, FileNotFoundException {
    File file = TxtsFalso.getFile("/Mega/ler.txt");

    TxtIterator res = gen.gerarDe(file);

    assertThat(res.hasNext(), is(true));
    assertThat(res.hasNext(), is(true));
    assertThat(res.next(), equalTo("ttt/// --ta-- ção;;"));
    assertThat(res.hasNext(), is(true));
    assertThat(res.hasNext(), is(true));
    assertThat(res.hasNext(), is(true));
    assertThat(res.next(), equalTo("aee;;; --er- ;;;"));
    assertThat(res.hasNext(), is(true));
    assertThat(res.hasNext(), is(true));
    assertThat(res.hasNext(), is(true));
    assertThat(res.next(), equalTo("qqq   ;;;e;; ---ww///"));
    assertThat(res.hasNext(), is(false));
    assertThat(res.hasNext(), is(false));
    assertThat(res.hasNext(), is(false));
  }

}