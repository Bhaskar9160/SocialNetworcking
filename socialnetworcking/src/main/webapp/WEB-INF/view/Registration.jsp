<!DOCTYPE html>
<html>
  <head>
    <title>Registration</title>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="wrapper">
      <div class="headline">
        <h1>Welcome</h1>
      </div>
      <form class="form" method="post" action="reg">
        <div class="signup">
          <div class="form-group">
            <input name="fullName" type="text" placeholder="Full name" required="" />
          </div>
          <div class="form-group">
            <input name="emailId" type="email" placeholder="Email" required="" />
          </div>
            <div class="form-group">
            <input name="mobileNumber" type="number" placeholder="mobileNumber" required="" />
          </div>
          <div class="form-group">
            <input name="password" type="password" placeholder="Password" required="" />
          </div>
          <button type="submit" class="btn">SIGN UP</button>
          <div class="account-exist">
            Already have an account? <a href="login" id="login">Login</a>
          </div>
        </div>
       
        </div>
      </form>
    </div>

   
  </body>
</html>
