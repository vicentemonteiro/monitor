# Monitor de Mensagens

## Execução Local
1. Faça download do projeto para seu ambiente de desenvolvimento utilizando GIT no seguinte endereço: https://github.com/vicentemonteiro/monitor
2. Abra o projeto Maven na IDE de sua preferência.
4. Preencha o twitter4j.properties com as informações de autenticação.
5. Execute o projeto pelo menu de contexto de sua IDE.
> A classe principal é com.monteiro.monitor.MonitorApplication.java

## Uso do Sistema
1. Abra o navegador no seguinte endereço https://monitorv.herokuapp.com

### Incluir hashtag a monitorar
1. Digite a hashtag que gostaria de monitorar no campo "Nova hastag" e clique no botão "Inserir".
2. Cria quantos monitoramentos preferir repetindo o passo anterior.

### Visualizar mensagens por hashtag
1. Selecione a hashtag na caixa de seleção "hashtags monitoradas".

### Remover hashtag monitorada
1. Selecione a hashtag na caixa de seleção "hashtags monitoradas".
2. Clique no botão "Remover"

> Obs.: O sistema fará uma nova chamada ao twitter em busca de atualização a cada 50 segundos.
> Ao remover a hashtag todas as mensagens referentes a ela serão apagadas.