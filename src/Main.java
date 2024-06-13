import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ex3();
    }

    public static String ex4(){
        String numStr = String.valueOf(number);

        if (numStr.length() != 6) {
            return "Шеф, усе втрачено!!!";
        }

        int firstHalf = numStr.charAt(0) - '0' + numStr.charAt(1) - '0' + numStr.charAt(2) - '0';
        int secondHalf = numStr.charAt(3) - '0' + numStr.charAt(4) - '0' + numStr.charAt(5) - '0';

        if (firstHalf == secondHalf) {
            return "Урааааа";
        }

        char[] modifiedNum = numStr.toCharArray();
        modifiedNum[0] = (char) (modifiedNum[0] + 1);
        modifiedNum[1] = (char) ((modifiedNum[1] - '0') / 2 + '0');
        modifiedNum[2] = (char) (modifiedNum[2] + 1);
        modifiedNum[3] = (char) ((modifiedNum[3] - '0') / 2 + '0');
        modifiedNum[4] = (char) ((modifiedNum[4] - '0') / 2 + '0');
        modifiedNum[5] = (char) (modifiedNum[5] + 1);

        return new String(modifiedNum);
    }

    public static void ex3(){
        try {
            Scanner scanner = new Scanner(new File("./src/input.txt"));
            int fuelCapacity = scanner.nextInt();
            int distanceAB = scanner.nextInt();
            int distanceBC = scanner.nextInt();
            int cargoWeight = scanner.nextInt();
            scanner.close();

            int fuelConsumptionAB = fuel(cargoWeight, distanceAB);
            int fuelConsumptionBC = fuel(cargoWeight, distanceBC);

            if (fuelConsumptionAB == -1 || fuelConsumptionBC == -1) {
                System.out.println("Політ неможливий за введеним маршрутом");
            } else {
                int totalFuelRequired = fuelConsumptionAB + fuelConsumptionBC;
                if (totalFuelRequired <= fuelCapacity) {
                    System.out.println("Дозаправка не потрібна");
                } else if (fuelConsumptionAB <= fuelCapacity) {
                    int refuelNeeded = totalFuelRequired - fuelCapacity;
                    System.out.println("Мінімальна кількість палива для дозаправки в пункті В: " + refuelNeeded + " літрів");
                } else {
                    System.out.println("Політ неможливий за введеним маршрутом");
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
    }

    public static int fuel(int cargoWeight, int distance) {
        if (cargoWeight > 2000) {
            return -1; // Неможливо летіти з вагою більше 2000 кг
        }

        int consumptionPerKm;
        if (cargoWeight <= 500) {
            consumptionPerKm = 1;
        } else if (cargoWeight <= 1000) {
            consumptionPerKm = 4;
        } else if (cargoWeight <= 1500) {
            consumptionPerKm = 7;
        } else {
            consumptionPerKm = 9;
        }

        return consumptionPerKm * distance;
    }

    public static void ex2(){
        int coins = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Професор ліг спати о 8 годині, а встав о 9 годині. Скільки годин проспав професор?");
        coins += scanner.nextLine().equals("1") ? 1 : 0;

        System.out.println("На двох руках десять пальців. Скільки пальців на 10?");
        coins += scanner.nextLine().equals("50") ? 1 : 0;

        System.out.println("Скільки цифр у дюжині?");
        coins += scanner.nextLine().equals("2") ? 1 : 0;

        System.out.println("Скільки потрібно зробити розпилів, щоб розпиляти колоду на 12 частин?");
        coins += scanner.nextLine().equals("11") ? 1 : 0;

        System.out.println("Лікар зробив три уколи в інтервалі 30 хвилин. скільки часу він витратив?");
        coins += scanner.nextLine().equals("30") ? 1 : 0;

        System.out.println("Скільки цифр 9 в інтервалі 1100?");
        coins += scanner.nextLine().equals("1") ? 1 : 0;

        System.out.println("Пастух мав 30 овець. Усі, крім однієї, розбіглися. Скільки овець лишилося?");
        coins += scanner.nextLine().equals("1") ? 1 : 0;

        switch (coins){
            case 7: System.out.println("Геній"); break;
            case 6: System.out.println("Ерудит"); break;
            case 5: System.out.println("Нормальний"); break;
            case 4: System.out.println("Здібності середні"); break;
            case 3: System.out.println("Здібності нижче середнього"); break;
            default: System.out.println("Вам треба відпочити!"); break;
        }
    }

    public static void ex1(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");

        try {
            int time = Integer.parseInt(scanner.nextLine());

            System.out.println((time >= 0 && time < 6) ? "Good Night":(time >= 6 && time <= 13) ? "Good Morning": "Не понял");


        }catch (NumberFormatException e){
            System.out.println("Error: " + e);
        }
    }
}