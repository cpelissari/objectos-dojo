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

import com.google.common.eventbus.Subscribe;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class Cache1 {

  public Cache1() {
    System.out.println("cache1");
  }

  @Subscribe
  public void on(MeuEvento evento) {
    evento.add("cache1");
  }

  @Subscribe
  public void on(MeuEvento2 evento2) {
    evento2.add(10);
  }

}