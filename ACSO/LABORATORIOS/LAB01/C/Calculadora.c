#include <stdio.h>



void suma(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1 +num12;

	
	printf("%f\n",ans);
	
	return 0;
}

void resta(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1-num12;

	
	printf("%f\n",ans);
	
	return 0;
}

void multiplicacion(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1*num12

	
	printf("%f\n",ans);
	
	return 0;
}

float division(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	if(numero2 == 0){
		printf("Indefinido");	
	}else{
		ans = numero1/numero2;
	}

	printf("%f\n",ans);
	
	return 0;
}

int main(){
	char op;
	float answer;
	int numOperaciones;
	
	scanf("%d",&numOperaciones);
	for(i=0;i<numOperaciones;i++){
		scanf("%c",&op);
	
		if(op == '+'){
			suma();
		}else if(op== '-'){
			resta();
		}else if(op == '*'){
			multiplicacion();
		}else if(op=='/'){
			division();
		}
	}
	
	return 0;
}



