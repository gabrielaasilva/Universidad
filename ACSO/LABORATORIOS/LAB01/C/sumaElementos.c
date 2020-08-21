#include <stdio.h>


int *lectura(int *vector, int longitud){
	int i;
	
	for(i=0;i<longitud;i++){	
	printf("Ingrese número: ");
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
	int longitud;
	
	printf("Ingrese la longitud del vector: ");
	scanf("%d",&longitud);
	int vector[longitud];
	
	int *vectorCompleto = lectura(vector,longitud);
	
	printf("La suma de los número dentro del vector es %d\n", suma(vectorCompleto, longitud));
	
	return 0;
}



