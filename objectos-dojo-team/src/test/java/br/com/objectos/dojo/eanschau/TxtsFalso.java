/*
 * TxtsFalso.java criado em 05/07/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.dojo.eanschau;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.io.Resources;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class TxtsFalso {

  public static File getFile(String caminhoArquivo) throws URISyntaxException {
    URL url = Resources.getResource(LerTxt.class, caminhoArquivo);
    URI uri = url.toURI();

    return new File(uri);
  }

}