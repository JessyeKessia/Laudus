# 🩺 Laudus

**Sistema de Gerenciamento de Exames Médicos e Emissão de Laudos**

## 👾 Padrões de projeto utilizados

Singleton: O padrão Singleton garante que exista apenas um gerador de IDs em toda a aplicação, evitando duplicidade. Isso assegura controle global e consistência na numeração dos exames.

Simple Factory: O padrão Simple Factory encapsula a lógica de criação de exames em um único ponto. Novos tipos de exame podem ser adicionados sem modificar o código já existente, deixando a criação de exames mais simples e de fácil manutenção.

Bridge: separa a abstração (conteúdo do laudo) da implementação (formato de saída). Isso permite adicionar novos formatos sem alterar o núcleo do sistema.

Chain of O Chain of Responsibility: permite encadear validadores de exames laboratoriais de forma modular. Novas regras podem ser adicionadas apenas inserindo um novo elo na cadeia, sem alterar o restante do código.

Observer: desacoplamento da emissão do laudo da notificação. O “assunto” dispara o evento e todos os “observadores” (e-mail e Telegram) recebem a notificação automaticamente. Isso permite incluir novos canais sem alterar a lógica central.

O Decorator: possibilita aplicar múltiplos descontos em camadas, de forma combinada e flexível. Assim, é possível empilhar descontos (ex.: idoso + convênio + outubro rosa) sem criar subclasses para cada combinação.

Strategy + Simple Factory: O Strategy define diferentes algoritmos de ordenação da fila de exames (urgente no topo, rotina no fim, etc.). A Factory escolhe automaticamente a estratégia correta conforme a prioridade atribuída ao exame.

A Facade (SistemaDiagnosticoFacade) reúne todos os módulos (validação, fila, laudo, pagamento, notificação) em uma interface simples. Isso permite que o Cliente apenas chame sistema.processar(exame), sem conhecer os detalhes internos.

State: O State permite modelar o ciclo de pagamento (pendente, aprovado, cancelado). Cada estado tem comportamento próprio, evitando condicionais espalhadas no código e facilitando a manutenção.


## 🛠️ Tecnologias Utilizadas

<div style="display: inline-flex; align-items: center; background-color:rgb(216, 206, 173); color: black; padding: 6px 12px; border-radius: 6px; font-family: sans-serif; font-size: 14px; font-weight: bold;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" style="width: 20px; height: 20px; margin-right: 10px;">
  Java
</div>

## Fluxo do sistema (passo a passo)

1. Criação do exame
  - O cliente (por exemplo `AplicacaoPrincipal` ou `Cliente`) obtém um objeto `Exame` através da fábrica (`ExameSimpleFactory`). O `Exame` contém `Paciente`, `Medico`, tipo, prioridade e preço base.

2. Chamada à fachada
  - O cliente chama `SistemaDiagnosticoFacade.processar(exame, aplicarOutubroRosa)`. A fachada é o ponto único de entrada para orquestrar o processamento.

3. Validação
  - A fachada delega a validade para `ValidadorExame`. Para exames laboratoriais, `ValidadorExame` monta uma cadeia (`ValidadorLaboratorial`) que aplica várias regras (glicose, creatinina, etc.). O resultado é um `ResultadoValidacao` com `sucesso` e `conteudo`.
  - Se a validação falhar, a fachada interrompe o fluxo e notifica os interessados.

4. Fila e priorização
  - Se o exame for aceito, a fachada pode adicionar o exame à `FilaPrioridade`. A ordem de processamento é decidida por uma `EstrategiaPrioridade` configurável (Urgente / PoucoUrgente / Rotina).

5. Pagamento
  - A fachada chama `Pagamento.processarPagamento(...)`. A lógica de pagamento é implementada usando `ContextoPagamento` + estados (`PagamentoPendente`, `PagamentoAprovado`, `PagamentoRecusado`). O estado determina o comportamento e transições.
  - Se o pagamento for recusado, o fluxo é interrompido e são enviadas notificações apropriadas.

6. Emissão de laudos
  - Quando pagamento e validação estiverem ok, a fachada aciona `EmissorLaudo.gerarArquivosLaudo(exame, conteudo)`.
  - `EmissorLaudo` orquestra a criação de `LaudoConcreto` para cada `FormatoLaudo` (TXT, HTML e PDF). Cada formato gera seu próprio arquivo em `laudos/` e retorna `java.io.File`.
  - O PDF é gerado com PDFBox (classe `FormatoPDF`) ou via um adapter (`PDFGeneratorAdapter` delegando a um `PDFService`). Ao final, `EmissorLaudo` retorna o `File` do PDF gerado.

7. Notificação
  - Após a geração bem-sucedida do laudo, a fachada usa `AssuntoNotificacao` / `FachadaNotificacaoComunicacao` para notificar observadores registrados (email, SMS, Telegram, etc.).

8. Persistência e artefatos
  - Os laudos são salvos em `laudos/` com padrão `laudo_<numeroSequencial>.<ext>` (por exemplo `.txt`, `.html`, `.pdf`). Logs e registros podem ser integrados a uma camada de persistência se necessário.

9. Extensibilidade
  - Para adicionar um novo formato de laudo: implemente `FormatoLaudo`, registre/instancie no `EmissorLaudo` e pronto.
  - Para adicionar um novo validador: implemente `ValidadorLaboratorial` e inclua na cadeia criada por `ValidadorExame`.
## Estrutura de pastas

Visão da estrutura real do projeto (arquivos e pacotes principais):

```bash
├── exames.csv                   
├── pom.xml                      
├── README.md                     
├── diagrama/                     
│   ├── diagrama.uml
│   └── diagrama - versao1.svg
├── laudos/                      
├── src/
│   └── main/
│       └── java/
│           └── IF_Diagnosticos/
│               └── Laudus/     
│                   ├── bridge/         
│                   ├── desconto/       
│                   ├── entidades/      
│                   ├── facade/         
│                   ├── factory/        
│                   ├── main/           
│                   ├── notificacao/    
│                   ├── pagamento/      
│                   ├── prioridade/    
│                   ├── utils/          
│                   └── validadores/   
├── target/                       
└── test-classes/                

```
## 👥 Contribuidores
<table>
  <tr>
   <td align="center">
      <a href="https://github.com/jessyekessia" title="gitHub">
        <img src="https://avatars.githubusercontent.com/u/128109017?v=4" width="100px;" alt="Foto de Jessye"/><br>
        <sub>
          <b>Jessye Késsia Pereira</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Nillocoelho" title="gitHub">
        <img src="https://avatars.githubusercontent.com/u/111874946?v=4" width="100px;" alt="Foto de Danillo"/><br>
        <sub>
          <b>Danillo Coelho</b>
        </sub>
      </a>
    </td>
      </a>
    </td>
  </tr>
</table>
