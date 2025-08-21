package IF_Diagnosticos.Laudus.main;


import IF_Diagnosticos.Laudus.facade.SistemaDiagnosticoFacade;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        SistemaDiagnosticoFacade sistema = new SistemaDiagnosticoFacade();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Início do Processamento de Exame ---");

            // Coleta os dados do Paciente
            System.out.print("Nome do Paciente: ");
            String nomePaciente = scanner.nextLine();
            System.out.print("CPF do Paciente: ");
            String cpfPaciente = scanner.nextLine();
            System.out.print("Data de Nascimento: ");
            String dataNascimento = scanner.nextLine();
            Paciente paciente = new Paciente(nomePaciente, cpfPaciente, dataNascimento);

            // Coleta os dados do Médico e Convênio
            System.out.print("Nome do Médico: ");
            String nomeMedico = scanner.nextLine();
            System.out.print("CRM: ");
            String crmMedico = scanner.nextLine();
            System.out.print("Especialidade: ");
            String especialidadeMedico = scanner.nextLine();
            Medico medicoSolicitante = new Medico(nomeMedico, crmMedico, especialidadeMedico);

            System.out.print("Nome do Convênio: ");
            String nomeConvenio = scanner.nextLine();
            System.out.print("Código do Convênio: ");
            String codigoConvenio = scanner.nextLine();
            Convenio convenio = new Convenio(nomeConvenio, codigoConvenio);

            // Coleta os dados do Exame
            System.out.print("Tipo do exame (sanguineo/imagem): ");
            String tipoExame = scanner.nextLine();
            System.out.print("Nome do exame: ");
            String nomeExame = scanner.nextLine();
            System.out.print("Valor do exame: ");
            double valorExame = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Unidade do exame: ");
            String unidadeExame = scanner.nextLine();
            System.out.print("Prioridade (URGENTE/POUCO_URGENTE/ROTINA): ");
            String prioridadeStr = scanner.nextLine().toUpperCase();
            Prioridade prioridade = Prioridade.valueOf(prioridadeStr);
            System.out.print("Formato do laudo (Texto/HTML/PDF): ");
            String formatoLaudo = scanner.nextLine();

            // Chama o Facade para iniciar todo o processo
            sistema.iniciarProcessamentoDeExame(tipoExame, nomeExame, valorExame, unidadeExame, prioridade, formatoLaudo, paciente, medicoSolicitante, convenio);

        } catch (Exception e) {
            System.out.println("Erro no programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}