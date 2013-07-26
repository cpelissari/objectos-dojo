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

import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeStackTraces {

  private final StackTraces traces = new StackTracesImpl();

  public void nivel0() {
    traces.nivel0();
  }

  public void nivel0_com_mensagem() {
    traces.nivel0ComMensagem();
  }

  public void nivel0_minha_excecao() {
    traces.nivel0MinhaExcecao();
  }

  public void nivel1() {
    traces.nivel1();
  }

  public void nivel2() {
    traces.nivel2();
  }

  public void nivel3() {
    traces.nivel3();
  }

  public void nivel4() {
    traces.nivel4();
  }

  public void nivel5() {
    traces.nivel5();
  }

}