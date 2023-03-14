<%@ page contentType="text/html; charset=UTF-8" %>
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
						Cập nhật thông tin cá nhân
					</h3>
				</div>
			</div>

			<div class="signup__body">

				<div class="row">
					<div class="col-4 col-r">Chi nhanh ngan hang</div>
					<div class="col-8">
						<input type="text" class="signup__input" name="branch_name">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Loai giao dichn</div>
					<div class="col-8">
						<input type="number" class="signup__input" name="transaction_type">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Ten ngan hang</div>
					<div class="col-8">
						<input type="text" class="signup__input" name="bank_name">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Noi dung</div>
					<div class="col-8">
						<input type="text" class="signup__input" name="content">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">Ngay thanh toan</div>
					<div class="col-8">
						<input type="text" class="signup__input" name="payment_date">
					</div>
				</div>

				<div class="row">
					<div class="col-4 col-r">So tien</div>
					<div class="col-8">
						<input type="number" class="signup__input" name="payment_amount">
					</div>
				</div>

			</div>
		</div>

		<div style="
    display: flex; justify-content: center;">
			<button class="btn" type="submit">
				Thanh toan
			</button>
		</div>

	</form>

	<font color="red">${errorMessage}</font>
</div>
</body>

</html>