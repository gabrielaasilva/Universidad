#include <stdio.h>
#include <stdlib.h>

int main(void){
	float valor1, valor2,mayor;
	int i,valor3;
	
	scanf("%d",&valor3);

	for (i=0;i<valor3;i++){
		scanf("%f",&valor1);
		scanf("%f",&valor2);
	
		if(valor1>valor2){
			mayor = valor1;
		}else{
			mayor =valor2;
		}
		
		printf("%f\n",mayor);
	}
	

	
	return EXIT_SUCCESS;

}