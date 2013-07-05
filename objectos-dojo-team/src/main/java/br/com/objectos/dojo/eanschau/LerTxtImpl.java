/*
 * LerTxtImpl.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class LerTxtImpl implements LerTxt {

  @Override
  public String of(File file) throws IOException {
    return Files.toString(file, Charsets.UTF_8);
  }

}