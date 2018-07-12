package co.com.sil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

/**
 * Metodos matriciales
 * @author Alejandro Lindarte Castro
 *
 */
public class Matrix 
{
	private Map<String, Integer> mapa;
	private ArrayList<String> letras;
	private ArrayList<String> numeros;
	
	public Matrix(ArrayList<String> letras, ArrayList<String> numeros)
	{
		this.letras  = letras;
		this.numeros = numeros;
		
		mapaLetrasNumero();
		
	}//constructor
	
	/**
	 * Key value de las letras y numeros
	 * @return
	 */
	private Map<String, Integer> mapaLetrasNumero()
	{
		this.mapa = new HashMap<String, Integer>();
		int i = 0;
		for(; i < this.letras.size() ; i++) 
		{			
			this.mapa.put(this.letras.get(i), i);
		}
		
		//Numeros
		for(int  j = 0; j < this.numeros.size() ; j++)
		{
			this.mapa.put(this.numeros.get(j), i);
			i++;
		}
		
		return this.mapa;
		
	}//mapaLetrasNumero
	
	/**
	 * 
	 * @param letter
	 * @return
	 */
	private String getLetterFromNumber(int number) throws Exception
	{
		Optional<Entry<String, Integer>> entry_set = mapa.entrySet().stream().filter(map -> map.getValue() == number).findFirst();
		if(entry_set.isPresent())
		{
			return entry_set.get().getKey();
			
		}else
		{
			throw new Exception("No se encuentra la llave para el valor: "+number);
		}
				
	}//getNumberFromLetter

	/**
	 * 
	 * @param letter
	 * @return
	 */
	private Integer getNumberFromLetter(String letter) throws Exception
	{
		return mapa.get(letter) > mapa.size() ? 0 : mapa.get(letter);
		
	}//getNumberFromLetter
	
	/**
	 * Convierte una cadena en matrices
	 * @param cadena
	 */	
	protected String calculo_matricial(String cadena)
	{
		final int filas    		= 3;
		final int columnas 		= 3;
		int contador_filas 		= 0;
		int contador_columnas	= 0;	
		int llenar_vacios		= 0;
		int tamano_ideal		= 9;
		boolean entro 			= false;
		char _default           = '\0';		
		//double numero_aureo		= numeroAureo();
		String cadena_final		= new String();
		char[][] matriz 					= new char[filas][columnas];
		List<char[][]> matrices 			= new ArrayList<char[][]>();	
		
		//Llenamos las matrices
		for(char a: cadena.toCharArray())
		{			
			llenar_vacios++;
			matriz[contador_filas][contador_columnas] = a;
			if(contador_filas + 1 == filas && contador_columnas + 1 == columnas)//ya cumplio las filas 
			{
				contador_filas 	  = 0;
				contador_columnas = 0;
				matrices.add(matriz);
				matriz 	= new char[filas][columnas];
				entro = true;
				continue;
			}else if(contador_filas + 1 == filas)
			{
				entro = false;
				contador_columnas++;
				contador_filas = 0;
				continue;
			}
			
			contador_filas++;
									
		}//for
		
		if(!entro) 
		{			
			matrices.add(matriz);			
		}				
		
		int tamano_matriz = matrices.size() * tamano_ideal; 
		int diferencia 	  = tamano_matriz - llenar_vacios;		
		char[][] matriz_r = matrices.get(matrices.size() - 1);//la ultima matriz
		
		//Llenamos el resto de la matriz ultima, con vacios		
		while(diferencia > 0)
		{			
			matriz_r[contador_filas][contador_columnas] = _default;			
			if(contador_filas + 1 == filas)
			{
				entro = false;
				contador_columnas++;
				contador_filas = 0;
				diferencia--;
				continue;
			}
			contador_filas++;
			diferencia--;
			
		}//while				
		
		//Pintamos las matrices y trasponemos las matrices
		for(char[][] matriz_i: matrices)
		{
			char[][] matriz_traspuesta 	= new char[filas][columnas];
			int[][] matriz_numerica		= new int[filas][columnas];
			
			for(int i = 0; i < filas; i++)
			{
				for(int j = 0; j < columnas; j++)
				{
					int number = 0;
					matriz_traspuesta[j][i] = matriz_i[j][i];
					char actual = matriz_traspuesta[j][i];
					try
					{
						if((actual + "").equalsIgnoreCase(_default + ""))
						{
							continue;
						}
						number = getNumberFromLetter(actual + "");
						//number = number + 1;
						String cadena_t = getLetterFromNumber(number);
						cadena_final += cadena_t;
						matriz_numerica[j][i] = number;
						
					}catch(Exception ex)
					{
						number = 99;						
					}			
					
				}//for
				
			}//for
			
		}//for
		
		return cadena_final;
				
		
	}//calculo_matricial
	
