#include <stdio.h>

int productPunto(float vector1[],float vector2[],int longitud){
    int j;
    float ans, suma = 0;
    float vectorRes[longitud];
    for (j=0;j<longitud;j++){
        ans = vector1[j]*vector2[j];
        vectorRes[j] = ans;
    }
    for(j=0;j<longitud;j++){
        suma += vectorRes[j];
    }

    printf("%f\n",suma);
    return 0;
}

int main(void){
    int i,j,k,casos,longitud;

    scanf("%d",&casos);

    for (i=0;i<casos;i++){	
        scanf("%d",&longitud);
        float vector1[longitud];
        float vector2[longitud];

        for (j=0;j<longitud;j++){
            scanf("%f",&vector1[j]);
        }

        for (k=0;k<longitud;k++){
            scanf("%f",&vector2[k]);
        }
        productPunto(vector1,vector2,longitud);

    }

    return 0;
}		
		
		
		
		
			
	