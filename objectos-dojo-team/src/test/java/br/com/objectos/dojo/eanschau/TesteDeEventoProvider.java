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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeEventoProvider {

  private EventBus bus;

  @BeforeClass
  public void prepararEventBus() {
    Module modulo = new ModuloDeEventoProvider();
    Injector injector = Guice.createInjector(modulo);
    bus = injector.getInstance(EventBus.class);
  }

  public void deve_chamar_metodos_subscribe() {
    MeuEvento meuEvento = new MeuEvento();
    MeuEvento2 meuEvento2 = new MeuEvento2();

    bus.post(meuEvento);
    bus.post(meuEvento2);

    List<String> chamadas = meuEvento.getChamadas();
    List<Integer> chamadasMeuEvento2 = meuEvento2.getChamadasMeuEvento2();

    assertThat(chamadas.contains("cache1"), is(true));
    assertThat(chamadas.contains("cache2"), is(false));
    assertThat(chamadas.contains("cache3"), is(true));
    assertThat(chamadasMeuEvento2.contains(10), is(true));
  }

}