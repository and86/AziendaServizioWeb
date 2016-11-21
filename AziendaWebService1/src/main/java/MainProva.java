
import java.text.SimpleDateFormat;
import java.util.Date;

import it.alfasoft.andrea.model.Fattura;
import it.alfasoft.andrea.service.Servizio;


public class MainProva {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
		
//		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date d=new Date();
		
//		System.out.println(d);
			
		Fattura f1=new Fattura(d,"aaa",1000);
		Fattura f2=new Fattura(d,"bbb",2000);
		Fattura f3=new Fattura(d,"ccc",3000);
		Fattura f4=new Fattura(d,"ddd",4000);
		
		s.registraFattura(f1);
		s.registraFattura(f2);
		s.registraFattura(f3);
		s.registraFattura(f4);
	
		
		
		
	}

}
