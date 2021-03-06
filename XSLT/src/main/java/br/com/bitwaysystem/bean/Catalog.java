package br.com.bitwaysystem.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

	@XmlElementWrapper(name = "CdEn")
	private List<CdEn> cdItem;

	public List<CdEn> getCatalog() {
		return cdItem;
	}

	public void setCatalog(List<CdEn> catalog) {
		this.cdItem = catalog;
	}

}
