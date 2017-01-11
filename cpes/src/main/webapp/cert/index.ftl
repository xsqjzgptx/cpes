<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Campaigs</title>

<link href="${APP_PATH}/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/bootstrap-theme.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/language-selector-remove-able-css.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="${APP_PATH}/assets/css/flexslider.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/style.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/plugin.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/responsive.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/menu.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/color.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/iconmoon.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/themetypo.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/widget.css" rel="stylesheet">
<style>
</style>
</head>
<body>
<div class="wrapper"> 
	
	<!-- Header -->
  <header id="main-header">
    <div class="container">
    <div class="main-head">
      <div class="left-side">
        <div class="logo"><a href="index.html"><img src="${APP_PATH}/assets/images/logo.png" alt=""></a></div>
        <nav class="navigation">
          <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Discover</a>
              <ul class="sub-dropdown">
                <li><a href="listing-grid.html">Grid View</a></li>
                <li><a href="listing.html">List view</a></li>
                <li><a href="detail.html">Detail Page</a></li>
              </ul>
            </li>
            <li><a href="creators.html">Creators</a></li>
            <li><a href="supporters.html">Supporters</a></li>
            <li><a href="#">Pages</a>
              <ul class="sub-dropdown">
                <li><a href="about.html">About us</a></li>
                <li><a href="faq.html">FAQ’s</a></li>
                <li><a href="contect.html">Contect</a></li>
                <li><a href="sign.html">Create an Account</a></li>
                <li><a href="sign.html">Sign In</a></li>
                <li><a href="404.html">404 Page</a></li>
                <li><a href="under.html">under-construction</a></li>
                <li><a href="terms.html">Terms &amp; Conditions</a></li>
                <li><a href="pricing.html">Price &amp; Packges</a></li>
                <li><a href="services.html">Services</a></li>
                <li><a href="site-map.html">Site Map</a></li>
                <li><a href="result.html">Result</a></li>
                <li><a href="donate.html">Donate</a></li>
                <li><a href="user-detail2.html">user detail2</a></li>
              </ul>
            </li>
            <li>
				<a href="#">News</a>
				<ul class="sub-dropdown">
					<li><a href="bloglrag.html">News Listing</a></li>
					<li><a href="blogmedium.html">News Medium</a></li>
					<li><a href="blogdetail.html">News Detail</a></li>
				</ul>
			</li>
          </ul>
        </nav>
      </div>
      <div class="right-side">
        <div class="cs-search-block">
          <form>
            <input type="text" id="s" name="s" value="Search Project" onfocus="if(this.value =='Search Project') { this.value = ''; }" onblur="if(this.value == '') { this.value ='Search Project'; }" class="form-control">
            <label>
              <input type="submit" value="Search">
            </label>
          </form>
        </div>
        <div class="profile-view">
          <ul>
            <li>
              <img alt="#" src="${APP_PATH}/assets/extra-images/user-img.jpg">
              <i class="icon-arrow-down8"></i>
              <div class="dropdown-area">
                <h5>${sessUser.name}</h5>
                <span>Member Since May 20, 2014</span>
                <ul class="dropdown">
                  <li><a href="causes.html"><i class="icon-flag5"></i>My Causes</a></li>
                  <li><a href="saved.html"><i class="icon-file-text-o"></i>Saved Causes</a></li>
                  <li><a href="my-donation.html"><i class="icon-file-text-o"></i>My Donations</a></li>
                  <li><a href="donation.html"><i class="icon-ticket6"></i>Donations</a></li>
                  <li><a href="profilesetting.html"><i class="icon-pie2"></i>Profile Settings</a></li>
                  <li><a href="create-new-cause.html"><i class="icon-plus6"></i>Create New</a></li>
                </ul>
                <a class="sign-btn" href="javascript:logout();"><i class="icon-logout"></i>用户退出</a>
              </div>
            </li>
          </ul>
        </div> 
    </div>
    <div class="mob-nav"></div>
    </div>
  </header>
  <!-- Header -->
	<div class="breadcrumb-sec" style="background:url(${APP_PATH}/assets/extra-images/banner.jpg) no-repeat; background-size:100% auto; min-height:157px!important;">
		<div class="absolute-sec">
			<div class="container">
				<div class="cs-table">
					<div class="cs-tablerow">
						<div class="pageinfo page-title-align-left">
							<h1 style="color:#fff !important; text-transform:none;">实名认证</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Main Content -->
	<main id="main-content">
		<div class="main-section">
			<div class="page-section">
				<div class="container">
					<div class="row">
						<div class="section-fullwidth col-lg-12">
							<div class="cs-content-holder">
								<div class="row">
									<div class="col-lg-12">
										<div class="main-heading top-center">
											<h1>请选择适合您业务需要的企业账户类型</h1>
											<strong class="title">通过企业实名认证，就可以使用易付宝企业版的各项服务</strong> 
										</div>
									</div>
									<div class="col-lg-4 col-md-4 col-sm-6">
										<div class="acctype cs-services morden top-center">
											<figure style="cursor:pointer;">
												<img class="" src="${APP_PATH}/assets/extra-images/services-box1.jpg" alt="#">
												<figcaption>
													<div class="service-number" >
														<span style="background-color:#DDD!important">1</span>
													</div>
												</figcaption>
											</figure>
											<div class="text">
												<h2>个人经营</h2>
												<p>适用于尚未工商注册的个人经营者（无法转账到其他易付宝账户）</p>
											</div>
										</div>
									</div>
									<div class="col-lg-4 col-md-4 col-sm-6">
										<div class="acctype cs-services morden top-center has-border">
											<figure style="cursor:pointer;">
												<img src="${APP_PATH}/assets/extra-images/services-box2.jpg" alt="#">
												<figcaption>
													<div class="service-number" >
														<span style="background-color:#DDD!important">2</span>
													</div>
												</figcaption>
											</figure>
											<div class="text">
												<h2>个体工商户</h2>
												<p>适用于具有营业执照，注册为个体工商户的企业或公司</p>
											</div>
										</div>
									</div>
									<div class="col-lg-4 col-md-4 col-sm-6">
										<div class="acctype cs-services morden top-center has-border">
											<figure style="cursor:pointer;">
												<img src="${APP_PATH}/assets/extra-images/services-box3.jpg" alt="#">
												<figcaption>
													<div class="service-number">
														<span style="background-color:#DDD!important">3</span>
													</div>
												</figcaption>
											</figure>
											<div class="text">
												<h2>商业公司</h2>
												<p>适用于具有营业执照，税务登记证和组织机构代码证的企业或公司</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> 
					</div>
				</div>
			</div>

			<div class="page-section callaction-sec">
				<div class="container">
					<div class="row">
						<div class="section-fullwidth col-lg-12">
							<div class="cs-content-holder">
								<div class="row">
									<div class="col-lg-12">
										<div class="call-actions align-center">
											<div class="cell btn-area" >
												<a style="border-radius: 10px;cursor:pointer;" class="applyBtn">申请实名认证</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!--// Main Content //--> 
	
	<!--// Footer Widget //-->
	<footer id="footer-sec">
		<div class="container">
			<div class="row">
				<div class="ads-sec col-lg-12"> <img src="${APP_PATH}/assets/images/ads.jpg" alt="" > </div>
				<div class="col-lg-12">
					<div class="tweet-sec">
						<p><i class="twitter-icon icon-twitter2"></i> Thing anyone did today was get ready for #Scandal <a href="#">http://t.co/UfiNiBLWlZ http://t.co/Fvggnf320f</a> <span class="by">Boxtheme</span> <span class="time">10 hours ago</span></p>
					</div>
				</div>
				<aside class="col-lg-4 col-md-4 col-sm-6 widget widget_categories">
					<div class="widget-section-title"> <strong class="title">Campaigning</strong> </div>
					<ul>
						<li><a href="#">Contributing</a></li>
						<li><a href="#">Publishing</a></li>
						<li><a href="#">Explore Partner Pages</a></li>
						<li><a href="#">Music</a></li>
						<li><a href="#">Daily Inspiration</a></li>
						<li><a href="#">Film and Theatre</a></li>
						<li><a href="#">Sign Up Now</a></li>
						<li><a href="#">Food and Drink</a></li>
						<li><a href="#">Private, secure, spam-free</a></li>
						<li><a href="#">Sports</a></li>
						<li><a href="#">School</a></li>
					</ul>
				</aside>
				<aside class="widget col-lg-4 col-md-4 col-sm-6 widget_categories">
					<div class="widget-section-title"> <strong class="title">Contributing</strong> </div>
					<ul>
						<li><a href="#">Crowdfunder API - Beta</a>
						<li><a href="#">How crowdfunding works</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Creating a project</a></li>
						<li><a href="#">Guides</a></li>
						<li><a href="#">Supporting a project</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Guidelines</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Partners</a></li>
					</ul>
				</aside>
				<aside class="widget col-lg-4 col-md-4 col-sm-6 widget_newsletter">
					<div class="widget-section-title"> <strong class="title">Weekly Newsletter</strong> </div>
					<form>
						<fieldset>
							<input type="submit" value="Submit" name="submit" class="cs-btn">
							<input class="email" type="email" placeholder="Your Email Address">
						</fieldset>
						<span>Private, secure, spam-free</span>
					</form>
				</aside>
			</div>
		</div>
	</footer>
	<!--// Footer Widget //--> 
	
	<!--// CopyRight //-->
	<div id="copyright">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="footer_icon"><a href="#"><img src="${APP_PATH}/assets/images/footer-logo.png" alt=""></a></div>
					<div class="fnav-area">
						<nav class="footer-nav">
							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">Categories</a></li>
								<li><a href="#">Showrooms</a></li>
								<li><a href="#">Agents</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</nav>
						<p>©2014 Box Theme All rights reserved. Design by <a href="http://www.jqueryfuns.com">Chimp Studio</a></p>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="social-media">
						<ul>
							<li><a href="#"><i class="icon-facebook7"></i></a></li>
							<li><a href="#"><i class="icon-twitter6"></i></a></li>
							<li><a href="#"><i class="icon-googleplus7"></i></a></li>
							<li><a href="#"><i class="icon-instagram4"></i></a></li>
							<li><a href="#"><i class="icon-youtube-play"></i></a></li>
							<li><a href="#"><i class="icon-skype"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--// CopyRight //--> 
	
