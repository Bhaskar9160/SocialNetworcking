<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Search Results</title>
<script src="jquery.1.10.2.min.js"></script>
<script src="jquery.autocomplete.min.js"></script>
<link href="main.css" rel="stylesheet">

</head>
<body>
	<!-- sidebar -->
	<div class="sidebar">
		<div class="logo-details">
			<i class="fas fa-shopping-cart"></i> <span class="logo_name">Transport</span>
		</div>
		<ul class="nav-links">
			<li><a href="home"> <i class="fa fa-envelope"></i> <span
					class="link_name">Dashboard</span>
			</a></li>
			<li><a href="changepassword"> <i class="fa fa-deviantart"></i>
					<span class="link_name">ChangePassword</span>
			</a></li>
			<li><a href="editprofile"> <i class="fa fa-deviantart"></i>
					<span class="link_name">Edit Profile</span>
			</a></li>
			<li><a href="search"> <i class="fa fa-tasks"
					aria-hidden="true"></i> <span class="link_name">Search</span>
			</a></li>
			<li><a href="fav"> <i class="fa fa-bar-chart"
					aria-hidden="true"></i> <span class="link_name">Posts</span>
			</a></li>

			<li><a href="logout"> <i class="fa fa-sign-out"
					aria-hidden="true"></i> <span class="link_name">Logout</span>
			</a></li>
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
	<table   width="1005">
		<tr>
			<td width="25%"></td>
			
			
			<td align="right" width="100%">
				<table>
					<tr>
						<th>
							Request Time
						</th>
						<td>
							${myres.request_time }
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							Routes
						</th>
						
					</tr>
					<tr>
						<td colspan="2">
						<form action="savefav" method="post">
						<table>
						<tr>
							<td colspan="2">
								<input type="hidden" name="source" value="${source}">
								<input type="hidden" name="dest" value="${dest}">
								<input type="submit" value="Add Favourite">
							</td>
						</tr>
							<c:forEach items="${myres.routes}" var="rte">
								
									<tr>
										<th>Duration</th>
										<td>${rte.duration }</td>
										
									</tr>
									<tr>
										<td colspan="2">
										<table>
											<c:forEach items="${rte.route_parts}" var="rtr">
												<tr>
													<th>
														Mode
														
													</th>
													<td>
														${rtr.mode}
													</td>
													<th>
														From Point Name
														
													</th>
													<td>
														${rtr.from_point_name}
													</td>
												</tr>
												
												
											
											</c:forEach>
											</table>
										</td>
									</tr>
								
								
							</c:forEach>
							</table>
							</form>
						</td>
					
					</tr>
					
				</table>
				


				
			</td>
		</tr>
	</table>

	<script src="script.js"></script>
	
	

</body>
</html>





