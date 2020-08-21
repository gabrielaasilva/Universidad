#include <stdio.h>


int *lectura(int *vector, int longitud){
	int i;
	
	for(i=0;i<longitud;i++){	
	scanf("%d",&vector[i]);
	}
	
	return vector;
}

int suma (int *vector, int longitud){
	int i, suma=0;
	
	for(i=0;i<longitud;i++){
		suma += vector[i];
		
	}
	return suma;
}

int main(){
	int i, casos, longitud;
	
	scanf("%d",&casos);
	
	for(i=0;i<casos;i++){
		scanf("%d",&longitud);
		
		int vector[longitud];
	
		int *vectorCompleto = lectura(vector,longitud);
	
		printf("%d\n", suma(vectorCompleto, longitud));
	}
	
	return 0;
}