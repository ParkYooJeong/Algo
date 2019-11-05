#include<stdio.h>
#include<avr/io.h>
#include <avr/interrupt.h>
#include"kmd128.h"
#define match 255
#include<util/delay.h>

static FILE mystdout = FDEV_SETUP_STREAM(putch, NULL,_FDEV_SETUP_WRITE);

//에코 핀에서 출력되는 펄스의 길이를 저장하는 전역변수
unsigned int dist = 0;
unsigned int dist2 = 0;
unsigned int i = 17;
unsigned int j = 17;

void servo(){

// -90 도 이동 예제 
while(i<16){
PORTA|= _BV(0); // ON 시킵 

Delay_ms(0.5);// // 700uS 딜레이 

PORTA&= ~(_BV(0)); // 

Delay_ms(19.5);// 19.3mS 딜레이 
i++;}
Delay_ms(3000);
while(j<16){
PORTA|= _BV(0); // ON 시킵 

Delay_ms(1.5);// // 700uS 딜레이 

PORTA&= ~(_BV(0)); // 

Delay_ms(18.5);// 19.3mS 딜레이 
j++;}
i=0;j=0;
}


void TC0_cnt()
{
 TCCR0 =0b00000010; //normal mode, prescaler = 8
 TCCR2 =0b00000010;
 TIMSK =0b00000000; //tc0 ovf interrput : disable;
 TCNT0 =253;//253;
 TCNT2 =253;
}

void TRIGGER(){
 // 1. 트리거 펄스 공급(10us)
PORTC |= _BV(4);
Delay_us(10);//Delay_us(10);
PORTC&= ~(_BV(4));
 
 //2. 초음파 센서에서 초음파 출력.

 //3. 거리 측정
 //3-1 상승 엣지 감지 -- 인터럽트
 //3-2 하강 엣지 감지 -- 인터럽트
}

ISR (INT0_vect) // 카운터 시작
{
TIMSK|= _BV(6);

}

ISR (INT1_vect) // 스위치
{

//카운터 종료
TIMSK&= ~(_BV(6)); //tc0 ovf interrupt : disable; 
 printf("raw2 : %u, distance2(cm) : %u \n\r ", dist2, dist2/10);//원래는 나누기 58

 if((dist2/10)>=9){//green
PORTC |= _BV(3);
PORTC &= ~(_BV(2));
PORTC &= ~(_BV(1));
}
if(((dist2/10)>5)&&((dist2/10)<9)){//yellow
PORTC |= _BV(2);
PORTC &= ~(_BV(1));
PORTC &= ~(_BV(3));
}
if((dist2/10)<5){//red
PORTC |= _BV(1);
PORTC &= ~(_BV(3));
PORTC &= ~(_BV(2));
}
dist2=0;

}



ISR (INT5_vect) // echo_start()
{
 //카운터 시작
 TIMSK|= _BV(0); //tc0 ovf interrupt : enable;
}

ISR (INT6_vect) // echo_finish()
{
 //카운터 종료
TIMSK&= ~(_BV(0)); //tc0 ovf interrupt : disable; 
 printf("raw : %u, distance(cm) : %u \n\r ", dist, dist/10);//원래는 나누기 58
 
 if((dist/10)<20){
PORTB=0b00001010;
Delay_ms(dist*5);
PORTB=0b00000000;
servo();
PORTB=0b00000101;
Delay_ms(dist*5);
PORTB=0b00000000;
Delay_ms(2000);


}
dist =0;
}
ISR(TIMER0_OVF_vect) //거리
{
 //every 1us
 dist ++;
 TCNT0 =253;//TCNT0 Reinitialize
}

ISR(TIMER2_OVF_vect) //거리
{
 //every 1us
 dist2 ++; ;//TCNT0 Reinitialize
TCNT2 =253;
}
void main()
{
 
   UART1_initialize();
   stdout = &mystdout;
 TC0_cnt();

 
 DDRA =0xff;
 DDRB =0xff;
 DDRC =0xff;
 DDRD =0x00;
 DDRE =0x00;

 EICRB =0b00101100;//INT4 falling edge, INT5 rinsing edge, INT6 falling edge
 EICRA =0b00001011;//INT1 falling edge, INT0 rinsing edge, 
 EIMSK =0b01100011;//int012 인터럽트 걸리게해줌

 //MCUCR = 0x80;
 XMCRA = 0x00;                          
 XMCRB = 0x80;
 OCR0=match;
 OCR2=match;
 SREG =0x80;

 // 외부인터럽트 0, 1, 2 사용
 // 0 : 스위치
 // 1 : 에코 시작 감지 (상승엣지)
 // 2 : 에코 끝 감지 (하강엣지)
 while(1){

TRIGGER();
 Delay_ms(100);
 
 } 
}
