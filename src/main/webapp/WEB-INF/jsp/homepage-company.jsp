<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Document</title>
  </head>
  <body>
    <div style="height: 30px;width: 130px; background-color:#0a76b1;text-align: center">
      <a href="/add-user">Thêm người dùng</a>
    </div>
    <div class="content__table" >
      <table>
        <tr style="background-color:#0a76b1;color: #fff">
          <td style="width: 2%; min-width:35px; text-align: center">Id</td>
          <td style="width: 3%; min-width:70px; text-align: center">Tên</td>
          <td style="width: 15%; min-width:250px; text-align: center">Email</td>
          <td style="width: 10%; min-width:100px; text-align: center">Lương</td>
          <td style="width: 15%; min-width:280px; text-align: center">Thanh toán</td>
          <td style="width: 3%; min-width:70px; text-align: center">Chỉnh Sửa</td>
          <td style="width: 3%; min-width:70px; text-align: center">Xóa</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
              <td style="width: 2%; min-width:35px; text-align: center">${user.id}</td>
              <td style="width: 3%; min-width:70px; text-align: center">${user.fullName}</td>
              <td style="width: 15%; min-width:250px; text-align: center">${user.email}</td>
              <td style="width: 10%; min-width:100px; text-align: center">${user.salary}</td>
              <td style="width: 15%; min-width:270px; text-align: center"><a href="/payment-company">Image</td>
              <td style="width: 3%; min-width:80px; text-align: center">
                <a href="/company-update-user/${user.id}">
                  <img src="https://img.icons8.com/external-tanah-basah-glyph-tanah-basah/15/000000/external-edit-social-media-ui-tanah-basah-glyph-tanah-basah.png"/>
                </a>
              </td>
              <td style="width: 3%; min-width:70px; text-align: center">
                <a href="/company-remove-user/${user.id}">
                  <img src="https://img.icons8.com/metro/15/null/trash.png"/>
                </a>
              </td>
            </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>