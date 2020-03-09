<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
@import url(http://fonts.googleapis.com/earlyaccess/jejuhallasan.css);
@charset "urf-8";

#deco {
   margin-left: 350px;
}

#hello{
background-color:#2eb82e;
}

table {
   float: left;
   text-align: center;
   background: #ffffe6;
   font-family: 'Jeju Hallasan', serif;
}

body {
   font-family: 'Jeju Hallasan', serif;
   background: #ffffe6;
}

#but {
   background-color: #05944d;
   color: white;
   font-size: 30px;
   font-family: 'Jeju Gothic', serif;
}

</style>
<title>메인 페이지</title>
</head>

<body onload="init();">
<center>
<h1>CAFE POS</h1></center>

<form name="form" method="get" action="Total_Account.jsp">
   <table id="deco" border="1" cellspacing="0">
   <tr>
<!--       <td><input type="checkbox" id="menu1" name="menu1" value="p01"></td> -->
      <td><img src="./image/p01.jpg" width=180 height=180></td>
      <td>아메리카노<br>4100원</td>
      <td><input type=hidden name="sell_price" value="4100">
      
         <input type=hidden name="Mname1" value="아메리카노">
         
         <input id=amount1 type="text" name="amount" value="0" size="3" onchange="change();">
            <input type="button" value=" + " onclick="add();">
            <input type="button" value=" - " onclick="del();"></td>
            <td><input id=sum1 type="text" name="sum" size="11" readonly>원</td>
   
   </tr>
   <tr>
<!--       <td><input type="checkbox" id="menu2" name="menu2" value="p02"></td> -->
      <td><img src="./image/p02.jpg" width=180 height=180></td>
      <td>카페라떼<br>4600원</td>
      <td><input type=hidden name="sell_price2" value="4600">
      
      <input type=hidden name="Mname2" value="카페라떼">
      
         <input id=amount2  type="text" name="amount2" value="0" size="3" onchange="change2();">
            <input type="button" value=" + " onclick="add2();">
            <input type="button" value=" - " onclick="del2();"></td>
            <td><input id=sum2 type="text" name="sum2" size="11" readonly>원</td>
   </tr>
   <tr>
<!--       <td><input type="checkbox" id="menu3" name="menu3" value="p03"></td> -->
      <td><img src="./image/p03.jpg" width=180 height=180></td>
      <td>카푸치노<br>4600</td>
      <td><input type=hidden name="sell_price3" value="4600">
      
      <input type=hidden name="Mname3" value="카페라떼">
      
         <input id=amount3 type="text" name="amount3" value="0" size="3" onchange="change3();">
            <input type="button" value=" + " onclick="add3();">
            <input type="button" value=" - " onclick="del3();"></td>
            <td><input id=sum3 type="text" name="sum3" size="11" readonly>원</td>
   </tr>
   <tr>
<!--       <td><input type="checkbox" id="menu4" name="menu4" value="p04"></td> -->
      <td><img src="./image/p04.jpg" width=180 height=180></td>
      <td>카페모카<br>5100</td>
      <td><input type=hidden name="sell_price4" value="5100">
      
      <input type=hidden name="Mname4" value="카페모카">
      
         <input id=amount4  type="text" name="amount4" value="0" size="3" onchange="change4();">
            <input type="button" value=" + " onclick="add4();">
            <input type="button" value=" - " onclick="del4();"></td>
            <td><input id=sum4 type="text" name="sum4" size="11" readonly>원</td>
   </tr>
   <tr>
<!--       <td><input type="checkbox" id="menu5" name="menu5" value="p05"></td> -->
      <td><img src="./image/p05.jpg" width=180 height=180></td>
      <td>자바 칩 프라푸치노<br>6600</td>
      <td><input type=hidden name="sell_price5" value="6600">
      
      <input type=hidden name="Mname5" value="자바 칩 프라푸치노">
      
         <input id=amount5 type="text" name="amount5" value="0" size="3" onchange="change5();">
            <input type="button" value=" + " onclick="add5();">
            <input type="button" value=" - " onclick="del5();"></td>
            <td><input id=sum5 type="text" name="sum5" size="11" readonly>원</td>
   </tr></table>
   <table border="1" cellspacing="0">
   <tr>
