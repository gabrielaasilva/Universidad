#include <stdio.h>

float main(void){
	float valor1, valor2, mayor;
	
	
	printf("Ingrese valor uno: ");
	scanf("%f",&valor1);
	printf("Ingrese valor dos: ");
	scanf("%f",&valor2);
	
	if(valor1>valor2){
		mayor = valor1;
	}else{
		mayor =valor2;
	}
	
	printf("EL mayor eentre estos números es: %f\n ",mayor);
	
	return 0;
	
}