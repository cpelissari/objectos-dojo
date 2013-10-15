---
layout: post-alpha
title: "Procedimento de Serialização"
author: "Cristiane Iope Pelissari"
user: "Cpelissari"
date: "2013-10-15"
published: true
partof: procedimento-crud-web
num: 10
outof: 10
---

##Introdução


## Antes de iniciar

Recomendamos a leitura do artigo abaixo para maiores esclarecimentos sobre o processo de serialização.
[]()
 
## Passo-a-passo

### Especificação

<table class="table table-bordered">
 <tr>
   <td class="tac col2em">
    <a id="topo_0_0"><input type="checkbox" /></a>
   </td>
   <td>
    Construindo a classe de Serialização
   </td>
   <td>
    <a href="#0_0">help!</a>
   </td>
 </tr>
 <tr>
   <td class="tac col2em">
    <a id="topo_0_1"><input type="checkbox" /></a>
   </td>
   <td>
    Tipos diferentes de campos para Serialização
   </td>
   <td>
    <a href="#0_1">help!</a>
   </td>
 </tr>
 <tr>
   <td class="tac col2em">
    <a id="topo_0_2"><input type="checkbox" /></a>
   </td>
   <td>
    Erros comuns
   </td>
   <td>
    <a href="#0_0">help!</a>
   </td>
 </tr>

</table>


#### <a id="0_0"> </a>Construindo a classe de Serialização
class FuncionarioSerializer extends JsonSerializer<Funcionario> {

  @Override
  public void serialize(Funcionario value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    jgen.writeStartObject();

    jgen.writeNumberField("id", value.getId());
    jgen.writeStringField("nome", value.getNome());
    jgen.writeStringField("matricula", value.getMatricula());
    jgen.writeObjectField("dataNascimento", value.getDataNascimento());
    jgen.writeObjectField("dataDeAdmissao", value.getDataAdmissao());
    jgen.writeObjectField("dataDemissao", value.getDataDemissao());
    jgen.writeObjectField("superior", value.getSuperior());
    jgen.writeObjectField("diretor", value.getDiretor());
    jgen.writeObjectField("regimeDeContratacao", value.getRegimeDeContratacao());

		jgen.writeEndObject();

  }

}




@JsonSerialize(using = FuncionarioSerializer.class)
public interface Funcionario extends Insertable {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Funcionario> {

		String getNome();

    String getMatricula();

    LocalDate getDataNascimento();

    LocalDate getDataAdmissao();

    LocalDate getDataDemissao();

    Superior getSuperior();

    Diretor getDiretor();

    Contrato getRegimeDeContratacao();

  }

  int getId();

  String getNome();

  String getMatricula();

  LocalDate getDataNascimento();

  LocalDate getDataAdmissao();

  LocalDate getDataDemissao();

  Superior getSuperior();

  Diretor getDiretor();

  Contrato getRegimeDeContratacao();

}

#### <a id="0_1"> </a>Tipos diferentes de campos para Serialização


#### Erros comuns