<!--       <td><input type="checkbox" id="menu6" name="menu6" value="p06"></td> -->
      <td><img src="./image/p06.jpg" width=180 height=180></td>
      <td>모카 프라푸치노<br>6100원</td>
      <td><input type=hidden name="sell_price6" value="6100">
      
      <input type=hidden name="Mname6" value="모카 프라푸치노">
      
         <input id=amount6 type="text" name="amount6" value="0" size="3" onchange="change6();">
            <input type="button" value=" + " onclick="add6();">
            <input type="button" value=" - " onclick="del6();"></td>
            <td><input id=sum6 type="text" name="sum6" size="11" readonly>원</td>
   </tr>
 

     <tr>
<!--       <td><input type="checkbox" id="menu7" name="menu7" value="p07"></td> -->
      <td><img src="./image/p07.jpg" width=180 height=180></td>
      <td>딸기크림 프라푸치노<br>6100원</td>
      <td><input type=hidden name="sell_price7" value="6100">
      
      <input type=hidden name="Mname7" value="딸기크림 프라푸치노">
      
         <input id=amount7 type="text" name="amount7" value="0" size="3" onchange="change7();">
            <input type="button" value=" + " onclick="add7();">
            <input type="button" value=" - " onclick="del7();"></td>
            <td><input id=sum7 type="text" name="sum7" size="11" readonly>원</td>
   </tr>
   
   <tr>
<!--       <td><input type="checkbox" id="menu8" name="menu8" value="p08"></td> -->
      <td><img src="./image/p08.jpg" width=180 height=180></td>
      <td>딸기 요거트 스무디<br>6600원</td>
      <td><input type=hidden name="sell_price8" value="6600">
      
      <input type=hidden name="Mname8" value="딸기 요거트 스무디">
      
         <input id=amount8 type="text" name="amount8" value="0" size="3" onchange="change8();">
            <input type="button" value=" + " onclick="add8();">
            <input type="button" value=" - " onclick="del8();"></td>
            <td><input id=sum8 type="text" name="sum8" size="11" readonly>원</td>
   </tr>
   
   <tr>
<!--       <td><input type="checkbox" id="menu9" name="menu9" value="p09"></td> -->
      <td><img src="./image/p09.jpg" width=180 height=180></td>
      <td>허니 블랙 자몽티<br>5500원</td>
      <td><input type=hidden name="sell_price9" value="5500">
      
      <input type=hidden name="Mname9" value="허니 블랙 자몽티">
      
         <input id=amount9 type="text" name="amount9" value="0" size="3" onchange="change9();">
            <input type="button" value=" + " onclick="add9();">
            <input type="button" value=" - " onclick="del9();"></td>
            <td><input id=sum9 type="text" name="sum9" size="11" readonly>원</td>
   </tr>
    <tr>
<!--         <td><input type="checkbox" id="option1" name="option1" value="o1"></td> -->
         <td colspan="2" height=42>사이즈업(500원)</td>
         <td><input type=hidden name="sell_price10" value="500">
         
         <input type=hidden name="Mname10" value="사이즈업">
         
         <input id=amount10 type="text" name="amount10" value="0" size="3" onchange="change10();">
            <input type="button" value=" + " onclick="add10();">
            <input type="button" value=" - " onclick="del10();"></td>
            <td><input id=sum10 type="text" name="sum10" size="11" readonly>원</td>
   </tr>
   
   <tr>
