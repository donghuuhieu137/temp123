<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/styles.css">
	<title>Document</title>
</head>

<body>

<div class="container">

	<form action="" method="post">

		<div class="signup">
			<div class="signup__head">
				<div>
					<h3 class="signup__title">
						Thêm tài khoản
					</h3>
				</div>
			</div>

			<div class="signup__body">

				<div class="row">
					<div class="col-4 col-r">Họ và tên</div>
					<div class="col-8">
						<input path="" type="text" class="signup__input" name="full_name">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Số CCCD/CMND/Hộ chiếu </div>
					<div class="col-8">
						<input path="" type="text" class="signup__input" value="${user.email}" placeholder="" name="citizen_id">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Địa chỉ liên hệ</div>
					<div class="col-8">
						<input path="" type="text" class="signup__input" value="${user.address}" placeholder="" name="address">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Điện thoại di động</div>
					<div class="col-8">
						<input path="" type="text" class="signup__input" value="${user.phone}" placeholder="" name="phone_number">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Địa chỉ thư điện tử</div>
					<div class="col-8">
						<input path="" type="text" class="signup__input" value="${user.email}" placeholder="" name="email">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Cơ quan bảo hiểm</div>
					<div class="col-8">
						<input path="" type="text" value="${user.coQuanBaoHiemThanhPho}" class="signup__input" placeholder="" name="cqbh">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Mã số thuế</div>
					<div class="col-8">
						<input path="" type="text" value="${user.maSoThue}" class="signup__input" placeholder="" name="tax_code"/>
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Mức lương hiện tại</div>
					<div class="col-8">
						<input path="" type="number" value="${user.salary}" class="signup__input" placeholder="" name="salary">
					</div>
				</div>

			</div>
		</div>

		<div style="
    display: flex; justify-content: center;">
			<button class="btn" type="submit">
				Thêm
			</button>
		</div>

	</form>

	<font color="red">${errorMessage}</font>
</div>
</body>

</html>