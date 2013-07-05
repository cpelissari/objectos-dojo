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
package br.com.objectos.dojo.gravadora;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Reis Silva Bertoldi)
 */
public class LerArquivoTextoImpl implements LerArquivoTexto {

  @Override
  public String lerTxt(File file) {
    try {
      return Files.toString(file, Charsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
  }

}