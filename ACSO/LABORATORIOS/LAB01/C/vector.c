#include <stdio.h>

int main(void){
	int longitud,i,j;
	
	
	printf("Ingrese la longitud del vector: ");
	scanf("%d",&longitud);
	
	float vector[longitud];
	
	
	for(i=0;i<longitud;i++){
		
		printf("Ingrese número: ");
		scanf("%f",&vector[i]);
	}
	
	float menor = vector[0];
	
	for(j=0;j<longitud;j++){
		if(vector[j]<menor){
			menor = vector[j];
		}
	}
	
	printf("El numero menor en el vector. es %f\n",menor);
	
	return 0;
}
	