<%@page import="com.itwill.toy.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
int cart_item_count = 0;
String sM_id = (String) session.getAttribute("sM_id");
if (sM_id != null) {
   CartService cartService = new CartService();
   cart_item_count = cartService.getCartList(sM_id).size();
}
%>
<div id="menu">
   <ul>
      <li id="logo"><a href="shop_main.jsp"></a></li>
      <li id="menu_notice"><a href='notice_list.jsp'></a></li>
      <li id="menu_qna"><a href='qna_list.jsp'></a></li>
      <%
      if (sM_id == null) {
      %>
          <!-- 
         <li id="mypage" title="나의페이지" ><a href="user_login_form.jsp" ></a></li>
         <li id="cart" title="장바구니"><span class="w3-badge-no-login w3-green-no-login w3-margin-right">0 </span><a href="user_login_form2.jsp" title="장바구니"></a></li>
          -->

      <li id="menu_login"><a href='member_login_form.jsp'></a></li>
      <li id="menu_join"><a href='member_write_form.jsp'></a></li>
      <li id="menu_cart"><a href='member_login_form.jsp'></a></li>

      <%
      } else {
      %>
      <!-- 
         <li id="mypage" title="나의페이지" ><a href="user_view.jsp"></a></li>
         <li id="cart" title="장바구니"><span class="w3-badge w3-green w3-margin-right"><%=cart_item_count%></span><a href="cart_view_select_update_qyt_all_check_delete_image2.jsp"></a></li>
          -->
      <li id="menu_cart"><a href='cart_view.jsp'></a></li>
      <li id="menu_order"><a href='order_list.jsp'></a></li>
      <li id="menu_logout"><a href='member_logout_action.jsp'></a></li>
      <li id="menu_mypage"><a href='member_view.jsp'></a></li>
      
      <%
      }
      %>
      
   </ul>
</div>