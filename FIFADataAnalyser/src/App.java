import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<CountryStats> countryStatsList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int option;
        do {
            System.out.println("Enter your choice:");
            System.out.println("[1] Sort by Alphabetical Order");
            System.out.println("[2] Sort by TV Audience");
            System.out.println("[3] Exit");
            readCSVFile();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    sortByAlphabeticalOrder();
                    break;
                case 2:
                    sortByTvAudience();
                    break;
                case 3:
                    System.out.println("Program terminated...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 3);
    }

    public static void readCSVFile() {
        String csvFile = "D:\\Users\\m04062a\\OneDrive - Marelli\\Desktop\\Victor\\edaa-exav1-2024\\FIFADataAnalyser\\src\\fifa_countries_audience.csv";
        try {
            Scanner scanner = new Scanner(new File(csvFile));
            // Skipping the table header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            // Creating a set to store unique information temporarily
            Set<CountryStats> uniqueCountryStats = new HashSet<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String delimiter = ",";
                String[] column = line.split(delimiter);
                String country = column[0];
                String confederation = column[1];
                Float populationShare = Float.parseFloat(column[2]);
                Float tvAudienceShare = Float.parseFloat(column[3]);
                Float gdpWeightedShare = Float.parseFloat(column[4]);
                // Creating a CountryStats object
                CountryStats countryStats = new CountryStats(country, confederation, populationShare,
                        tvAudienceShare, gdpWeightedShare);
                // Checking if the information already exists in the temporary set
                if (!uniqueCountryStats.contains(countryStats)) {
                    // If it doesn't exist, add it to the temporary set
                    uniqueCountryStats.add(countryStats);
                }
            }
            // Clearing the original list
            countryStatsList.clear();
            // Adding back to the original list, now containing only unique information
            countryStatsList.addAll(uniqueCountryStats);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found:" + csvFile);
            e.printStackTrace();
        }
    }

    public static void sortByAlphabeticalOrder() {
        Collections.sort(countryStatsList);
        System.out.println("Countries sorted by alphabetical order:");
        for (CountryStats cs : countryStatsList) {
            System.out.println(cs);
        }
    }

    public static void sortByTvAudience() {
        Collections.sort(countryStatsList);
        System.out.println("Countries sorted by TV audience:");
        for (CountryStats cs : countryStatsList) {
            System.out.println(cs);
        }
    }
}