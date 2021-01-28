.data

.balign 4
main_ret:		.word	0

.balign 4
a:			.word	0

.balign	4
b:			.word	0 

.balign	4
c:			.word	0

.balign	4
ans:			.word	0

.balign	4
diezmil:		.word	10000

.balign	4
mil:			.word	1000

.balign	4
cero:			.word	0

.balign	4
one:			.word	1

.balign 4
format_scanf:           .asciz  "%d"

.balign 4
format_printf:          .asciz  "%d"


.text

.global scanf
.global printf
.global main
.func	main
 
main:		LDR		R0,=main_ret
		STR		LR,[R0]		
		LDR		R0,=b
		MOV		R1,#1000
		STR		R1,[R0]
		LDR		R0,=format_scanf
		LDR		R1,=a
		BL		scanf
		LDR		R1,=a
		LDR		R1,[R1]
		LDR		R2,=diezmil
		LDR		R2,[R2]
		MUL		R3,R1,R2	
		LDR		R0,=a	
		STR		R3,[R0]	
		
op1:
		LDR		R1,=a
		LDR		R1,[R1]
		LDR		R2,=b
		LDR		R2,[R2]
		MOV		R3,#0	

division:	SUBS		R1,R1,R2
		ADD		R3,R3,#1
		
		BPL		division
		ADD		R4,R1,R2	
		SUBS		R3,R3,#1	
		
		LDR		R0,=ans
		STR		R3,[R0]
		
		LDR		R1,=b
		LDR		R1,[R1]

		LDR		R2,=ans
		LDR		R2,[R2]
		ADD		R4,R1,R2
		
		LDR		R0,=ans
		STR		R4,[R0]	
		LDR		R1,=ans
		LDR		R1,[R1]

		MOV		R2,#2
		MOV		R3,#0

div_op2:	SUBS		R1,R1,R2
		ADD		R3,R3,#1
		
		BPL		div_op2
		ADD		R4,R1,R2	 
		SUBS		R3,R3,#1	
		
		LDR		R0,=b
		STR		R3,[R0]		 
						
		LDR		R1,=b
		LDR		R1,[R1]	
		LDR		R2,=c
		LDR		R2,[R2]
		CMP		R1,R2
		BEQ		run
		BNE		stop

run:		LDR		R0,=format_printf
		LDR		R1,=b
		LDR		R1,[R1]
		BL		printf
		B		end	

stop:		LDR		R1,=b
		LDR		R1,[R1]
		LDR		R0,=c
		STR		R1,[R0]
		B		op1
end:		
		MOV		R0, #0
		LDR		LR,=main_ret
		LDR		LR,[LR]
		BX		LR
.end
