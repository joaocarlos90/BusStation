//BUSSTATION ****JOAO****
package busstation;

import java.util.Scanner;

class BusStation{
public static void main(String[] args){
int tamanho;  // tamanho do onibus  
int soma = 0;

Scanner entrada = new Scanner(System.in);
System.out.println("Informe o tamanho do onibus: ");
tamanho = entrada.nextInt();
            
System.out.println("Informe os grupos");
Scanner entrada2 = new Scanner(System.in);
int[] grupos = new int[tamanho];
		
//recebendo os grupos
for(int indice=0 ; indice < tamanho ; indice++){
System.out.println("\nTamanho dos grupos " + (indice+1) + ": ");
grupos[indice] = entrada2.nextInt();
soma += grupos[indice];
}
          
for (int x = 1; x <= soma; x++)
{
boolean possivelfinal = true;
int anterior = 0;                    
int qtdviagens = 0;
for (int i = 0; i < tamanho; i++)
{
int grupoatual = grupos[i];
if (grupoatual > x)
{
possivelfinal = false;
break;
}
else if (grupoatual < x)
{
if (anterior != 0)
{
int s = grupoatual + anterior;
if (s > x)
{
possivelfinal = false;
break;
}
else if (s < x)
{
anterior = s;
}
else
{
anterior = 0;
qtdviagens++;
}
}
else
{
anterior = grupoatual;
}
}
else if (grupoatual == x)
{
qtdviagens++;
}
}
//resultado total de viagens
int total = qtdviagens * x;
int resto = soma - total;
if (possivelfinal && resto == 0)
{
System.out.print(x + " ");
}
}
}
}