<!--         <td><input type="checkbox" id="option2" name="option2" value="o2"></td> -->
         <td colspan="2" height=43>휘핑크림(300원)</td>
         <td><input type=hidden name="sell_price11" value="300">
          
         <input type=hidden name="Mname11" value="사이즈업">
         
         <input id=amount11 type="text" name="amount11" value="0" size="3" onchange="change11();">
            <input type="button" value=" + " onclick="add11();">
            <input type="button" value=" - " onclick="del11();"></td>
            <td><input id=sum11 type="text" name="sum11" size="11" readonly>원</td>
   </tr>
   <tr>
<!--         <td><input type="checkbox" id="option3" name="option3" value="o3"></td> -->
         <td colspan="2" height=43>자바칩 추가(600원)</td>
         <td><input type=hidden name="sell_price12" value="600">
          
         <input type=hidden name="Mname102 value="사이즈업">
         
         <input id=amount12 type="text" name="amount12" value="0" size="3" onchange="change12();">
            <input type="button" value=" + " onclick="add12();">
            <input type="button" value=" - " onclick="del12();"></td>
            <td><input id=sum12 type="text" name="sum12" size="11" readonly>원</td>
   </tr>
   
    <tr>
    <td id=hello colspan="2" height=43> 합계 </td>
    <td id=hello> <input id="totalNumber" type="text" size="2" value="0"/> </td>
 <td id=hello> <input id="totalPrice" type="text" size="6" value="0"/> 원</td>
 </tr>
 </table>
 
 
<input id="but" type="button" value="합계계산" onclick="updateAll()" style="width:180px; height:189px" /><br>
<input id="but" type="reset" value="전체취소" style="width:180px; height:189px"/><br>

 <input id="but" type="submit" value="결제하기" onclick="load1()" style="width:180px; height:189px"/><br>
 
 <input id="but" type="button" value="총매출액" onclick="location='Total_Account2.jsp'"style="width:180px; height:189px"/><br>
 <input id="but" type="button" onclick="location.href = 'Logout.jsp'" value='로그아웃' style="width:180px; height:189px"/>
</form>

<script>

var sell_price;
var sell_price2;
var sell_price3;
var sell_price4;
var sell_price5;
var sell_price6;
var sell_price7;
var sell_price8;
var sell_price9;
var sell_price10;
var sell_price11;
var sell_price12;
var amount;
var amount2;
var amount3;
var amount4;
var amount5;
var amount6;
var amount7;
var amount8;
var amount9;
var amount10;
var amount11;
var amount12;

function updateAll(){
    // input의 id값 book1~3의 수량을 가져와서 n1~n3까지 임의의 변수를 만들어서 집어넣습니다.
   var n1 = document.getElementById("amount1").value;
   var n2 = document.getElementById("amount2").value;
   var n3 = document.getElementById("amount3").value;
   var n4 = document.getElementById("amount4").value;
   var n5 = document.getElementById("amount5").value;
   var n6 = document.getElementById("amount6").value;
   var n7 = document.getElementById("amount7").value;
   var n8 = document.getElementById("amount8").value;
   var n9 = document.getElementById("amount9").value;
   var n10 = document.getElementById("amount10").value;
   var n11 = document.getElementById("amount11").value;
   var n12 = document.getElementById("amount12").value;
       
    // 각 책의 가격에 앞에 가져온 책의 수량을 계산해서 p1~p3까지 임의로 변수를 만들어 집어넣습니다.
    
   var p1 = 4100*n1;
   var p2 = 4600*n2;
   var p3 = 4600*n3;
   var p4 = 5100*n4;
   var p5 = 6600*n5;
   var p6 = 4100*n6;
   var p7 = 4100*n7;
   var p8 = 4100*n8;
   var p9 = 4100*n9;
   var p10 = 500*n10;
   var p11 = 300*n11;
   var p12 = 600*n12;
       
    // 각각 계산된 책의 값을 합계값을 book1Total ~ book3Total 까지 각각 넣어줍니다.
   document.getElementById("sum1").value = p1;
   document.getElementById("sum2").value = p2;
   document.getElementById("sum3").value = p3;
   document.getElementById("sum4").value = p4;
   document.getElementById("sum5").value = p5;
   document.getElementById("sum6").value = p6;
   document.getElementById("sum7").value = p7;
   document.getElementById("sum8").value = p8;
   document.getElementById("sum9").value = p9;
   document.getElementById("sum10").value = p10;
   document.getElementById("sum11").value = p11;
   document.getElementById("sum12").value = p12;
       
    // 수량이 들어갈 곳의 id인 totalNumber에 n1~n3 까지의 합을 계산해서 넣어줍니다.
    // 문자열로 인식해서 정수형으로 바꿔줬습니다.
    // 원래소스 : 1 + 2 + 3 = 123 --> 수정소스 : 1 + 2 + 3 = 6   
    var totalNumber = parseInt(n1) + parseInt(n2) + parseInt(n3)+parseInt(n4) + parseInt(n5) + parseInt(n6) + parseInt(n7) + parseInt(n8) + parseInt(n9)+ parseInt(n10) + parseInt(n11) + parseInt(n12);
    document.getElementById("totalNumber").value = totalNumber;
       
    // 책의 총 가격이 들어갈 id인 totalPrice에 p1~p3까지의 합을 계산해서 넣어줍니다.
    var totalPrice = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10 + p11 + p12;
    document.getElementById("totalPrice").value = totalPrice;
}

