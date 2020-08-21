#include <stdio.h>

int suma(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1 +num2;

	
	printf("%f\n",ans);
	
	return 0;
}

int resta(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1-num2;

	
	printf("%f\n",ans);
	
	return 0;
}

int multiplicacion(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	ans = num1*num2;

	
	printf("%f\n",ans);
	
	return 0;
}

int division(){
	float num1, num2, ans = 0;
	
	scanf("%f",&num1);
	scanf("%f",&num2);
	
	if(num2 == 0){
		printf("Indefinido \n");	
	}else{
		ans = num1/num2;
		printf("%f\n",ans);
	}
	return 0;
}

int main(void){
	char op[2];
	float answer;
	int i,numOperaciones;
	
	scanf("%d",&numOperaciones);
	
	for(i=0;i<numOperaciones;i++){
		scanf("%s",op);
	
		if(op[0] == '+'){
			suma();
		}else if(op[0]== '-'){
			resta();
		}else if(op[0] == '*'){
			multiplicacion();
		}else if(op[0]=='/'){
			division();
		}
	}
	
	return 0;
}



