import java.util.*;

class SoilData {
    private double nitrogen;
    private double phosphorus;
    private double potassium;
    private double temperature;
    private double humidity;
    private double rainfall;
    private double ph;

    public SoilData(double nitrogen, double phosphorus, double potassium,
                    double temperature, double humidity,
                    double rainfall, double ph) {
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.temperature = temperature;
        this.humidity = humidity;
        this.rainfall = rainfall;
        this.ph = ph;
    }

    public double getNitrogen() {
        return nitrogen;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getRainfall() {
        return rainfall;
    }

    public double getPh() {
        return ph;
    }
}

class Crop {
    private String name;
    private double minN, maxN;
    private double minP, maxP;
    private double minK, maxK;
    private double minTemp, maxTemp;
    private double minHumidity, maxHumidity;
    private double minRainfall, maxRainfall;
    private double minPh, maxPh;

    public Crop(String name,
                double minN, double maxN,
                double minP, double maxP,
                double minK, double maxK,
                double minTemp, double maxTemp,
                double minHumidity, double maxHumidity,
                double minRainfall, double maxRainfall,
                double minPh, double maxPh) {

        this.name = name;
        this.minN = minN;
        this.maxN = maxN;
        this.minP = minP;
        this.maxP = maxP;
        this.minK = minK;
        this.maxK = maxK;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
        this.minRainfall = minRainfall;
        this.maxRainfall = maxRainfall;
        this.minPh = minPh;
        this.maxPh = maxPh;
    }

    public String getName() {
        return name;
    }

    public int calculateScore(SoilData soil) {
        int score = 0;

        if (soil.getNitrogen() >= minN && soil.getNitrogen() <= maxN)
            score += 15;

        if (soil.getPhosphorus() >= minP && soil.getPhosphorus() <= maxP)
            score += 15;

        if (soil.getPotassium() >= minK && soil.getPotassium() <= maxK)
            score += 15;

        if (soil.getTemperature() >= minTemp && soil.getTemperature() <= maxTemp)
            score += 15;

        if (soil.getHumidity() >= minHumidity && soil.getHumidity() <= maxHumidity)
            score += 10;

        if (soil.getRainfall() >= minRainfall && soil.getRainfall() <= maxRainfall)
            score += 15;

        if (soil.getPh() >= minPh && soil.getPh() <= maxPh)
            score += 15;

        return score;
    }
}

class CropRecommendationService {

    private List<Crop> crops = new ArrayList<>();

    public CropRecommendationService() {

        crops.add(new Crop(
                "Rice",
                60, 120,
                30, 80,
                30, 80,
                20, 35,
                60, 95,
                150, 300,
                5.0, 7.5
        ));

        crops.add(new Crop(
                "Wheat",
                40, 90,
                20, 60,
                20, 60,
                10, 25,
                40, 75,
                50, 150,
                6.0, 7.5
        ));

        crops.add(new Crop(
                "Maize",
                50, 100,
                30, 70,
                20, 70,
                18, 32,
                45, 80,
                60, 180,
                5.5, 7.5
        ));

        crops.add(new Crop(
                "Cotton",
                50, 100,
                20, 60,
                30, 80,
                21, 35,
                40, 80,
                50, 150,
                5.5, 8.0
        ));

        crops.add(new Crop(
                "Sugarcane",
                70, 130,
                30, 80,
                40, 100,
                20, 35,
                60, 90,
                150, 300,
                6.0, 8.0
        ));

        crops.add(new Crop(
                "Pulses",
                20, 60,
                15, 50,
                15, 50,
                18, 30,
                40, 75,
                40, 120,
                6.0, 8.0
        ));
    }

    public Crop recommendCrop(SoilData soil) {

        Crop bestCrop = null;
        int highestScore = -1;

        for (Crop crop : crops) {

            int score = crop.calculateScore(soil);

            if (score > highestScore) {
                highestScore = score;
                bestCrop = crop;
            }
        }

        return bestCrop;
    }

    public int getScore(SoilData soil, Crop crop) {
        return crop.calculateScore(soil);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("     SMART CROP RECOMMENDATION SYSTEM");
        System.out.println("==========================================");

        try {

            System.out.print("Enter Nitrogen (N): ");
            double n = sc.nextDouble();

            System.out.print("Enter Phosphorus (P): ");
            double p = sc.nextDouble();

            System.out.print("Enter Potassium (K): ");
            double k = sc.nextDouble();

            System.out.print("Enter Temperature (°C): ");
            double temperature = sc.nextDouble();

            System.out.print("Enter Humidity (%): ");
            double humidity = sc.nextDouble();

            System.out.print("Enter Rainfall (mm): ");
            double rainfall = sc.nextDouble();

            System.out.print("Enter Soil pH: ");
            double ph = sc.nextDouble();

            if (n < 0 || p < 0 || k < 0 ||
                humidity < 0 || humidity > 100 ||
                rainfall < 0 || ph < 0 || ph > 14) {

                throw new IllegalArgumentException(
                        "Invalid input! Please enter valid values."
                );
            }

            SoilData soil = new SoilData(
                    n, p, k,
                    temperature,
                    humidity,
                    rainfall,
                    ph
            );

            CropRecommendationService service =
                    new CropRecommendationService();

            Crop recommendedCrop = service.recommendCrop(soil);

            int score = service.getScore(soil, recommendedCrop);

            System.out.println("\n==========================================");
            System.out.println("             RECOMMENDATION");
            System.out.println("==========================================");

            System.out.println("Recommended Crop : "
                    + recommendedCrop.getName());

            System.out.println("Suitability Score : "
                    + score + "%");

            System.out.println("\nThank you for using Smart Crop Recommendation System!");

        } catch (InputMismatchException e) {

            System.out.println("\nError: Please enter numeric values only.");

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());

        } finally {

            sc.close();
        }
    }
}