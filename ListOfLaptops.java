package gbLaptops;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListOfLaptops {
    public static void main(String[] args) {

    	//Laptops(String model, int ram, int hdd, String os, String colour)
        
    	Set<Laptops> set = new HashSet<>();
        set.add(new Laptops("Lenovo", 16, 256, "Windows 10", "Черный"));
        set.add(new Laptops("Razer", 16, 512, "Windows 10", "Серый"));
        set.add(new Laptops("Huawei", 8, 128, "Windows 11", "Серебристый"));
        set.add(new Laptops("MacBook", 32, 512, "MacOS", "Серебристый"));
        set.add(new Laptops("LG", 8, 128, "Windows 10", "Черный"));
        set.add(new Laptops("ASUS", 32, 1024, "Windows 11", "Белый"));
        set.add(new Laptops("Samsung", 16, 256, "Windows 10", "Синий"));

        LaptopSearch operation = new LaptopSearch(set);
        operation.start();

    }
}
