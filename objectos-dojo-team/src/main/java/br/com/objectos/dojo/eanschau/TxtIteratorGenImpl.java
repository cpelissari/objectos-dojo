/*
 * TxtIteratorGenImpl.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class TxtIteratorGenImpl implements TxtIteratorGen {

  @Override
  public TxtIterator gerarDe(File file) {
    try {
      return new TxtIteratorImpl(file);
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  private static class TxtIteratorImpl implements TxtIterator {

    private final BufferedReader reader;

    public TxtIteratorImpl(File file) throws FileNotFoundException {
      this.reader = Files.newReader(file, Charsets.UTF_8);
    }

    @Override
    public boolean hasNext() {
      try {
        return reader.ready();
      } catch (IOException e) {
        return false;
      }
    }

    @Override
    public String next() {
      try {
        return reader.readLine();
      } catch (IOException e) {
        return null;
      }
    }

    @Override
    public void remove() {
    }

  }

}