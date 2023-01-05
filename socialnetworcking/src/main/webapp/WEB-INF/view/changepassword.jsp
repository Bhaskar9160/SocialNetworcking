<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<link rel="stylesheet" href="hstyle.css" />
<title>Change Password</title>
</head>
<body>
	<!-- sidebar -->
	<div class="sidebar">
		<div class="logo-details">
			<i class="fas fa-shopping-cart"></i> <span class="logo_name">Social Networking</span>
		</div>
		<ul class="nav-links">
			      <li>
          <a href="home">
            <i class="fa fa-envelope"></i>
            <span class="link_name">Dashboard</span>
          </a>
        </li>
        <li>
          <a href="changepassword">
            <i class="fa fa-deviantart"></i>
            <span class="link_name">ChangePassword</span>
          </a>
        </li>
        <li>
          <a href="editprofile">
            <i class="fa fa-deviantart"></i>
            <span class="link_name">Edit Profile</span>
          </a>
        </li>
       
        <li>
          <a href="users">
            <i class="fa fa-bar-chart" aria-hidden="true"></i>
            <span class="link_name">Users</span>
          </a>
        </li>
        
        <li>
          <a href="articles">
            <i class="fa fa-bar-chart" aria-hidden="true"></i>
            <span class="link_name">Articles</span>
          </a>
        </li>
       
        <li>
          <a href="logout">
            <i class="fa fa-sign-out" aria-hidden="true"></i>
            <span class="link_name">Logout</span>
          </a>
        </li>
		</ul>
	</div>
	<!-- home section -->
	<section class="home-section">
		<nav>
			<div class="sidebar-button">
				<i class="fa fa-bars sidebarBtn" aria-hidden="true"></i> <span
					class="dashboard">Dashboard</span>

			</div>
		</nav>

	</section>
	<table class="wrapper">
		<tr>
			<td width="45%"></td>
			
			<td width="25%"></td>
			<td align="right" width="100%">


				<div class="wrapper">
					<div align="center" class="section">
						<div class="headline">
							<h1>Change Password</h1>
						</div>
						<div class="headline">
							<form method="post" action="changepassword">
								<div>

									<div class="form-group">
										<input name="opassword" type="password" placeholder="Old Password"
											required="" />
									</div>

									<div class="form-group">
										<input name="password" type="password" placeholder="new Password" required="" />
									</div>
									<div class="form-group">
										<input name="cpassword" type="password" placeholder="new Confirm Password" required="" />
									</div>
									<button type="submit" class="btn">ChangePassword</button>

								</div>
						</div>
						</form>
					</div>
				</div>

				</div>
			</td>
		</tr>
	</table>

	<script src="script.js"></script>

</body>
</html>





