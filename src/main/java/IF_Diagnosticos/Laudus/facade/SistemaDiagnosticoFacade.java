package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.bridge.Exame;
import IF_Diagnosticos.Laudus.prioridade.FilaPrioridade;


public class SistemaDiagnosticoFacade {
    private ValidadorExame validador;
    private FilaPrioridade gerenciadorFila;

    public SistemaDiagnosticoFacade(FilaPrioridade gerenciadorFila, ValidadorExame validador) {
        this.gerenciadorFila = gerenciadorFila;
        this.validador = validador;
    }

    public void processaPedidoLaudo(Exame exame) {

        // Etapa 1: Estágio de pagamento com a aplicação de descontos

        // Etapa 2: Adição à fila (Prioridade: Strategy + fila liked + Simple Factory)
        gerenciadorFila.adicionarExame(exame);
        System.out.println("Exame adicionado na fila: " + exame.getTipo());

        // Etapa 3: Processamento do exame (Chama o o próximo exame da fila)
        Exame exameProcessado = this.gerenciadorFila.processarProximo();

        // Etapa 4: Obtenção do conteúdo do exame validado (Validadores com chain)
        String conteudo = validador.validar(exameProcessado);

        // Etapa 5: Geração do Laudo Final
        // Pergunta quem foi o médico responsável que deu o laudo (NÃO PODE SER VAZIO)
        // Se for de imagem vai pedir a descrição que será o conteudo, senão já entre automático aqui como conteudo
        // Envia o exame.
        EmissorLaudo.emitirLaudo(exameProcessado);

        // Etapa 6: Notifica por email ou por telefone
        // Pega o número de telefone e o email que o paciente forneceu e notifica que o laudo já foi impresso e está disponivel


        }
    }
}