function load(){
   
   location.reload();
}
function load1(){
   alert1();
   location.reload();
}
function alert1(){
   var sum=0;
   
   for(var i=1;i<=12;i++){
      sum+=document.getElementById("sum"+i).value;      
   }
   
   if(sum!=0){
      alert("결제완료");   
   }else{
      alert("주문할 음료를 선택해 주세요");   
   }
   
   
}
//초기값 함수
function init () {
      sell_price = document.form.sell_price.value;
      sell_price2 = document.form.sell_price2.value;
      sell_price3 = document.form.sell_price3.value;
      sell_price4 = document.form.sell_price4.value;
      sell_price5 = document.form.sell_price5.value;
      sell_price6 = document.form.sell_price6.value;
      sell_price7 = document.form.sell_price7.value;
      sell_price8 = document.form.sell_price8.value;
      sell_price9 = document.form.sell_price9.value;
      sell_price10 = document.form.sell_price10.value;
      sell_price11 = document.form.sell_price11.value;
      sell_price12 = document.form.sell_price12.value;
      amount = document.form.amount.value;
      amount2 = document.form.amount2.value;
      amount3 = document.form.amount3.value;
      amount4 = document.form.amount4.value;
      amount5 = document.form.amount5.value;
      amount6 = document.form.amount6.value;
      amount7 = document.form.amount7.value;
      amount8 = document.form.amount8.value;
      amount9 = document.form.amount9.value;
      amount10 = document.form.amount10.value;
      amount11 = document.form.amount11.value;
      amount12 = document.form.amount12.value;
      document.form.sum.value = sell_price;
      document.form.sum2.value = sell_price2;
      document.form.sum3.value = sell_price3;
      document.form.sum4.value = sell_price4;
      document.form.sum5.value = sell_price5;
      document.form.sum6.value = sell_price6;
      document.form.sum7.value = sell_price7;
      document.form.sum8.value = sell_price8;
      document.form.sum9.value = sell_price9;
      document.form.sum10.value = sell_price10;
      document.form.sum11.value = sell_price11;
      document.form.sum12.value = sell_price12;
      change();
       change2();
       change3();
       change4();
       change5();
       change6();
       change7();
       change8();
       change9();
       change10();
       change11();
       change12();
}

