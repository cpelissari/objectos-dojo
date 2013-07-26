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

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class StackTracesComCausaImpl implements StackTracesComCausa {

  @Override
  public void nivel0() {
    throw new RuntimeException();
  }

  @Override
  public void nivel0ComMensagem() {
    throw new RuntimeException("Lançou uma exceção");
  }

  @Override
  public void nivel0MinhaExcecao() {

    throw new MinhaExcecao();
  }

  @Override
  public void nivel1() {
    nivel0();
  }

  @Override
  public void nivel2() {
    nivel1();
    /*    try {
          nivel1();
        } catch (RuntimeException e) {
          // throw new Nivel2Exception("lançou exceção", e);
          System.out.println("arquivo não encontrado.");
        }
    */}

  @Override
  public void nivel3() {
    try {
      nivel2();
    } catch (RuntimeException e) {
      /*      throw new Nivel3Exception("deu pau", e);
            throw new Nivel3Exception("deu pau", e);
      */throw new Nivel3Exception("deu pau");
    }

  }

  @Override
  public void nivel4() {
    try {
      nivel3();
    } catch (RuntimeException e) {
      System.out.println("nivel4");
    }
  }

  @Override
  public void nivel5() {
    nivel4();
  }

  @Override
  public void stackOverFlow() {
    stackOverFlow0();
  }

  private void stackOverFlow0() {
    stackOverFlow1();
  }

  private void stackOverFlow1() {
    stackOverFlow2();
  }

  private void stackOverFlow2() {
    stackOverFlow0();
  }

}
