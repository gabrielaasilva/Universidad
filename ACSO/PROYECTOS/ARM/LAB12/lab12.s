.data

.balign 4
a:		.word	0
.balign 4
b:		.word	0
.balign 4
c:		.word	0
.balign 4
x:		.word	0
.balign 4
answer:		.word	0
.balign 4
cero:		.word	0
.balign 4
main_ret:	.word	0
.balign 4
scanf_format:	.asciz "%d"
.balign 4
printf_format:	.asciz "%d"

.text
.global main
.global printf
.global scanf
.func	main
main:	
	LDR	R0, =main_ret
	STR	LR, [R0]
	
	LDR	R0, =scanf_format
	LDR	R1, =a
	BL	scanf

	LDR	R0, =scanf_format
	LDR	R1, =b
	BL	scanf

	LDR	R0, =scanf_format
	LDR	R1, =c
	BL	scanf

	LDR	R0, =scanf_format
	LDR	R1, =x
	BL	scanf

	LDR	R1, =a
	LDR	R1, [R1]

	LDR	R2, =b
	LDR	R2, [R2]

	LDR	R3, =c
	LDR	R3, [R3]

	LDR	R4, =x
	LDR	R4, [R4]

	MUL	R5,R4,R4
	LDR	R0, =answer
	STR	R5, [R0]

	MUL	R6,R1,R5
	LDR	R0, =answer
	STR	R6, [R0]
 
	MUL	R7,R2,R4
	LDR	R0, =answer
	STR	R7, [R0]

	ADD	R8,R6,R7
	LDR	R0, =answer
	STR	R8, [R0]

	ADD	R9,R8,R3
	LDR	R0, =answer
	STR	R9, [R0]

	LDR	R0, =printf_format
	LDR	R1, =answer
	LDR	R1,[R1]
	BL	printf

	LDR	R0, =cero
	LDR	R0, [R0]

	LDR	LR, =main_ret
	LDR	LR, [LR]

	BX	LR

.end





	 





	





	