	/**
	 * Reverse
	 * @param cadena
	 * @return
	 * @throws Exception
	 */	
	protected String calculo_matricial_r(String cadena) throws Exception
	{
		final int filas    		= 3;
		final int columnas 		= 3;
		int contador_filas 		= 0;
		int contador_columnas	= 0;	
		int llenar_vacios		= 0;
		int tamano_ideal		= 9;
		boolean entro 			= false;
		char _default           = '\0';		
		//double numero_aureo		= numeroAureo();
		String cadena_final		= new String();
		char[][] matriz 					= new char[filas][columnas];
		List<char[][]> matrices 			= new ArrayList<char[][]>();			
		
		//Llenamos las matrices
		for(char a: cadena.toCharArray())
		{			
			llenar_vacios++;
			matriz[contador_filas][contador_columnas] = a;
			if(contador_filas + 1 == filas && contador_columnas + 1 == columnas)//ya cumplio las filas 
			{
				contador_filas 	  = 0;
				contador_columnas = 0;
				matrices.add(matriz);
				matriz 	= new char[filas][columnas];
				entro = true;
				continue;
			}else if(contador_filas + 1 == filas)
			{
				entro = false;
				contador_columnas++;
				contador_filas = 0;
				continue;
			}
			
			contador_filas++;
									
		}//for
		
		if(!entro) 
		{			
			matrices.add(matriz);			
		}				
		
		int tamano_matriz = matrices.size() * tamano_ideal; 
		int diferencia 	  = tamano_matriz - llenar_vacios;		
		char[][] matriz_r = matrices.get(matrices.size() - 1);//la ultima matriz
		
		//Llenamos el resto de la matriz ultima, con vacios		
		while(diferencia > 0)
		{			
			matriz_r[contador_filas][contador_columnas] = _default;			
			if(contador_filas + 1 == filas)
			{
				entro = false;
				contador_columnas++;
				contador_filas = 0;
				diferencia--;
				continue;
			}
			contador_filas++;
			diferencia--;
			
		}//while	
		
		//Pintamos las matrices y trasponemos las matrices
		for(char[][] matriz_i: matrices)
		{
			char[][] matriz_traspuesta 	= new char[filas][columnas];
			int[][] matriz_numerica		= new int[filas][columnas];
			
			for(int i = 0; i < filas; i++)
			{
				for(int j = 0; j < columnas; j++)
				{					
					int number = 0;
					matriz_traspuesta[j][i] = matriz_i[j][i];
					char actual = matriz_traspuesta[j][i];
					if((actual + "").equalsIgnoreCase(_default + ""))
					{
						continue;
					}
					try
					{							
						number = getNumberFromLetter(actual + "");						
						//number = number - 1;						
						String cadena_t = getLetterFromNumber(number);
						cadena_final += cadena_t;
						matriz_numerica[j][i] = number;
						
					}catch(Exception ex)
					{
						number = 99;						
					}			
					
				}//for
				
			}//for
			
			
		}//for
		
		return cadena_final;
		
	}//calculo_matricial_r

}//NoBorrar
