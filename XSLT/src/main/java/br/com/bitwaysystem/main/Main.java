package br.com.bitwaysystem.main;

import java.util.ArrayList;
import java.util.List;

import br.com.bitwaysystem.bean.CD;
import br.com.bitwaysystem.bean.Catalog;

public class Main {

	public static void main(String[] args) {
		CD cd1 = new CD();

		cd1.setArtist("Bob Dylan");
		cd1.setCompany("Columbia");
		cd1.setCountry("USA");
		cd1.setPrice("10.90");
		cd1.setYear("1985");
		cd1.setTitle("Empire Burlesque");

		CD cd2 = new CD();

		cd2.setArtist("AC/DC");
		cd2.setCompany("Sony");
		cd2.setCountry("USA");
		cd2.setPrice("20.00");
		cd2.setYear("1980");
		cd2.setTitle("Back in Black");

		List<CD> catalog = new ArrayList<>();

		catalog.add(cd1);
		catalog.add(cd2);

		Catalog c = new Catalog();

		c.setCatalog(catalog);

		for (CD cat : c.getCatalog()) {
			System.out.println(cat.getArtist());
		}

	}

}
