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
package br.com.objectos.dojo.eanschau;

import java.io.File;
import java.util.Iterator;

import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class DespesaReaderImpl implements DespesaReader {

  private final TxtIteratorGen txtIteratorGen;
  private final ToArrayString toArrayString;
  private final ToDespesa toDespesa;

  @Inject
  public DespesaReaderImpl(TxtIteratorGen txtIteratorGen,
                           ToArrayString toArrayString,
                           ToDespesa toDespesa) {
    this.txtIteratorGen = txtIteratorGen;
    this.toArrayString = toArrayString;
    this.toDespesa = toDespesa;
  }

  @Override
  public Iterator<Despesa> of(File file) {
    Iterator<String> linhas = txtIteratorGen.gerarDe(file);

    Iterator<String[]> colunas = toArrayString.transform(linhas);

    return toDespesa.transform(colunas);
  }

}