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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
@Test
public class TesteDeLerTxt {

  private final LerTxt ler = new LerTxtImp();

  public void deve_ler_txt() throws IOException, URISyntaxException {
    URL url = Resources.getResource(LerTxt.class, "/Mega/ler.txt");
    URI uri = url.toURI();

    File file = new File(uri);

    String txt = ler.ler(file);
    String sep = System.getProperty("line.separator");
    String[] arr = txt.split(sep);

    List<String> res = ImmutableList.copyOf(arr);

    assertThat(res.size(), equalTo(3));
    assertThat(res.get(0), equalTo("ttt/// --ta-- ere ação;;"));
    assertThat(res.get(1), equalTo("aee;;; --er- ;;;"));
    assertThat(res.get(2), equalTo("qqq   ;;;e;; ---ww///"));
  }

}