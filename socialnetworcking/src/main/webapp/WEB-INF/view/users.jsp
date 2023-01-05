<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Search</title>
<script src="jquery.1.10.2.min.js"></script>
<script src="jquery.autocomplete.min.js"></script>
<link href="main.css" rel="stylesheet">

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
	<table width="1005">
		<tr>
			<td width="25%"></td>


			<td align="right" width="100%">


				<div class="wrapper">
					<div align="center" class="section">
						<div class="headline">
							<h1> Users List</h1>
						</div>
						<div class="headline">
							
								<c:forEach items="${nfavusers}" var="user">
								<div class="form-group">
									${user.fullName }
									
									<a href="folowuser?userId=${user.userId}">Follow</a>
								</div>

								</c:forEach>

							



						</div>
					</div>


					<div align="center" class="section">
						<div class="headline">
							<h1>My Fav Users List</h1>
						</div>
						<div class="headline">
							
								<c:forEach items="${favusers}" var="user">
								<div class="form-group">
									${user.fullName }
									
									<a href="show?userId=${user.userId}">Show</a>
								</div>

								</c:forEach>

							



						</div>
					</div>
					
				</div>
			</td>
		</tr>
	</table>

	<script src="script.js"></script>



</body>
</html>





