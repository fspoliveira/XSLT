package br.com.bitwaysystem.xslt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

public class XSLT {
	
	 /**
     * Transforms one JAXB object into another with an XSLT Source
     * 
     * @param src
     *            The source (JAXB)object to transform
     * @param xsltSrc
     *            Source of the XSLT to use for transformation
     * @return The transformed (JAXB)object
     */
    @SuppressWarnings("unchecked")
    public static <T, U> U transformObject(final T src, final Source xsltSrc, final Class<U> clazz) {
        try {
            final JAXBSource jxSrc = new JAXBSource(JAXBContext.newInstance(src.getClass()), src);
            final TransformerFactory tf = new net.sf.saxon.TransformerFactoryImpl();
            final Transformer t = tf.newTransformer(xsltSrc);
            final JAXBResult jxRes = new JAXBResult(JAXBContext.newInstance(clazz));
            t.transform(jxSrc, jxRes);
            final U res = (U) jxRes.getResult();
            return res;

        } catch (JAXBException | TransformerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
