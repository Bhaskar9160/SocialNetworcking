<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
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
      <form class="form" method="post" action="login">
        <div class="signup">
          
          <div class="form-group">
            <input name="emailId" type="email" placeholder="Email" required="" />
          </div>
           
          <div class="form-group">
            <input name="password" type="password" placeholder="Password" required="" />
          </div>
          <button type="submit" class="btn">SIGN In</button>
          <div class="account-exist">
            Do not have an account? <a href="reg" id="login">Registration</a>
          </div>
        </div>
       
        </div>
      </form>
    </div>

   
  </body>
</html>
