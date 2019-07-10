package co.com.sil;

/**
 *   Punto de partida
 *   <br>
 * 	 <h3>Licencia: </h3>
 * 	 <p>
 * 	 This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see {@literal <http://www.gnu.org/licenses/>}
 *   </p>
 *   @author Alejandro Lindarte Castro
 *
 */
public class Main 
{

	/**
	 * Punto de partida (main)
	 * 
	 * 
	 * @param args, Argumentos dinamicos
	 */
	public static void main(String[] args) 
	{
		try
		{
			if(args == null || args.length == 0 || args.length > 2)
			{
				throw new Exception("Empty args no valid!");
			}
			
			String mi_cadena		 = args[0];
			
			String tipo = args[1];
			
			String desencriptado = new String();
			String encriptado = new String();
			System.out.println("Cadena: ");
			System.out.println("Accion ".append(tipo).append(" : "));
			
			System.out.println(mi_cadena);
			
			if(tipo.equalsIgnoreCase("DES"))
			{
				desencriptado 	 = desencriptar(encriptado);
				System.out.println(desencriptado);
			}
			else if(tipo.equalsIgnoreCase("ENC"))				
			{
				encriptado 	 = encriptar(mi_cadena);																	
				System.out.println(encriptado);
			}else
			{
				throws new IllegalArgumentException("Param 2 between DES AND ENC value's");
			}
						
			
		}catch(Exception ex)
		{
			System.err.println(ex.getMessage());			
		}

	}//main
	
	/**
	 * Encargado de encriptar una cadena en literales
	 * @param mi_cadena, Cadena original
	 * @return cadena encriptada con algoritmo SIL
	 * @throws Exception 
	 */
	public static String encriptar(String mi_cadena) throws Exception
	{
		SIL sil = new SIL();
		String encriptado = sil.encriptar(mi_cadena);
		
		return encriptado;
	
	}//encriptar
	
	/**
	 * Encargado de desencriptar la cadena y devolverla en su estado original
	 * @param mi_cadena_encriptada, String encriptado
	 * @return cadena original
	 * @throws Exception, Error en la integridad de la cadena
	 */
	public static String desencriptar(String mi_cadena_encriptada) throws Exception
	{
		SIL sil = new SIL();
		String desencriptada = sil.desencriptar(mi_cadena_encriptada);
		
		return desencriptada;
		
	}//desencriptar

}//NoBorrar
