package br.com.bitwaysystem.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalogo {
	
	@XmlElementWrapper(name = "CdPt")
	private List<CdPt>  cdItem;

	public List<CdPt> getCdItem() {
		return cdItem;
	}

	public void setCdItem(List<CdPt> cdItem) {
		this.cdItem = cdItem;
	}

}
