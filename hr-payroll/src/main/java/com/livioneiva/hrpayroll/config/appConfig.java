package com.livioneiva.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfig {
	/*
	RestTamplate - serve para registrar uma instancia unica, um Singleton, de um obj desse tipo
	"RestTamplate, e essa instancia unica vai ficar disponivel para eu ingetar em outros components
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

/*
RestTemplate, adotamos quando precisamos fazer uma chamada pontual a um serviço externo a 
minha aplicação, tendo em vista que possui uma implementação simples de fazer, sem necessidade de 
configurações extras como pode ser vista.

O Singleton é um padrão de projeto criacional, que garante que apenas um objeto desse tipo exista 
e forneça um único ponto de acesso a ele para qualquer outro código. Você terá que levar a classe 
singleton também. ... Na maioria das vezes, essa limitação surge durante a criação de testes de 
unidade.

@Bean
com essa anotação o metodo será scaneado.
Anotação utilizada em cima dos metodos de uma classe, geralmente marcada com @Configuration, 
indicando que o Spring deve inovar aquele metodo e gerenciar o objetivo retornado por ele.
 Quando digo gerenciar é que agora este objeto pode ser injetado em qualquer ponto da sua
  aplicação.

*/