//더하기 함수
function add () {
   hm = document.form.amount;
   sum = document.form.sum;
   hm.value ++ ;

   sum.value = parseInt(hm.value) * sell_price;
}
function add2 () {
   hm2 = document.form.amount2;
   sum2 = document.form.sum2;
   hm2.value ++ ;

   sum2.value = parseInt(hm2.value) * sell_price2;
}
function add3 () {
   hm3 = document.form.amount3;
   sum3 = document.form.sum3;
   hm3.value ++ ;

   sum3.value = parseInt(hm3.value) * sell_price3;
}
function add4 () {
   hm4 = document.form.amount4;
   sum4 = document.form.sum4;
   hm4.value ++ ;

   sum4.value = parseInt(hm4.value) * sell_price4;
}
function add5 () {
   hm5 = document.form.amount5;
   sum5 = document.form.sum5;
   hm5.value ++ ;

   sum5.value = parseInt(hm5.value) * sell_price5;
}
function add6 () {
   hm6 = document.form.amount6;
   sum6 = document.form.sum6;
   hm6.value ++ ;

   sum6.value = parseInt(hm6.value) * sell_price6;
}
function add7 () {
   hm7 = document.form.amount7;
   sum7 = document.form.sum7;
   hm7.value ++ ;

   sum7.value = parseInt(hm7.value) * sell_price7;
}
function add8 () {
   hm8 = document.form.amount8;
   sum8 = document.form.sum8;
   hm8.value ++ ;

   sum8.value = parseInt(hm8.value) * sell_price8;
}
function add9 () {
   hm9 = document.form.amount9;
   sum9 = document.form.sum9;
   hm9.value ++ ;

   sum9.value = parseInt(hm9.value) * sell_price9;
}
function add10 () {
      hm10 = document.form.amount10;
      sum10 = document.form.sum10;
      hm10.value ++ ;

      sum10.value = parseInt(hm10.value) * sell_price10;
   }
   function add11 () {
      hm11 = document.form.amount11;
      sum11 = document.form.sum11;
      hm11.value ++ ;

      sum11.value = parseInt(hm11.value) * sell_price11;
   }
   function add12 () {
      hm12 = document.form.amount12;
      sum12 = document.form.sum12;
      hm12.value ++ ;

      sum12.value = parseInt(hm12.value) * sell_price12;
   }


//빼기 함수
function del () {
   hm = document.form.amount;
   sum = document.form.sum;
      if (hm.value > 0) {
         hm.value -- ;
         sum.value = parseInt(hm.value) * sell_price;
      }
}

function del2 () {
   hm2 = document.form.amount2;
   sum2 = document.form.sum2;
      if (hm2.value > 0) {
         hm2.value -- ;
         sum2.value = parseInt(hm2.value) * sell_price2;
      }
}
function del3 () {
   hm3 = document.form.amount3;
   sum3 = document.form.sum3;
      if (hm3.value > 0) {
         hm3.value -- ;
         sum3.value = parseInt(hm3.value) * sell_price3;
      }
}
function del4 () {
   hm4 = document.form.amount4;
   sum4 = document.form.sum4;
      if (hm4.value >0 ) {
         hm4.value -- ;
         sum4.value = parseInt(hm4.value) * sell_price4;
      }
}
function del5 () {
   hm5 = document.form.amount5;
   sum5 = document.form.sum5;
      if (hm5.value > 0) {
         hm5.value -- ;
         sum5.value = parseInt(hm5.value) * sell_price5;
      }
}
function del6 () {
   hm6 = document.form.amount6;
   sum6 = document.form.sum6;
      if (hm6.value > 0) {
         hm6.value -- ;
         sum6.value = parseInt(hm6.value) * sell_price6;
      }
}
function del7 () {
   hm7 = document.form.amount7;
   sum7 = document.form.sum7;
      if (hm7.value > 0) {
         hm7.value -- ;
         sum7.value = parseInt(hm7.value) * sell_price7;
      }
}
function del8 () {
   hm8 = document.form.amount8;
   sum8 = document.form.sum8;
      if (hm8.value > 0) {
         hm8.value -- ;
         sum8.value = parseInt(hm8.value) * sell_price8;
      }
}
function del9 () {
   hm9 = document.form.amount9;
   sum9 = document.form.sum9;
      if (hm9.value > 0) {
         hm9.value -- ;
         sum9.value = parseInt(hm9.value) * sell_price9;
      }
}
function del10 () {
      hm10 = document.form.amount10;
      sum10 = document.form.sum10;
         if (hm10.value > 0) {
            hm10.value -- ;
            sum10.value = parseInt(hm10.value) * sell_price10;
         }
   }
   function del11 () {
      hm11 = document.form.amount11;
      sum11 = document.form.sum11;
         if (hm11.value > 0) {
            hm11.value -- ;
            sum11.value = parseInt(hm11.value) * sell_price11;
         }
   }
   function del12 () {
      hm12 = document.form.amount12;
      sum12 = document.form.sum12;
         if (hm12.value > 0) {
            hm12.value -- ;
            sum12.value = parseInt(hm12.value) * sell_price12;
         }
   }

