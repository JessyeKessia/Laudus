package IF_Diagnosticos.Laudus.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    public static List<String[]> ler(String caminho) {
        List<String[]> dados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                dados.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }
}