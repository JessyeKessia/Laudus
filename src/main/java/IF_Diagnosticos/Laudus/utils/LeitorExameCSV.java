//package IF_Diagnosticos.Laudus.utils;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class CadastroPaciente {
//
//    // Caminho fixo do CSV que será usado sempre
//    private static final String ARQUIVO_CSV = "exames.csv";
//
//    public static void cadastrarPaciente(String nome, int idade, String cpf, String email) {
//        try (FileWriter writer = new FileWriter(ARQUIVO_CSV, true)) {
//            // Formato CSV: nome,idade,cpf,email
//            writer.append(nome)
//                    .append(",")
//                    .append(String.valueOf(idade))
//                    .append(",")
//                    .append(cpf)
//                    .append(",")
//                    .append(email)
//                    .append("\n");
//
//            System.out.println("Paciente cadastrado com sucesso!");
//        } catch (IOException e) {
//            System.out.println("Erro ao salvar paciente: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        // Exemplo de uso
//        cadastrarPaciente("Maria Silva", 28, "123.456.789-00", "maria@email.com");
//        cadastrarPaciente("João Souza", 35, "987.654.321-00", "joao@email.com");
//    }
//}