//change함수
function change () {
   hm = document.form.amount;
   sum = document.form.sum;

      if (hm.value < 0) {
         hm.value = 0;
      }
   sum.value = parseInt(hm.value) * sell_price;
}  

function change2 () {
   hm2 = document.form.amount2;
   sum2 = document.form.sum2;

      if (hm2.value < 0) {
         hm2.value = 0;
      }
   sum2.value = parseInt(hm2.value) * sell_price2;
}  

function change3 () {
   hm3 = document.form.amount3;
   sum3 = document.form.sum3;

      if (hm3.value < 0) {
         hm3.value = 0;
      }
   sum3.value = parseInt(hm3.value) * sell_price3;
}  

function change4 () {
   hm4 = document.form.amount4;
   sum4 = document.form.sum4;

      if (hm4.value < 0) {
         hm4.value = 0;
      }
   sum4.value = parseInt(hm4.value) * sell_price4;
}  

function change5 () {
   hm5 = document.form.amount5;
   sum5 = document.form.sum5;

      if (hm5.value < 0) {
         hm5.value = 0;
      }
   sum5.value = parseInt(hm5.value) * sell_price5;
}  

function change6 () {
   hm6 = document.form.amount6;
   sum6 = document.form.sum6;

      if (hm6.value < 0) {
         hm6.value = 0;
      }
   sum6.value = parseInt(hm6.value) * sell_price6;
} 
function change7 () {
   hm7 = document.form.amount7;
   sum7 = document.form.sum7;

      if (hm7.value < 0) {
         hm7.value = 0;
      }
   sum7.value = parseInt(hm7.value) * sell_price7;
}  
function change8 () {
   hm8 = document.form.amount8;
   sum8 = document.form.sum8;

      if (hm8.value < 0) {
         hm8.value = 0;
      }
   sum8.value = parseInt(hm8.value) * sell_price8;
}  
function change9 () {
   hm9 = document.form.amount9;
   sum9 = document.form.sum9;

      if (hm9.value < 0) {
         hm9.value = 0;
      }
   sum9.value = parseInt(hm9.value) * sell_price9;
}  
function change10 () {
      hm10 = document.form.amount10;
      sum10 = document.form.sum10;

         if (hm10.value < 0) {
            hm10.value = 0;
         }
      sum10.value = parseInt(hm10.value) * sell_price10;
   }  
   function change11 () {
      hm11 = document.form.amount11;
      sum11 = document.form.sum11;

         if (hm11.value < 0) {
            hm11.value = 0;
         }
      sum11.value = parseInt(hm11.value) * sell_price11;
   }  
   function change12 () {
      hm12 = document.form.amount12;
      sum12 = document.form.sum12;

         if (hm12.value < 0) {
            hm12.value = 0;
         }
      sum12.value = parseInt(hm12.value) * sell_price12;
   }  
</script>
</body>
</html>