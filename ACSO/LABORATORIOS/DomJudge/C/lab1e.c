#include <stdio.h>

int main(void){
	int casos,longitud,i,j,k;
	
	
	scanf("%d",&casos);
	
	for (i=0;i<casos;i++){
		scanf("%d",&longitud);
		float vector[longitud];
		
		for(j=0;j<longitud;j++){
		scanf("%f",&vector[j]);	
		}
		
		float menor = vector[0];
	
		for(k=0;k<longitud;k++){
		if(vector[k]<menor){
			menor = vector[k];
			}
		}
		printf("%f\n" ,menor);
		
	}
	
	return 0;
}
	