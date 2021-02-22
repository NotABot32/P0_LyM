import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Parser {
	
	private void validarWalk(ArrayList var, String valor, boolean validez )
	{
		if(var.contains(valor.substring(0, valor.length()-1)))
		{
			
		}
		else
		{
			try {
			String numeroWS= valor.substring(0, valor.length()-1);
			int numeroW = Integer.parseInt(numeroWS);
		
			}
			catch (Exception e) {
				System.out.println("El codigo para \"walk\" es inválido");
				validez=false;
			}
		}
	}
	public static void main(String[] args) throws Exception 
	{
		boolean valido = true; 
		File f = new File("data/comandos.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st = br.readLine();
		ArrayList<String> metodos = new ArrayList();
		ArrayList<String> variables = new ArrayList();

		while(st != null && valido)
		{
			String[] linea = st.split(" ");
			switch (linea[0]) {
			
			case "(walk":
				
				 if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{
					try {
					String numeroWS= linea[1].substring(0, linea[1].length()-1);
					int numeroW = Integer.parseInt(numeroWS);
				
					}
					catch (Exception e) {
						System.out.println("El codigo para \"walk\" es inválido");
						valido=false;
					}
				}			
				break;
			case "(rotate": 

				String direccion = linea[1];
				if(direccion.equals("left)")|| direccion.equals("right)")|| direccion.equals("back)"))
				{				
					
				}
				else {
					valido=false;
					System.out.println("El código para \"rotate\" es inválido");	
				}
				break;
			case "(look":
			
				String cardinal =  linea [1];
				if(cardinal.equals("N)")||cardinal.equals("E)")||cardinal.equals("W)")||cardinal.equals("S)"))
				{
					
					
				}
				else {
					valido=false;
					System.out.println("El código para \"look\" es inválido");
				}
				break;
				
			case "(drop":
				if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{
					try {
						String numeroDS= linea[1].substring(0, linea[1].length()-1);
						int numeroD = Integer.parseInt(numeroDS);
					
						}
						catch (Exception e) {
							System.out.println("El código para \"drop\" es inválido");
							valido=false;
						}					
				}
				
				break;
				
			case "(free":
				if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{

					try {
						String numeroFS= linea[1].substring(0, linea[1].length()-1);
						int numeroF = Integer.parseInt(numeroFS);
						
						}
						catch (Exception e) {
							System.out.println("El código para \"free\" es inválido");
							valido=false;
						}
				}
				break;
			case "(pick":
				if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{

					try {
						String numeroPS= linea[1].substring(0, linea[1].length()-1);
						int numeroP = Integer.parseInt(numeroPS);
						
						}
						catch (Exception e) {
							System.out.println("El código para \"pick\" es inválido");
							valido=false;
						}
				}
				break;
			case "(grab":
				if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{
					try {
						String numeroPS= linea[1].substring(0, linea[1].length()-1);
						int numeroP = Integer.parseInt(numeroPS);
					
						}
						catch (Exception e) {
							System.out.println("El código para \"grab\" es inválido");
							valido=false;
						}	
				}
				break;
				
			case "(walkTo":
				if(variables.contains(linea[1].substring(0, linea[1].length()-1)))
				{
					
				}
				else
				{
					try {
						String numeroPS= linea[1];
						int numeroP = Integer.parseInt(numeroPS);
						
						
						}
						catch (Exception e) {
							System.out.println("El código para \"walkTo\"es inválido");
							valido=false;
						}
				}			
				
				String direccion2 = linea[2];
				if(direccion2.equals("N)")||direccion2.equals("E)")||direccion2.equals("W)")||direccion2.equals("S)"))
				{
					
				}
				else {
					System.out.println("El código para \"walkTo\" es inválido");
					valido= false;
				}
					break;
			case "(NOP)":
				break;
			case "(if":
				switch (linea[1]) {
				case "(blocked?)":
										
					break;
				case "(facing?":
					String direccion3 = linea[2];
					if(direccion3.equals("N)")||direccion3.equals("E)")||direccion3.equals("W)")||direccion3.equals("S)"))
					{
						
					}
					else {
						System.out.println("El código para \"if\" es inválido");
						valido= false;
					}
					break;
				case "(can":
					String accion = linea[2];
					if(accion.equals("drop)")||accion.equals("grab)")||accion.equals("free)")||accion.equals("pick)"))
					{
						
					}
					else
					{
						System.out.println("El código para \"if\" es inválido");
						valido= false;
					}
					break;
				case "(not":
					switch (linea[2]) {
					case "(blocked?))":				
					break;
					case "(facing?":						
						String direccion4 = linea[3];
						if(direccion4.equals("N))")||direccion4.equals("E))")||direccion4.equals("W))")||direccion4.equals("S))"))
						{
							
						}
						else {
							System.out.println("El código para \"if\" es inválido");
							valido= false;
						}
						break;
					case "(can":
						String accion2 = linea[3];
						if(accion2.equals("drop)")||accion2.equals("grab)")||accion2.equals("free)")||accion2.equals("pick)"))
						{
							
						}
						else
						{
							System.out.println("El código para \"if\" es inválido");
							valido= false;
						}
						break;
					default:
						System.out.println("El código para \"if\" es inválido");
						valido= false;
						break;
					}
					break;
				default:
					System.out.println("El código para \"if\" es inválido");
					valido= false;
					break;
				}
				break;
			case "(define":
				if(linea[1].contains("("))
				{
					int posicion = linea[1].indexOf("(");
					String nuevoMetodo = linea[1].substring(0, posicion);
				}
				else
				{
					variables.add(linea[1]);
				}
				break;
			default:
				valido=false;
				System.out.println("El inicio del código ingresado no es válido");
				break;
			}
			st=br.readLine();
		}
		br.close();
		if(valido){
			System.out.println("El código ingresado es válido");
		}
	
		
	
}
}