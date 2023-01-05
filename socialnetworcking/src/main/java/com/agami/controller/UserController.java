package com.agami.controller;



import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agami.model.CommentTl;
import com.agami.model.FollowUser;
import com.agami.model.LikeTl;
import com.agami.model.PostTl;
import com.agami.model.ShareTl;
import com.agami.model.UserTl;
import com.agami.service.CommentService;
import com.agami.service.FollowUserService;
import com.agami.service.LikeService;
import com.agami.service.PostService;
import com.agami.service.ShareService;
import com.agami.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FollowUserService followUserService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeService likeService;
	@Autowired
	private ShareService shareService;
	
	@GetMapping("/reg")
	public String showReg(Model model) {

		return "Registration";
	}

	@PostMapping("/reg")
	public String reg(HttpServletRequest request, UserTl user) {
		UserTl _user = userService.insertUser(user);
		if (_user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("AUTH_USER", _user);
			return "redirect:login";
		}

		return "Registration";
	}

	@GetMapping("/login")
	public String showLog(Model model) {

		return "login";
	}

	@PostMapping("/login")
	public String log(HttpServletRequest request, UserTl user) {
		UserTl _user = userService.getUser(user.getEmailId(),user.getPassword());

		if (_user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("AUTH_USER", _user);
			return "redirect:home";
		}

		return "login";
	}

	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				List<PostTl> posts=postService.getSharedPosts(user.getUserId());
				request.setAttribute("posts", posts);
				
				return "home";
			}

		}

		return "login";
	}

	@GetMapping("/changepassword")
	public String changepassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				return "changepassword";
			}

		}

		return "login";
	}

	@PostMapping("/changepassword")
	public String changepasswordold(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				String password = request.getParameter("password");
				String cpassword = request.getParameter("cpassword");
				String opassword = request.getParameter("opassword");
				if (opassword.equals(user.getPassword()) && password.equals(cpassword)) {
					user.setPassword(password);
					userService.insertUser(user);
					return "redirect:home";
				}

				return "changepassword";
			}

		}

		return "login";
	}

	@GetMapping("/editprofile")
	public String editprofile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				return "editprofile";
			}

		}

		return "login";
	}

	@GetMapping("/search")
	public String search(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				
				return "search";

			}

		}

		return "login";
	}
	

	@GetMapping("/users")
	public String users(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				List<UserTl> users=userService.getUsers();
				List<FollowUser> fusers=followUserService.getFollowUsers();
				if(users!=null)
				{
					
					if(fusers!=null)
					{
					 List<Integer>	fus=fusers.stream().filter(f->f.getCreatedBy().equals(user.getUserId())).map(f->f.getUserId()).toList();
					
					 List<UserTl> favusers=users.stream().filter(u->u.getUserId()!=user.getUserId()&&fus.contains(u.getUserId())).collect(Collectors.toList());
					 
					 List<UserTl> nfavusers=users.stream().filter(u->u.getUserId()!=user.getUserId()&&!fus.contains(u.getUserId())).collect(Collectors.toList());
					 
					 request.setAttribute("favusers", favusers);
					 request.setAttribute("nfavusers", nfavusers);
					}
				}
				
				
				return "users";

			}

		}

		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("/articles")
	public String articles(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				List<PostTl> posts=postService.getPosts();
				log.info("posts"+posts.size()+"posts"+posts);
				if(posts!=null)
				{
					posts=posts.stream().filter(p->p.getPostCreatedBy().equals(user.getUserId())).toList();
					log.info("posts"+posts.size()+"posts"+posts);
					request.setAttribute("posts", posts);
					
				}
				
				return "articles";

			}

		}

		return "login";
	}
	
	@PostMapping("/articles")
	public String articlesPost(HttpServletRequest request,PostTl postTl) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				
				postTl.setPostCreatedBy(user.getUserId());
				postTl.setPostDate(new java.sql.Date(new java.util.Date().getTime()));
				postService.insertPost(postTl);
				return "redirect:articles";

			}

		}

		return "login";
	}
	
	@GetMapping("/folowuser")
	public String folowuser(HttpServletRequest request,@RequestParam("userId") Integer userId) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				
				FollowUser followUser=new FollowUser();
				followUser.setCreatedBy(user.getUserId());
				followUser.setUserId(userId);
				followUser.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				followUserService.insertFollowUser(followUser);
				
				return "redirect:users";

			}

		}

		return "redirect:login";
	}
	
	@GetMapping("/show")
	public String show(HttpServletRequest request,@RequestParam("userId") Integer userId) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {
				
				List<PostTl> posts=postService.getPosts();
				log.info("posts"+posts.size()+"posts"+posts);
				if(posts!=null)
				{
					posts=posts.stream().filter(p->p.getPostCreatedBy().equals(userId)).toList();
					log.info("posts"+posts.size()+"posts"+posts);
					request.setAttribute("posts", posts);
					request.setAttribute("cooments", commentService.getComments());
					request.setAttribute("likes", likeService.getLikes());
					
					
					List<UserTl> users=userService.getUsers();
					List<FollowUser> fusers=followUserService.getFollowUsers();
					if(users!=null)
					{
						
						if(fusers!=null)
						{
						 List<Integer>	fus=fusers.stream().filter(f->f.getCreatedBy().equals(user.getUserId())).map(f->f.getUserId()).toList();
						
						 List<UserTl> favusers=users.stream().filter(u->u.getUserId()!=user.getUserId()&&fus.contains(u.getUserId())).collect(Collectors.toList());
						 
						 List<UserTl> nfavusers=users.stream().filter(u->u.getUserId()!=user.getUserId()&&!fus.contains(u.getUserId())).collect(Collectors.toList());
						 
						 request.setAttribute("favusers", favusers);
						 request.setAttribute("nfavusers", nfavusers);
						}
					}
					
				}
				request.setAttribute("user", userService.getUser(userId));
				
				return "show";

			}

		}

		return "redirect:login";
	}
	

	@PostMapping("/editprofile")
	public String changepasswordold(UserTl userTl, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {

				user.setFullName(userTl.getFullName());
				user.setMobileNumber(userTl.getMobileNumber());
				userService.updateUser(user);
				return "redirect:home";
			}
			return "redirect:login";

		}

		return "login";
	}
	
	@PostMapping("/addcomment")
	public String addcomment(CommentTl commentTl, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {

				commentTl.setCommentCreatedBy(user.getUserId());
				commentTl.setCommentMailId(user.getEmailId());
				commentTl.setCommentCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
				
				
				commentService.insertComment(commentTl);
				return "redirect:show?userId="+request.getParameter("userId");
			}
			return "redirect:login";

		}

		return "login";
	}
	
	@GetMapping("/like")
	public String like(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {

				String status=request.getParameter("status");
				String postId=request.getParameter("postId");
				LikeTl likeTl=new LikeTl();
				likeTl.setCreatedId(user.getUserId());
				likeTl.setStatus(status);
				likeTl.setPostId(Integer.valueOf(postId));
				likeTl.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				likeService.insertLike(likeTl);
				return "redirect:show?userId="+request.getParameter("userId");
			}
			return "editprofile";

		}

		return "login";
	}
	
	@PostMapping("/share")
	public String share(ShareTl shareTl, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			UserTl user = (UserTl) session.getAttribute("AUTH_USER");
			if (user != null) {

				shareTl.setCreatedBy(user.getUserId());
				
				shareTl.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				shareService.inserShare(shareTl);
				return "redirect:show?userId="+request.getParameter("userId");
			}
			return "redirect:login";

		}

		return "login";
	}


	
	
	
	

}
