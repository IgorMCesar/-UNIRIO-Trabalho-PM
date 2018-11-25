package vistas;

import utilidades.XML;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XML.lerXml("curriculo.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
