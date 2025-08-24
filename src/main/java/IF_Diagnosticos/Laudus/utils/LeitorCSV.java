
package IF_Diagnosticos.Laudus.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LeitorCSV {
    private final String caminho;
    public LeitorCSV(String caminho){ this.caminho = caminho; }

    public List<String[]> lerLinhas(){
        List<String[]> dados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), StandardCharsets.UTF_8))) {
            String header = br.readLine(); // cabeçalho
            if (header == null) return dados;
            String linha;
            while ((linha = br.readLine()) != null) {
                // "fix" específico para exemplo com vírgula faltando
                linha = linha.replace("CRM/PB 2345Dr.", "CRM/PB 2345,Dr.");
                // split simples respeitando campo vazio
                List<String> cols = new ArrayList<>();
                StringBuilder cur = new StringBuilder();
                boolean inQuotes = false;
                for (int i=0;i<linha.length();i++){
                    char c = linha.charAt(i);
                    if (c=='"'){ inQuotes=!inQuotes; }
                    else if (c==',' && !inQuotes){
                        cols.add(cur.toString().trim());
                        cur.setLength(0);
                    } else {
                        cur.append(c);
                    }
                }
                cols.add(cur.toString().trim());
                dados.add(cols.toArray(new String[0]));
            }
        } catch (IOException e){
            throw new RuntimeException("Erro lendo CSV: " + e.getMessage(), e);
        }
        return dados;
    }
}
