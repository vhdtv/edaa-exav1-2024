import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<CountryStats> countryStatsList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
    }

    public static void lerArquivoCSV() {
        String arquivoCSV = "fifa_countries_audience.csv";
        try {
            Scanner sc = new Scanner(new File(arquivoCSV));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String delimitador = ",";
                String[] coluna = linha.split(delimitador);
                String country = coluna[0];
                String confederation = coluna[1];
                Float population_share = Float.parseFloat(coluna[2]);
                Float tv_audience_share = Float.parseFloat(coluna[3]);
                Float gdp_weighted_share = Float.parseFloat(coluna[4]);

                boolean informacoesDuplicadas = false;
                for (CountryStats cs : countryStatsList) {
                    if (cs.getCountry().equals(country)) {
                        informacoesDuplicadas = true;
                        break;
                    }
                    if (!informacoesDuplicadas) {
                        countryStatsList
                                .add(new CountryStats(country, confederation, population_share, tv_audience_share,
                                        gdp_weighted_share));
                    }

                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado:" + arquivoCSV);
            e.printStackTrace();
        }
    }

}
