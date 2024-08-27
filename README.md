# projeto
# Diagrama de Classes
![Diagrama de Classe UML -  Gerenciamento de Atendimento Psicológico](https://github.com/user-attachments/assets/65d08d0f-3701-469e-83ae-109b566bd24c)

Clonar repositorio 
# Como clonar o repositório

## Código em linha

Para clonar o repositório, use o seguinte comando: `$ git clone https://github.com/matheus-avvelino/projeto.git`


# Passo 1: Importar o projeto Maven no Eclipse

Depois de clonar o repositório, siga os passos abaixo para importar o projeto Maven no Eclipse:

1. Abra o Eclipse.

2. Importe o projeto Maven:
   - Vá para `File` > `Import...`.
     
      ![images/import%200.PNG](https://github.com/matheus-avvelino/projeto/blob/main/images/import%200.PNG))

   - Selecione `Existing Maven Projects` em `Maven` e clique em `Next`.
  
     ![images/import%200.PNG](https://github.com/matheus-avvelino/projeto/blob/main/images/import%201.PNG))

   - Clique em `Browse...` e navegue até o diretório onde você clonou o repositório.
   - Selecione a pasta do projeto e clique em `Finish`.
     ![images/import%200.PNG](https://github.com/matheus-avvelino/projeto/blob/main/images/import%202.PNG))

5. Aguarde a configuração do projeto:
   - O Eclipse irá automaticamente baixar todas as dependências do Maven e configurar o projeto.
   - Depois que o processo estiver concluído, você verá o projeto no explorador de projetos do Eclipse.


# Passo 2: Acesse as Opções de Build do Maven

1. No **Project Explorer**, clique com o botão direito do mouse no nome do projeto.
2. Selecione `Run As` > `Maven Build...`.
   
# Passo 3: Configure o Build

1. Na janela que se abre, em **Goals**, digite `clean install`.
   - **clean**: Este goal remove todos os arquivos gerados na compilação anterior, limpando o diretório `target`.
   - **install**: Este goal compila o projeto, executa os testes e instala o artefato compilado no repositório local do Maven.
2. Clique em **Run** para iniciar o build.

# Passo 4: Verifique o Build

- Durante o processo de build, o Eclipse exibirá o progresso na janela de **Console**.
- Se o build for bem-sucedido, você verá a mensagem `BUILD SUCCESS` no Console.
- O projeto estará compilado e os artefatos gerados estarão no diretório `target` dentro do seu projeto.

## Resolução de Problemas

- **Erros de Dependência**: Se houver erros relacionados a dependências, verifique o arquivo `pom.xml` e atualize o projeto Maven no Eclipse. Para isso, clique com o botão direito no projeto e selecione `Maven` > `Update Project...`.
- **Falha nos Testes**: Se os testes falharem, você pode ver os relatórios de teste em `target/surefire-reports/` ou verificar o Console do Eclipse para mais detalhes.

Seguindo esses passos, você conseguirá compilar e construir seu projeto Maven dentro do Eclipse com sucesso!
