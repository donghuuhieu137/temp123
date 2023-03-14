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
                        ĐĂNG KÝ
                    </h3>
                    <p class="signup__title2">Đăng ký sử dụng, điều chỉnh thông tin và ngừng sử dụng phương thức giao dịch điện tử trong lĩnh vực bảo hiểm xã hội</p>
                </div>
            </div>

            <div class="signup__body">

                <div class="row">
                    <div class="col-4 col-r">Tên đăng nhập</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" name="username">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Mật khẩu</div>
                    <div class="col-8">
                        <input type="password" class="signup__input" name="password">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Nhập lại mật khẩu</div>
                    <div class="col-8">
                        <input type="password" class="signup__input" name="confirm_password">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Tên công ty</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" name="company_name">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ liên hệ</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="address">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Điện thoại di động</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="phone_number">
                    </div>
                </div>

                <div class="row">
                    <div class="col-4 col-r">Địa chỉ thư điện tử</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="email">
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-4 col-r">Người đại diện</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="representative">
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-4 col-r">Mã số thuế</div>
                    <div class="col-8">
                        <input type="text" class="signup__input" placeholder="" name="tax_code">
                    </div>
                </div>

            </div>
        </div>

        <div style="
    display: flex; justify-content: center;">
            <button class="btn" type="submit">
                Đăng ký
            </button>
        </div>

    </form>

    <font color="red">${errorMessage}</font>
</div>
</body>

</html>