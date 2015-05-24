package br.com.bitwaysystem.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import br.com.bitwaysystem.bean.Catalogo;
import br.com.bitwaysystem.bean.CdEn;
import br.com.bitwaysystem.bean.Catalog;
import br.com.bitwaysystem.bean.CdPt;
import br.com.bitwaysystem.xslt.XSLT;

public class Main {

	public static void main(String[] args) throws JAXBException, IOException {

		Source xsltSrc = new StreamSource(new File(
				"src/main/java/br/com/bitwaysystem/xslt/CdEnToCdPt.xsl"));

		CdEn cd1 = new CdEn();
		cd1.setArtist("Bob Dylan");
		cd1.setCompany("Columbia");
		cd1.setCountry("USA");
		cd1.setPrice("10.90");
		cd1.setYear("1985");
		cd1.setTitle("Empire Burlesque");

		CdEn cd2 = new CdEn();
		cd2.setArtist("AC/DC");
		cd2.setCompany("Sony");
		cd2.setCountry("USA");
		cd2.setPrice("20.00");
		cd2.setYear("1980");
		cd2.setTitle("Back in Black");

		List<CdEn> catalog = new ArrayList<>();

		catalog.add(cd1);
		catalog.add(cd2);

		Catalog c1 = new Catalog();

		c1.setCatalog(catalog);

		for (CdEn cat : c1.getCatalog()) {
			System.out.println(cat.getArtist());
		}

		// Marshal Examples
		JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.marshal(c1, new File("catalogMarshal.xml"));

		// Transform Examples
		Catalogo c2 = XSLT.transformObject(c1, xsltSrc, Catalogo.class);

		for (CdPt cat : c2.getCdItem()) {
			System.out.println(cat.getArtista());
		}

	}

}
