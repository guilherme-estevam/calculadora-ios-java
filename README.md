# calculadora-ios-java
Uma calculadora inspirada no design do iOS, desenvolvida em Java com Swing. Suporta operações matemáticas básicas com uma interface gráfica intuitiva.
Calculadora do Sistema iOS em Java com Interface Gráfica (Swing)

*Sobre o Projeto*

Este projeto é uma reprodução da calculadora do sistema iOS, desenvolvida em Java, utilizando a biblioteca Swing para criar uma interface gráfica de usuário (GUI). A aplicação suporta operações matemáticas básicas, como soma, subtração, multiplicação e divisão, com botões organizados em um layout semelhante ao design do iOS.

*Funcionalidades*

*Operações matemáticas básicas:*

Adição (+)

Subtração (-)

Multiplicação (*)

Divisão (/)

Limpar entrada: Botão C para resetar a calculadora.

Resultado: Botão = para exibir o resultado da operação atual.

Interface intuitiva: Botões numerados de 0-9, com layout em matriz 4x4 inspirado na calculadora do iOS.

*Estrutura do Projeto*

A estrutura principal do código está contida na classe Calculadora. O projeto é composto pelos seguintes elementos:

*Interface Gráfica:*

Um campo de texto (JTextField) para exibir o número atual ou o resultado.

Botões dispostos em uma grade de 4x4 (GridLayout), representando os números e operações.

*Lógica do Programa:*

Uso de um StringBuilder para gerenciar a entrada atual do usuário.

Manipulação de eventos por meio de um único ActionListener para todos os botões.

Suporte à execução sequencial de operações matemáticas.

*Reset e Tratamento de Operadores:*

O botão C limpa o estado atual da calculadora, permitindo reiniciar o cálculo.

O botão = executa a operação atual e exibe o resultado no campo de texto.

*Tecnologias Utilizadas*

*Java SE 8+:* Linguagem de programação para o desenvolvimento.

*Swing:* Biblioteca padrão do Java para a criação de GUIs.
