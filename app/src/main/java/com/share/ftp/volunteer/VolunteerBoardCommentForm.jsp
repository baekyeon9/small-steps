<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>소통해요 : 나눔이야기 댓글</title>
	  <style>
	  label {
	    margin-right: 5px;
	    text-align: right;
	    display: inline-block;
	    width: 60px;
	  }
  </style>
</head>
<body>
<h1>봉사게시글 댓글 등록</h1>
<form action='commentAdd'>
<div class= "class" name="name" id="id" style="display:none"></div>

<label for='f-volBoardNo'>게시글번호</label>
<input id='f-volBoardNo' type='text' name='volBoardNo' value='${volBoardNo}' readonly><br>
<label for='f-content'>내용</label> <input id='f-content' type='text' name='commentContent'><br>
<%-- 댓글 등록회원 자동으로 들어가게 변경 예정 --%>
<label for='f-owner'>작성자</label> <input id='f-owner' type='text' name='owner'><br>

<br>
<button>등록</button><br>
</form>
</body>
</html>










