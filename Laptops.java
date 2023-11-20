package gbLaptops;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Задание

Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.*/


public class Laptops {
	
	private String model;
	
	private int ram;
	
	private int hdd;
	
	private String os;
	
	private String colour;
	
	public Laptops(String model, int ram, int hdd, String os, String colour) {
		this.model = model;
		this.ram = ram;
		this.hdd = hdd;
		this.os = os;
		this.colour = colour;
		}
	public boolean isLaptop() {
		return true;
	}
	public static List<String> filter(){
		List<String> list = new ArrayList<>();
		list.add("model");
		list.add("ram");
		list.add("hdd");
		list.add("os");
		list.add("colour");
		
		return list;
	}
	
	@Override
	public String toString() {
		return "Ноутбук "+model+" "
				+ " ОЗУ: "+ram+" " 
				+ " Жесткий диск: "+hdd+""
				+ " Операционная система: "+os+""
				+ " Цвет: "+colour;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model= model;		
	}
	
	public int getRAM() {
		return ram;
	}
	
	public void setRAM(int ram) {
		this.ram= ram;		
	}
	
	public int getHDD() {
		return hdd;
	}
	
	public void setHDD(int hdd) {
		this.hdd= hdd;
	}
	
	public String getOS() {
		return os;
	}
	
	public void setOS(String os) {
		this.os = os;		
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;		
	}
	
	 
	
	
	

}
