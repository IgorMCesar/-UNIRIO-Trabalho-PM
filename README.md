# [UNIRIO]Trabalho Programação Modular 2018.2
Projeto da disciplina de Programação Modular da UNIRIO.

## Objetivo
O objetivo do trabalho é apoiar o trabalho da Comissão de Bolsas do PPGI. O trabalho consiste em gerar uma aplicação Java (obrigatoriamente), sem interface gráfica com usuários (as funções devem ser acessadas por linha de comando), que recebe como entrada arquivos XML referente ao Currículo Lattes dos candidatos e gera a pontuação de cada candidato e o ranking final.

## Regras
Para concorrer uma bolsa, o aluno de mestrado ou doutorado do PPGI deve atender a um conjunto de critérios estabelecidos pelo Colegiado (ou seja, todos os professores permanentes ou colaboradores e os representantes discentes) do PPGI e avaliados pela Comissão de Bolsas.

* Com base nos currículos Lattes dos candidatos, no tipo (mestrado ou doutorado) e número de bolsas disponíveis, a Comissão de Bolsas elabora um ranking dos alunos e apresenta ao Colegiado para referendamento.
* As regras de Concessão de Bolsas podem ser vistas neste link. Para este trabalho são de especial interesse os artigos V, VI e VII.
* Os candidatos devem enviar também um formulário (que pode ser baixado aqui) com a autoavaliação do seu currículo.

Regras que devem ser consideradas, retiradas do documento que descreve os critérios para Concessão de Bolsas:

* Número de semestres cursados sem reprovação no curso de pós-graduação para o qual a bolsa foi pleiteada, conforme o histórico escolar entregue pelo candidato, atribuindo-se um ponto por semestre concluído;
* Prêmios recebidos nos últimos 10 anos referentes a atividades de pesquisa, conforme indicado no currículo entregue pelo candidato, atribuindo-se um ponto por prêmio;
* Artigos completos publicados nos últimos 10 anos em periódicos ou eventos classificados como A1, A2 ou B1 no Qualis da Computação, atribuindo-se 3 pontos por artigo;    
* Artigos completos publicados nos últimos 10 anos em periódicos ou eventos classificados como B2, B3, B4 ou B5 no Qualis da Computação, atribuindo-se 1 ponto por artigo;
* Participação em eventos classificados, atribuindo-se 1 ponto por evento até um máximo de 5 pontos;
* Existência de vínculo com a UNIRIO nos últimos 10 anos, seja pela participação em projetos, bolsas de pesquisa, representação discente ou similar, atribuindo-se um ponto para cada tipo de envolvimento até um máximo de dois pontos.
* Os candidatos devem ser ordenados pelo número de pontos recebidos nos critérios acima, sendo alocados a bolsas de acordo com a ordem decrescente do seu número de pontos e com a disponibilidade de bolsas.

* Em caso de empate, o desempate se dará pelos seguintes critérios: número de semestres cursados, publicações em periódicos, publicações em conferências, vínculo com UNIRIO, prêmios, participação em eventos.

## Itens a serem analisados para compor a nota

* Boas práticas de modularidade e de programação vistas na disciplina.
* Uso do github (considerando commits de todos os participantes do grupo).
* Uso de design patterns.
* Uso de arquitetura MVC.
* Uso das técnicas de testes no escopo da disciplina.
* Testes automatizados.
* Uso de mock objects para teste.
* Desenvolvimento colaborativo do código do trabalho.
* Qualidade da apresentação do trabalho.

## Interface com usuário

* Não deve ser feita uma interface gráfica para o usuário. O que será avaliado será a lógica do programa, não sua interface gráfica.
* Deve ser possível rodar o programa com diferentes parâmetros (em qualquer ordem) por linha de comando, de acordo com as opções abaixo:
	* -o <nome-caminho-arquivo-txt-saida> : indica o caminho do arquivo texto que deve conter a saída do programa.
	* -l <nome-caminho-arquivo-log-errors> : indica o caminho do arquivo texto que deve conter um log/relatório de erros do programa.
	* -a <nome-caminho-arquivo-xml> <num-semestres-sem-reprovacao>: indica os dados do candidato a ser considerado: o caminho do arquivo com o currículo Lattes, no formato XML, e o número de semestres que o aluno já completou sem reprovações. Podem ser passados vários parâmetros "-a" para o programa.
	* -c : gera a saída completa do programa.
	* -v : modificador que indica que a saída deve ser completa (modo verboso, ou verbose mode).
	* -pr : gera a saída referente aos prêmios recebidos.
	* -ar : gera a saída referente aos artigos completos no Qualis Restrito (ou seja, publicados em conferências ou periódicos classificados como A1, A2 e B1).
	* -anr : gera a saída referente aos artigos completos fora do Qualis Restrito (ou seja, publicados em conferências ou periódicos classificados como B2, B3, B4 e B5).
	* -pe : gera a saída referente à participação em eventos classificados (ou seja, referentes a conferências classificadas como A1, A2, B1, B2, B3, B4 e B5).
	* -vi : gera a saída referente à existência de vínculo com a UNIRIO.

## Exemplo de como executar o programa

~~~~
java meu-programa -o saida.txt -l erro.txt -a candidato1.xml 2 -a candidato2.xml 1 -v -c
~~~~
Obs.: o Eclipse permite simular a passagem de parâmetros de linha de comando.
