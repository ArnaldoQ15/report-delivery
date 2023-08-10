# Report Delivery
API para emissão de relatórios PDF e envio de e-mail.

## Descrição
Bem-vindo ao Report Delivery. Este projeto oferece uma solução simples e eficiente para gerar relatórios dinâmicos, exportá-los em formato PDF e enviá-los por e-mail, tudo em um único ambiente integrado.

## Principais recursos
- **Relatórios poderosos:** Utilizando a versátil biblioteca Jasper Reports 6.20, a API permite a criação de relatórios altamente personalizáveis com dados diversos.
- **Exportação conveniente:** Com apenas alguns cliques, você pode exportar relatórios gerados para o formato PDF, tornando-os facilmente acessíveis e compartilháveis.
- **Automação de e-mail:** Simplifique o processo de distribuição de relatórios com a funcionalidade de envio de e-mail integrada.
- **Integração de dados:** Aproveite a integração perfeita com bancos de dados MySQL 8 para alimentar seus relatórios com dados atualizados e relevantes.

## Pré-requisitos
Antes de começar, certifique-se de ter as seguintes tecnologias e dependências instaladas:
- **Java JDK 17** - A versão 17 ou superior do Java Development Kit é necessária para compilar e executar o projeto.
- **MySQL 8** - Banco de dados relacional utilizado para armazenar os dados da aplicação.
- **Maven** - Gerenciador de dependências e construção de projetos utilizado para compilar e construir o projeto.
- **Outras dependências do projeto** - Verifique o arquivo pom.xml para obter a lista completa de dependências e versões utilizadas neste projeto.

## Instalação
Para instalar o projeto, siga os passos abaixo:
1. Clone o repositório para o seu ambiente local: `https://github.com/ArnaldoQ15/report-delivery.git`
2. Certifique-se de ter o MySQL instalado e em execução.
3. Execute o goal `mvn clean install` do Maven para compilar e construir o projeto.
4. Execute o projeto através do goal `mvn spring-boot:run` do Maven ou a partir da sua IDE.
5. Acesse a documentação da API através da URL `http://localhost:8080/swagger-ui/index.html`.

Agora você está pronto para utilizar a API Report Delivery! Certifique-se de seguir todas as etapas acima para garantir uma configuração adequada.

## Exemplos de uso
<center>
<img alt="Relatório gerado com status Pendente" height="566" src="https://i.imgur.com/GBxhbuG.jpg" width="400"/>
<img alt="Relatório gerado com status Entregue" height="566" src="https://i.imgur.com/318y2tF.jpg" width="400"/>
<img alt="Relatório gerado com status Cancelado" height="566" src="https://i.imgur.com/ZkkEO8L.jpg" width="400"/>

![E-mail enviado](https://i.imgur.com/OjSl316.png)

[Link público](https://ethereal.email/message/ZNT4Ubs4Cney-YxAZNUNtH6.U4C.RbiGAAAACL7ErTXFkqFRxdHuGL.iRF4)
</center>

## Contato
Para qualquer dúvida, sugestão ou suporte relacionado a este projeto, sinta-se à vontade para entrar em contato através do e-mail: `arnaldo.s.fagundes@gmail.com`. Você também pode abrir um problema (issue) no [GitHub](https://github.com/ArnaldoQ15/report-delivery) ou me encontrar no [LinkedIn](https://www.linkedin.com/in/arnaldo-fagundes/).

## Agradecimentos
Gostaria de expressar minha sincera gratidão às seguintes pessoas e projetos que contribuíram para o sucesso deste projeto:

- [Vinícius França](https://github.com/Vinicius-Francx): Por suas valiosas contribuições de código e feedback.
- [Jasper Reports](https://community.jaspersoft.com/): Pela funcionalidade essencial que foi fundamental para o funcionamento deste projeto.
- [Weverton Silva](https://www.linkedin.com/in/weverton-silva-05b94211a/): Pelo orientação e insights valiosos durante o desenvolvimento.

Também agradeço a toda a comunidade de desenvolvedores pelo apoio contínuo e à equipe do GitHub por fornecer uma plataforma incrível para colaboração.