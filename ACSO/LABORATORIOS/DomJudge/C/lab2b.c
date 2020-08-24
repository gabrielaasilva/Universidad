#include <stdio.h>

float suma (float *vectorRespuestas, int longitud){
	float suma=0;
	int i;
	
	for(i=0;i<longitud;i++){
		suma += vectorRespuestas[i];
		
	}
	return suma;
}

int main(void){
	int casos, longitud, i, j,k,l,h;
	float resultado1, resultadoTotal;
	
	scanf("%d",&casos);
	
	for (i=0;i<casos;i++){
		scanf("%d",&longitud);
		float vector1[longitud];
		float vector2[longitud];
		float vectorRespuestas[longitud];
		
		for(j=0;j<longitud;j++){
		scanf("%f",&vector1[j]);	
		}
		
		for(k=0;k<longitud;k++){
		scanf("%f",&vector2[j]);	
		}
		
		for(l=0;l<longitud;l++){
			resulado1 =  vector1[l]*vector2[l];
			for(h=0;h<longitud;h++){
				vectorRespuestas[h] = resultado1;
			}
		}	
		
		resultadoTotal = suma(vectorRespuestas,longitud);
		printf("%f\n" ,resultadoTotal);
	}
	return 0;
}