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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.io.Resources;

/**
 * @author anderson.silva@objectos.com.br (Anderson Amorim Silva)
 */
public class TxtsFalso {

  public static File getFile(String urlFile) throws URISyntaxException {

    URL url = Resources.getResource(LerTxt.class, urlFile);
    URI uri = url.toURI();

    File file = new File(uri);

    return file;
  }

}