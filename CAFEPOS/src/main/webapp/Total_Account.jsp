<%@page import="com.spring.biz.board.AmountVO"%>
<%@page import="com.spring.biz.board.impl.AmountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <%
   String name="";
   AmountVO VO = new AmountVO();
   AmountDAO DAO=new AmountDAO();

   String pid="";

      for (int i = 1; i <= 12; i++) {
         //String str = "select *from table where p_id=" + menus[i];    
         if(i==1){
             name="amount";
         }else{
            name="amount"+i;
         }
      
        int amount = Integer.parseInt(request.getParameter(name));//수량
         
         if(amount!=0){
        
         if(i<10){
        	 pid="P0"+i;
            System.out.println(pid);
         } else{
        	 pid="P"+i;
            System.out.println(pid);
         }
         System.out.println(amount);
        
        

         
         if(i<10){
        	 VO.setP_id(pid);
         }
         else{
        	 VO.setP_id(pid);
         }
        
         VO.setCount(amount);
         
         DAO.insertBoard(VO);
         
         
         }
        
      } 
      int sum=DAO.sum();
      System.out.println(sum);
 		
   %>
      
   
   
   
</body>
</html>