package logic;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import estructurasDatos.Arbol;

public class Parser {

	public static void main(String[] args) throws Exception 
	{
		Arbol arbol = new Arbol<String, String>();
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
					System.out.println("la instruccion \""+st+"\" es invalida");
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
					System.out.println("la instruccion \""+st+"\" es invalida");
				}
				break;
			case "(look":

				String cardinal =  linea [1];
				if(cardinal.equals("N)")||cardinal.equals("E)")||cardinal.equals("W)")||cardinal.equals("S)"))
				{


				}
				else {
					valido=false;
					System.out.println("la instruccion \""+st+"\" es invalida");
				}
				break;

			case "(drop":
				try {
					String numeroDS= linea[1].substring(0, linea[1].length()-1);
					int numeroD = Integer.parseInt(numeroDS);

				}
				catch (Exception e) {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}
				break;

			case "(free":
				try {
					String numeroFS= linea[1].substring(0, linea[1].length()-1);
					int numeroF = Integer.parseInt(numeroFS);

				}
				catch (Exception e) {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}
				break;
			case "(pick":
				try {
					String numeroPS= linea[1].substring(0, linea[1].length()-1);
					int numeroP = Integer.parseInt(numeroPS);

				}
				catch (Exception e) {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}
				break;
			case "(grab":
				try {
					String numeroPS= linea[1].substring(0, linea[1].length()-1);
					int numeroP = Integer.parseInt(numeroPS);

				}
				catch (Exception e) {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}
				break;

			case "(walkTo":
				try {
					String numeroPS= linea[1];
					int numeroP = Integer.parseInt(numeroPS);


				}
				catch (Exception e) {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}			

				String direccion2 = linea[2];
				if(direccion2.equals("N)")||direccion2.equals("E)")||direccion2.equals("W)")||direccion2.equals("S)"))
				{

				}
				else {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido= false;
				}
				break;
			case "(NOP)":
				break;
			case "(define": 
				if (linea.length==3) {
					String check = st.substring(1, st.length()-1);
					if (check.contains("("))
					{

					}
					else if(!check.contains("(")) {

						arbol.put(linea[1], linea[2].substring(0,linea[2].length()-1));

					}
				}
				else {
					System.out.println("la instruccion \""+st+"\" es invalida");
					valido=false;
				}
				break;
			default:
				valido=false;
				System.out.println("el codigo ingresado no es valido");
				break;
			}
			st=br.readLine();
		}
		br.close();
		if(valido){
			System.out.println("el codigo ingresado es valido");
		}



	}
}