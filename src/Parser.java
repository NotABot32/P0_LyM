import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser {
	public static void main(String[] args) throws Exception 
	{
		boolean valido = true; 
		File f = new File("data/comandos.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st = br.readLine();
		

		while(st != null && valido)
		{
			String[] linea = st.split(" ");
			switch (linea[0]) {
			
			case "(walk":
				try {
				String numeroWS= linea[1].substring(0, linea[1].length()-1);
				int numeroW = Integer.parseInt(numeroWS);
			
				}
				catch (Exception e) {
					
					valido=false;
				}
				
				break;
			case "(rotate": 

				String direccion = linea[1];
				if(direccion.equals("left)")|| direccion.equals("right)")|| direccion.equals("back)"))
				{				
					
				}
				else {
					valido=false;
						
				}
				break;
			case "(look":
			
				String cardinal =  linea [1];
				if(cardinal.equals("N)")||cardinal.equals("E)")||cardinal.equals("W)")||cardinal.equals("S)"))
				{
					
					
				}
				else {
					valido=false;
					
				}
				break;
				
			case "(drop":
				try {
				String numeroDS= linea[1].substring(0, linea[1].length()-1);
				int numeroD = Integer.parseInt(numeroDS);
			
				}
				catch (Exception e) {
					
					valido=false;
				}
				break;
				
			case "(free":
				try {
					String numeroFS= linea[1].substring(0, linea[1].length()-1);
					int numeroF = Integer.parseInt(numeroFS);
					
					}
					catch (Exception e) {
						
						valido=false;
					}
				break;
			case "(pick":
				try {
					String numeroPS= linea[1].substring(0, linea[1].length()-1);
					int numeroP = Integer.parseInt(numeroPS);
					
					}
					catch (Exception e) {
						
						valido=false;
					}
				break;
			case "(grab":
				try {
					String numeroPS= linea[1].substring(0, linea[1].length()-1);
					int numeroP = Integer.parseInt(numeroPS);
				
					}
					catch (Exception e) {
						
						valido=false;
					}
				break;
				
			case "(walkTo":
				try {
					String numeroPS= linea[1];
					int numeroP = Integer.parseInt(numeroPS);
					
					
					}
					catch (Exception e) {
						
						valido=false;
					}			
				
				String direccion2 = linea[2];
				if(direccion2.equals("N)")||direccion2.equals("E)")||direccion2.equals("W)")||direccion2.equals("S)"))
				{
					
				}
				else {
					
					valido= false;
				}
					break;
			case "(NOP)":
				break;
			default:
				valido=false;
				
				break;
			}
			st=br.readLine();
		}
		br.close();
		if(valido){
			System.out.println("el codigo ingresado es valido");
		}
		else 
		System.out.println("el codigo ingresado no es valido");
		
	
}
}