</div>

	<!-- jQuery (necessary JavaScript) --> 
	<script src="${APP_PATH}/assets/scripts/jquery.js"></script> 
	<script src="${APP_PATH}/assets/scripts/bootstrap.min.js"></script>
	<script src="${APP_PATH}/assets/scripts/layer/layer.js"></script>
	<script src="${APP_PATH}/assets/scripts/modernizr.js"></script>
	<script src="${APP_PATH}/assets/scripts/menu.js"></script>
	<script src="${APP_PATH}/assets/scripts/counter.js"></script> 
	<script src="${APP_PATH}/assets/scripts/skills-progress.js"></script>
	<script src="${APP_PATH}/assets/scripts/jquery.flexslider-min.js"></script> 
	<script src="${APP_PATH}/assets/scripts/functions.js"></script>
	<script type="text/javascript">
	   jQuery(window).load(function(){
	    jQuery('.flexslider').flexslider({
	      animation: "slide",
	      prevText:"<em class='icon-arrow-left9'></em>",
	      nextText:"<em class='icon-arrow-right9'></em>",
	      start: function(slider){
	        jQuery('body').removeClass('loading');
	      }
	    });
	  });
	  var acctype = null;
	  $(function(){
	      $(".acctype").click(function(){
	          $(".acctype .service-number span").attr("style", "background-color:#DDD!important");
	          var spanObj = $(".service-number span", this);
	          acctype = parseInt(spanObj.text())-1;
	          spanObj.removeAttr("style");
	      });
	      
	      $(".applyBtn").click(function(){
	          if ( acctype == null ) {
	              layer.msg("请选择账户类型后再申请实名认证", {time: 1500, icon:5, shift: 6});
	              return;
	          }
	          
	          window.location.href = "${APP_PATH}/member/cert-1.htm?mtype="+acctype;
	      });
	  });
	  function logout() {
	      window.location.href = "${APP_PATH}/logout.do";
	  }
	</script>
	</body>
</html>