<%@page import="com.agami.model.CommentTl"%>
<%@page import="java.util.List"%>
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
							<h1> Article List</h1>
						</div>
						<div class="headline">
							
								<c:forEach items="${posts}" var="pt">
								<%int l=0;int u=0; %>
								<div class="form-group">
									${pt.postTitle }
									
									<br>
									${pt.postDescription }
									
									<c:forEach items="${likes}" var="lk">
									<c:if test="${pt.postId eq lk.postId }">
										<c:if test='${lk.status eq "like" }'>
										<%++l; %>
										</c:if>
										<c:if test='${lk.status eq "ulike" }'>
										<%++u; %>
										</c:if>
									</c:if>
									</c:forEach>
									<p><a href="like?userId=${param.userId }&postId=${pt.postId }&status=like"><i class="fa fa-thumbs-up" aria-hidden="true"></i><%=l %></a>&nbsp;
									  <a href="like?userId=${param.userId }&postId=${pt.postId }&status=ulike"><i class="fas fa-thumbs-down"></i><%=u %></a>&nbsp;
									 
									 
									 <form action="share" method="post">
									 	<select name="usersId">
									 		<c:forEach items="${favusers}" var="user">
									 			<option value="${user.userId }">${user.fullName }</option>
									 		
									 		</c:forEach>
									 	</select>
									 	<input type="hidden" name="postId" value="${pt.postId }">
									 	<input type="hidden" name="userId" value="${param.userId }">
									 	<button type="submit" ><i class="fa fa-share-alt" aria-hidden="true"></i></button>
									 </form>
									 
									</p>
									<p><i class="fa-solid fa-comment"></i></p>
									<table>
									<c:forEach items="${cooments}" var="ct">
									<c:if test="${pt.postId eq ct.postId }">
									
										<tr>
											<td>
											CommentedBy:${ct.commentMailId }:${ct.commentDescription }
											
											</td>
											
										</tr>
										</c:if>
										</c:forEach>
										
									</table>
									<form action="addcomment" method="post">
										<textarea rows="5" cols="20" name="commentDescription">
										
										</textarea>
										
										<input type="submit" value="Add Comment">
										<input type="hidden" name="userId" value="${param.userId }">
										<input type="hidden" name="postId" value="${pt.postId }">
										
									
									</form>
									
									
								</div>

								</c:forEach>
								
								<div class="form-group">
								Posted By : ${user.fullName }
								</div>

							



						</div>
					</div>


				
				</div>
			</td>
		</tr>
	</table>

	<script src="script.js"></script>



</body>
</html>





