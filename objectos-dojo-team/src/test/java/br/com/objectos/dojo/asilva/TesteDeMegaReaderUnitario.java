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

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Iterators;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeMegaReaderUnitario {

  private MegaSenaReader reader;

  private Asserts asserts;

  @BeforeClass
  public void prepararReader() {
    TxtIteratorGen txtIteratorGen = new TxtIteratorGenFalso();
    ToArrayString toArrayString = new ToArrayStringFalso();
    ToMegaSena toMegaSena = new ToMegaSenaFalso();
    reader = new MegaSenaReaderImpl(txtIteratorGen, toArrayString, toMegaSena);
  }

  @BeforeMethod
  public void prepararTest() {
    asserts = new Asserts();
  }

  public void deve_gerar_iterator_mega_sena() throws URISyntaxException {
    File file = TxtsFalso.getFile("/Mega/resultado.txt");

    Iterator<MegaSena> iter = reader.of(file);

    assertThat(iter, notNullValue());

    assertThat(asserts.fileRecebido, equalTo(file));
    assertThat(asserts.toArrayStringOK, equalTo(true));
    assertThat(asserts.toMegaSenaOK, equalTo(true));

    List<String> ordem = asserts.ordemDeMetodos;
    assertThat(ordem.size(), equalTo(3));
    assertThat(ordem.get(0), equalTo("TxtIteratorGen"));
    assertThat(ordem.get(1), equalTo("ToArrayString"));
    assertThat(ordem.get(2), equalTo("ToMegaSena"));
  }

  private class Asserts {
    List<String> ordemDeMetodos = newArrayList();

    File fileRecebido;
    boolean toArrayStringOK;
    boolean toMegaSenaOK;
  }

  private class TxtIteratorGenFalso implements TxtIteratorGen {
    @Override
    public TxtIterator gerarDe(File file) {
      asserts.ordemDeMetodos.add("TxtIteratorGen");
      asserts.fileRecebido = file;
      return new TxtIteratorVazio();
    }
  }

  private class ToArrayStringFalso implements ToArrayString {

    @Override
    public Iterator<String[]> transform(Iterator<String> linhas) {
      asserts.ordemDeMetodos.add("ToArrayString");
      asserts.toArrayStringOK = true;
      return Iterators.emptyIterator();
    }

    @Override
    public String[] of(String linha) {
      throw new UnsupportedOperationException();
    }

  }

  private class ToMegaSenaFalso implements ToMegaSena {

    @Override
    public Iterator<MegaSena> transform(Iterator<String[]> colunas) {
      asserts.ordemDeMetodos.add("ToMegaSena");
      asserts.toMegaSenaOK = true;
      return Iterators.emptyIterator();
    }

    @Override
    public MegaSena of(String[] entrada) {
      throw new UnsupportedOperationException();
    }

  }

  private class TxtIteratorVazio implements TxtIterator {

    private final Iterator<String> delegate = Iterators.emptyIterator();

    @Override
    public boolean hasNext() {
      return delegate.hasNext();
    }

    @Override
    public String next() {
      return delegate.next();
    }

    @Override
    public void remove() {
      delegate.remove();
    }

  }

}