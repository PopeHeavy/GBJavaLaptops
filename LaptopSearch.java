package gbLaptops;

import java.util.*;

public class LaptopSearch {
	
	private Set<Laptops> laptops = new HashSet<>();
	
	private List<Feature> featureList = new ArrayList<>();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void printList() {
		for (Laptops laptop : laptops) {
			if (rightLaptop(laptop)) {
				System.out.println(laptop);
			}
		}
	}
	public boolean rightLaptop(Laptops laptop) {
		
		for (Feature feature : featureList) {
			Object valueLaptop = null;
			
			if (feature.property.equals("model")) {
				valueLaptop = laptop.getModel();
			}
			
			else if (feature.property.equals("ram")) {
				valueLaptop = laptop.getRAM();
			}
			else if (feature.property.equals("hdd")) {
				valueLaptop = laptop.getHDD();
			}
			else if (feature.property.equals("os")) {
				valueLaptop = laptop.getOS();
			}
			else if (feature.property.equals("colour")) {
				valueLaptop = laptop.getColour();
			}
			else {
				continue;
			}
			
			if (feature.value != null && !feature.value.equals(valueLaptop)) {
				return false;
			}
			
			if (feature.maxValue != null && feature.maxValue < Double.parseDouble(Objects.toString(valueLaptop))) {
				return false;
			}
			if (feature.minValue != null && feature.minValue > Double.parseDouble(Objects.toString(valueLaptop))){
                return false;
            }
		}
		
		return true;
	}
	public LaptopSearch(Set<Laptops> laptops) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
    }

    public LaptopSearch(Set<Laptops> laptops, List<Feature> featureList) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
        this.featureList = featureList;
    }
    public int getFeatures(){
        String text = "Выберите показатель";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++)
        {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }
    public String getPropertyDescription(String property){

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);
    }
    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();

        map.put("model", "Модель");
        map.put("ram", "ОЗУ");
        map.put("hdd", "Жесткий диск");
        map.put("os", "Операционная система");
        map.put("colour", "Цвет");

        return map;
	
    }
    
    public List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("model");
        list.add("ram");
        list.add("hdd");
        list.add("os");
        list.add("colour");

        return list;
    }
    
    public String getOperations(){

        String text = "Опции: \n " +
                "1. Добавить показатель \n " +
                "2. Вывести список \n " +
                "3. Выход";

        System.out.println(text);

        String answer = scanner.next();

        return answer;
    }
    
    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("ram");
        set.add("hdd");

        return set;
    }
    
    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("model");
        set.add("os");
        set.add("colour");

        return set;
    }
    
    public void start(){

        boolean flag = true;
        while (flag){

            String operation = getOperations();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }
            else if(operation.equals("1")){

                int feature = getFeatures();
                List<String> properties = propertiesForFilter();
                if (feature - 1 < 0 || feature - 1 > properties.size() - 1){
                    System.out.println("Некорректное значение");
                    continue;
                }
                String property = properties.get(feature - 1);
                Feature featureObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                    	featureObject = Feature.startGetting(scanner, property, true);
                    }else {
                    	featureObject = Feature.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("Ошибка при выборе критерия");
                    continue;
                }
                if (featureObject != null){
                    System.out.println("Критерий добавлен");
                    featureList.add(featureObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}
class Feature {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Feature(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Feature startGetting(Scanner scanner, String property, boolean isQuantitative) {

        if (isQuantitative) {

            String quest = "Выберите тип криетрия: " +
                    "\n 1. Точное значение" +
                    "\n 2. Меньше чем..." +
                    "\n 3. Больше чем..." +
                    "\n 4. Интервал";
            System.out.println(quest);

            String text = scanner.next();

            Feature feature = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scanner.nextInt();
                feature = new Feature(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                feature = new Feature(property, isQuantitative, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getValue = scanner.nextDouble();
                feature = new Feature(property, isQuantitative, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                double getMax = scanner.nextDouble();
                feature = new Feature(property, isQuantitative, null, getMin, getMax);
            }

            return feature;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scanner.next();
        return new Feature(property, isQuantitative, getValue, null, null);
    }
}

			
	



