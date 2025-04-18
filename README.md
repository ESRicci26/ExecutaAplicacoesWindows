# Lançador de Aplicativos Java Swing

Um utilitário Java Swing simples e eficiente para lançar aplicativos comuns do Windows e executáveis personalizados a partir de uma interface gráfica.

## Visão Geral

Este aplicativo fornece uma interface gráfica amigável usando Java Swing que permite aos usuários lançar programas populares do Windows (como Calculadora, Word, Excel, etc.) bem como arquivos executáveis e JAR personalizados através de um menu dropdown.

## Recursos

- Interface simples com ComboBox para seleção de aplicativos
- Suporte para aplicações do Microsoft Office (Excel, Word, PowerPoint)
- Suporte para utilitários do Windows (Calculadora, Bloco de Notas, Prompt de Comando)
- Capacidade de executar o Notepad++
- Execução de arquivos JAR e EXE personalizados de diretórios especificados
- Detecção automática de caminhos de instalação comuns
- Fallback para seleção manual de arquivos quando os caminhos automáticos falham
- Mensagens de confirmação e tratamento de erros

## Requisitos

- Java Runtime Environment (JRE) 8 ou superior
- Sistema operacional Windows

## Como Utilizar

1. Selecione o aplicativo desejado no menu dropdown
2. Clique no botão "Executar"
3. O aplicativo selecionado será iniciado
4. Uma mensagem de confirmação aparecerá após o lançamento bem-sucedido

Se o caminho para um aplicativo não puder ser encontrado automaticamente, uma janela de diálogo será aberta para que você possa selecionar manualmente o arquivo executável.

## Como Integrar ao Seu Projeto

Para integrar o Lançador de Aplicativos ao seu projeto existente:

1. Copie a classe `ExecutaAplicacoesWindows.java` para seu projeto
2. Importe a classe no seu código:
   ```java
   import seu.pacote.ExecutaAplicacoesWindows;
   ```
3. Instancie e exiba o launcher conforme necessário:
   ```java
   ExecutaAplicacoesWindows launcher = new ExecutaAplicacoesWindows();
   launcher.setSize(350, 150);
   launcher.setVisible(true);
   ```

## Personalizando Aplicativos

Para adicionar ou modificar as opções de aplicativos:

1. Edite o array `opcoes` no construtor da classe
2. Adicione um novo caso no bloco `switch` do método `executarAplicativo()`
3. Implemente a lógica necessária para o novo aplicativo

## Estrutura do Código

- **Construtor**: Configura a GUI com ComboBox e botão Executar
- **executarAplicativo()**: Método principal que processa a seleção e lança o aplicativo apropriado
- **Detecção de caminhos**: Tenta encontrar executáveis em caminhos padrão do sistema antes de pedir ao usuário
- **Tratamento de exceções**: Captura e exibe erros de execução de maneira amigável

## Exemplo de Código

```java
// No seu ActionListener
if (e.getSource() == btnLancarAplicativos) {
    ExecutaAplicacoesWindows launcher = new ExecutaAplicacoesWindows();
    launcher.setSize(350, 150);
    launcher.setVisible(true);
}
```

## Solução de Problemas

### Aplicativo não encontrado
Se um aplicativo não puder ser encontrado automaticamente, você será solicitado a localizar manualmente o executável. Para evitar esse prompt no futuro, você pode modificar os caminhos padrão no código para corresponder à sua configuração do sistema.

### Erros de Execução
Se você receber erros como "Cannot run program", verifique se:
1. O aplicativo está instalado no seu sistema
2. Você tem permissões para executar o aplicativo
3. O caminho no código corresponde ao local de instalação no seu sistema

## Contribuições

Contribuições são bem-vindas! Por favor, sinta-se à vontade para enviar pull requests ou abrir issues para melhorias ou correções de bugs.

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.
