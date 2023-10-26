package hotels;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Lodging> lodgings = new LinkedList<>();

        populate(lodgings);

        // program
        System.out.println(" -- Select an option -- ");
        System.out.println("1. Show all lodgings");
        System.out.println("2. Show hotels by location");
        System.out.println("3. Show camping places by location");

        System.out.print(" > Write your option number: ");
        int option = getInt("Only number in range [1, 3]", num -> 1 <= num && num <= 3);

        if (option == 1) {
            System.out.println(lodgings);

        } else if (option == 2) {
            System.out.println("Write the location: ");

            String location = scanner.nextLine();

            lodgings.stream()
                    .filter(lodging -> lodging instanceof Hotel && lodging.getLocation().equals(location))
                    .forEach(System.out::println);

        } else if (option == 3) {
            System.out.println("Write the location: ");

            String location = scanner.nextLine();

            lodgings.stream()
                    .filter(lodging -> lodging instanceof Camping && lodging.getLocation().equals(location))
                    .forEach(System.out::println);
        }
    }

    private static int getInt(String errorMessage, Predicate<Integer> condition) {
        String userInput = scanner.nextLine();

        int integerInput = 0;
        try {
            integerInput = Integer.parseInt(userInput);
        } catch (NumberFormatException err) {
            System.out.println(errorMessage);
        }

        if (!condition.test(integerInput)) {
            System.out.println(errorMessage);
        }

        return integerInput;
    }

    private static void populate(List<Lodging> lodgings) {
        // Data
        lodgings.add(new ThreeStarHotel("Sunset Inn", "123 Ocean Boulevard", "Beach City", "John Doe", 50, 100, 5));
        lodgings.add(new ThreeStarHotel("Cityscape Hotel", "456 Downtown Avenue", "Metropolis", "Jane Smith", 80, 150, 7));
        lodgings.add(new ThreeStarHotel("Hillside Lodge", "789 Mountain Road", "Mountain Town", "David Johnson", 40, 80, 4));
        lodgings.add(new ThreeStarHotel("Riverside Resort", "101 Riverbank Lane", "River City", "Emily Wilson", 60, 120, 6));
        lodgings.add(new ThreeStarHotel("Parkview Hotel", "202 Parkview Street", "Parkville", "Michael Lee", 70, 140, 6));
        lodgings.add(new ThreeStarHotel("Harbor Inn", "303 Harbor View Drive", "Harbor Town", "Sarah Brown", 45, 90, 4));
        lodgings.add(new ThreeStarHotel("Valley View Hotel", "404 Valley Road", "Valley Village", "Robert Taylor", 55, 110, 5));
        lodgings.add(new ThreeStarHotel("Lakeside Lodge", "505 Lakeside Avenue", "Lake City", "Jessica Turner", 30, 60, 3));
        lodgings.add(new ThreeStarHotel("Hilltop Resort", "606 Hilltop Lane", "Mountain Resort", "Matthew Clark", 65, 130, 6));
        lodgings.add(new ThreeStarHotel("Beachside Inn", "707 Beachside Road", "Beach Town", "Laura Harris", 75, 150, 7));

        lodgings.add(new FourStarHotel("Elegant Plaza Hotel", "123 Luxury Avenue", "City A", "John Doe", 100, 200, 8, "Fine Dining Bistro", 80, GymType.A));
        lodgings.add(new FourStarHotel("Grand Central Hotel", "456 Uptown Street", "City B", "Jane Smith", 120, 240, 10, "Harborview Restaurant", 100, GymType.A));
        lodgings.add(new FourStarHotel("Tranquil Retreat Hotel", "789 Serene Road", "City C", "David Johnson", 80, 160, 7, "Nature's Delight Eatery", 60, GymType.B));
        lodgings.add(new FourStarHotel("The Opulent Lodge", "101 Regal Lane", "City D", "Emily Wilson", 150, 300, 12, "Royal Feast Dining", 120, GymType.A));
        lodgings.add(new FourStarHotel("Sapphire Suites Hotel", "202 Downtown Plaza", "City E", "Michael Lee", 140, 280, 11, "Crystal Clear Bistro", 90, GymType.B));
        lodgings.add(new FourStarHotel("Tranquil Pines Resort", "303 Mountain View Drive", "City F", "Sarah Brown", 90, 180, 7, "Mountain Elegance Dining", 70, GymType.A));
        lodgings.add(new FourStarHotel("Riverside Elegance Hotel", "404 Riverside Road", "City G", "Robert Taylor", 110, 220, 9, "Riverside Serenity Restaurant", 80, GymType.A));
        lodgings.add(new FourStarHotel("Azure Waves Hotel", "505 Beachfront Lane", "City H", "Jessica Turner", 70, 140, 6, "Seaside Bliss Bistro", 50, GymType.B));
        lodgings.add(new FourStarHotel("Mountain Escape Resort", "606 Mountainview Avenue", "City I", "Matthew Clark", 100, 200, 8, "Summit Delight Dining", 70, GymType.A));
        lodgings.add(new FourStarHotel("Seaside Serenity Hotel", "707 Beachfront Road", "City J", "Laura Harris", 130, 260, 10, "Coastal Gourmet Restaurant", 100, GymType.B));

        lodgings.add(new FiveStarHotel("Opulent Elegance", "123 Luxury Avenue", "City A", "John Doe", 120, 240, 10, "Exquisite Dining", 120, GymType.A, 5, 3, 20));
        lodgings.add(new FiveStarHotel("Royal Palace Hotel", "456 Uptown Street", "City B", "Jane Smith", 150, 300, 12, "Grand Banquet Hall", 150, GymType.A, 8, 5, 25));
        lodgings.add(new FiveStarHotel("Tranquility Heights", "789 Serene Road", "City C", "David Johnson", 100, 200, 8, "Elegant Eats", 80, GymType.B, 6, 4, 15));
        lodgings.add(new FiveStarHotel("The Luxe Lodge", "101 Regal Lane", "City D", "Emily Wilson", 180, 360, 15, "Gourmet Bliss", 200, GymType.B, 10, 7, 30));
        lodgings.add(new FiveStarHotel("Regal Oasis", "202 Downtown Plaza", "City E", "Michael Lee", 160, 320, 13, "Opulent Feast", 140, GymType.A, 7, 6, 27));
        lodgings.add(new FiveStarHotel("Serenity Summit", "303 Mountain View Drive", "City F", "Sarah Brown", 90, 180, 7, "Mountain Majesty", 70, GymType.B, 5, 3, 18));
        lodgings.add(new FiveStarHotel("Riverside Paradise", "404 Riverside Road", "City G", "Robert Taylor", 130, 260, 11, "Riverfront Delight", 110, GymType.A, 7, 4, 23));
        lodgings.add(new FiveStarHotel("Azure Opulence", "505 Beachfront Lane", "City H", "Jessica Turner", 70, 140, 6, "Seaside Splendor", 60, GymType.A, 4, 2, 12));
        lodgings.add(new FiveStarHotel("Mountain Majesty", "606 Mountainview Avenue", "City I", "Matthew Clark", 110, 220, 9, "Peak Perfection", 100, GymType.B, 6, 3, 20));
        lodgings.add(new FiveStarHotel("Seaside Paradise", "707 Beachfront Road", "City J", "Laura Harris", 140, 280, 12, "Coastal Elegance", 120, GymType.A, 8, 5, 25));

        lodgings.add(new Camping("Nature Haven Campground", "123 Forest Road", "Woodland Park", "John Doe", true, 50, 75, 10, true));
        lodgings.add(new Camping("Riverside Retreat", "456 Riverbank Lane", "River City", "Jane Smith", true, 40, 60, 8, false));
        lodgings.add(new Camping("Mountain Pines Campsite", "789 Mountain View Drive", "Mountain Town", "David Johnson", true, 60, 90, 12, true));
        lodgings.add(new Camping("Seaside Serenity Campground", "101 Beachfront Road", "Beach City", "Emily Wilson", true, 70, 100, 14, true));
        lodgings.add(new Camping("Lakeside Oasis", "202 Lakeside Avenue", "Lakeview Village", "Michael Lee", false, 45, 70, 6, true));
        lodgings.add(new Camping("Wilderness Escape Campsite", "303 Wilderness Trail", "Wilderness National Park", "Sarah Brown", true, 80, 120, 15, false));
        lodgings.add(new Camping("Forest Hideaway", "404 Forest Lane", "Woodland Retreat", "Robert Taylor", true, 55, 85, 11, true));
        lodgings.add(new Camping("Mountainview Campsite", "505 Mountainview Road", "Scenic Mountains", "Jessica Turner", true, 65, 100, 10, false));
        lodgings.add(new Camping("Riverfront Campground", "606 Riverfront Avenue", "Riverside Park", "Matthew Clark", true, 75, 110, 9, false));
        lodgings.add(new Camping("Beachside Camping", "707 Beachside Lane", "Coastal Beach", "Laura Harris", true, 90, 130, 13, true));

        lodgings.add(new Residence("Greenwood Apartments", "123 Park Lane", "City A", "John Doe", true, 200, 150, true, false));
        lodgings.add(new Residence("City View Towers", "456 Downtown Avenue", "City B", "Jane Smith", false, 180, 120, false, true));
        lodgings.add(new Residence("Hillside Condos", "789 Mountain Road", "City C", "David Johnson", true, 160, 110, false, false));
        lodgings.add(new Residence("Riverfront Suites", "101 Riverside Drive", "City D", "Emily Wilson", true, 220, 180, true, true));
        lodgings.add(new Residence("Lakeside Residences", "202 Lakeside Road", "City E", "Michael Lee", false, 250, 190, true, false));
        lodgings.add(new Residence("Downtown Lofts", "303 Main Street", "City F", "Sarah Brown", true, 120, 80, false, true));
        lodgings.add(new Residence("Beachfront Condos", "404 Beachfront Lane", "City G", "Robert Taylor", true, 190, 140, true, false));
        lodgings.add(new Residence("Mountainview Apartments", "505 Mountainview Avenue", "City H", "Jessica Turner", false, 150, 100, false, true));
        lodgings.add(new Residence("Riverwalk Suites", "606 Riverwalk Road", "City I", "Matthew Clark", true, 170, 130, true, false));
        lodgings.add(new Residence("Seaside Residences", "707 Beachside Lane", "City J", "Laura Harris", false, 230, 170, false, true));


    }
}
