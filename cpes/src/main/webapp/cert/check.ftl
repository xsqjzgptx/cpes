<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Campaigs</title>

<!-- Css (necessary Css) -->
<link href="${APP_PATH}/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="${APP_PATH}/assets/css/bootstrap-theme.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${APP_PATH}/css/font-awesome.min.css">
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
<link href="${APP_PATH}/assets/css/sumoselect.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
    </div>
    <div class="mob-nav"></div>
    </div>
  </header>
  <!-- Header -->
	<div class="breadcrumb-sec donate-sec" style="background: url(${APP_PATH}/assets/extra-images/bg-under-page.jpg) no-repeat; background-size:100% auto; min-height:250px;">
		<div class="absolute-sec">
			<div class="container">
				<div class="cs-table">
					<div class="cs-tablerow">
						<div class="pageinfo page-title-align-left">
							<h1 style="color:#fff !important; text-transform:none;">实名认证验证码发送成功</h1>
							<strong style="text-align:center; display:block; color:#fff; font-weight:normal;" class="title">系统已将实名认证码发送到您的认证邮箱中</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Content -->
	<main id="main-content">
		<div class="main-section" style="padding:0;">
			<section class="page-section bg-donate">
				<div class="container">
					<div class="row">
						<div class="section-fullwidth">
							<div class="cs-content-holder">
								<div class="row">
									<div class="col-lg-12">
										<div class="donate-area">
											<ul class="nav nav-tabs" role="tablist">
												<li class="active" role="presentation"><a >实名认证申请信息</a></li>
											</ul>
											<div class="tab-content">
												<div id="messages" class="tab-pane active fade in" role="tabpanel">
													<div class="confirmation-area">
														<form id="codeForm" action="${APP_PATH}/member/cert/checkcode.do" method="post">
														<div class="donate-holder">
															<div class="icon-area">
																<i class="icon-check"></i>
															</div>
															<strong>系统已将实名认证码发送到您的认证邮箱中， 请输入您收到的认证码后继续认证流程</strong>
															<div class="input-area">
																<input type="text" name="authcode" id="authcode" value="" placeholder="请输入认证码">
															</div>
														</div>
														<div class="cs-holder">
															<input type="submit" onclick="checkAuthcode();return false;" value="提交">
														</div>
														</form>
													</div>
												</div>
												<div id="profile" class="tab-pane fade in" role="tabpanel">
													<div class="pyment-area">
														<div class="donate-holder">
															<div class="amount-area">
																<div class="left-side">
																	<p>
																		<span>$</span>
																		Total Amount
																	</p>
																</div>
																<div class="right-side">
																	<input type="text" value="$0.00">
																</div>
															</div>
															<div class="select-payments">
																<ul class="cs-gateway-wrap">
																	<li>
																		<div class="radio-image-wrapper">
																			<input type="radio" id="cs_paypal_gateway" value="cs_paypal_gateway" name="cs_payment_gateway" checked="checked" class="cs-gateway-calculation">
																			<label for="cs_paypal_gateway">
																				<span><img alt="#" src="${APP_PATH}/assets/extra-images/pyment1.png">
																				</span> 
																			</label>
																		</div>
																		<div class="radio-image-wrapper"><input type="radio" id="cs_authorizedotnet_gateway" value="cs_authorizedotnet_gateway" name="cs_payment_gateway" class="cs-gateway-calculation"><label for="cs_authorizedotnet_gateway"><span><img alt="#" src="${APP_PATH}/assets/extra-images/pyment2.png">
																				</span> </label>
																		</div>
																		<div class="radio-image-wrapper"><input type="radio" id="cs_pre_bank_transfer" value="cs_pre_bank_transfer" name="cs_payment_gateway" class="cs-gateway-calculation"><label for="cs_pre_bank_transfer"><span><img alt="#" src="${APP_PATH}/assets/extra-images/pyment3.png">
																				</span> </label></div>
																		<div class="radio-image-wrapper"><input type="radio" id="cs_skrill_gateway" value="cs_skrill_gateway" name="cs_payment_gateway" class="cs-gateway-calculation"><label for="cs_skrill_gateway"><span><img alt="#" src="${APP_PATH}/assets/extra-images/pyment4.png">
																				</span> </label>
																		</div>
																	</li>
																</ul>
															</div>
															<div class="cs-holder">
																<div class="infotext">
																	<p>Fled less sniffled sorrowful scorpion less hummed lorikeet dear jeepers more patiently shuffled close adjusted far the goodness grunted basically reprehensive the hello ahead more to slow along the unbearably fumblingly yikes sneered and and hence pill wobbled in one.</p>
																</div>
															</div>
															<div class="form-area">
																<form>
																	<input type="checkbox" id="pyment" class="directory-categories-checkbox" name="directory_categories" value="auto-parts">
																	<label for="pyment">Hide my donation from the public</label>
																</form>
															</div>
															<div class="cs-holder">
																<input type="submit" value="Go to Payments">
															</div>
														</div>
													</div>
												</div>
												<div id="messages" class="tab-pane fade in" role="tabpanel">
													<div class="confirmation-area">
														<div class="donate-holder">
															<div class="icon-area">
																<i class="icon-check"></i>
															</div>
															<strong>We recived your Payment</strong>
															<h3>Thank you so much for your Contribution</h3>
															<p>Patiently shuffled close adjusted far the goodness grunted basically<br> reprehensive the hello ahead more to slow along the unbearably fumblingly<br> yikes sneered and and hence pill wobbled in one.</p>
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
				</div>
			</section>
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

    <script src="${APP_PATH}/assets/scripts/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/assets/scripts/jquery-form.min.js"></script>
    <script src="${APP_PATH}/assets/scripts/bootstrap.min.js"></script>
    <script src="${APP_PATH}/assets/scripts/layer/layer.js"></script>
    <script src="${APP_PATH}/assets/scripts/menu.js"></script>
    <script src="${APP_PATH}/assets/scripts/jquery-ui-1.10.3.min.js"></script>
    <script src="${APP_PATH}/assets/scripts/functions.js"></script>
  <script>
  $(function() {
		jQuery("#slider").slider({
	      range: "min",
	      min: 1,
	      max: 100,
	      slide: function(event, ui) {
	        jQuery('.slider-value input').val(ui.value);
	      },
	  });  
		  
	    //$( "#slider" ).slider({
	//		change: function(event, ui) { 
	//			jQuery('.slider-value input').val(ui.value); 
	//		} 
	//	});
	
  });
  function checkAuthcode() {
      var authcode = $("#authcode").val();
      if ( authcode == "" ) {
          layer.msg("认证码不能为空", {time: 1000, icon:5, shift: 6});
          return;
      }
      
      $("#codeForm").ajaxSubmit({
        beforeSubmit : function() {
            loadingIndex = layer.msg('数据处理中', {icon: 16});
            return true;
        },
        async:true,
        success : function(r) {
            if ( r.success ) {
                setTimeout(function(){
                    layer.close(loadingIndex);
                    window.location.href = "${APP_PATH}/member/cert/finish.htm";
                }, 500);
            } else {
                var msg = "认证码提交失败";
                if ( r.error ) {
                    msg = r.error;
                }
                layer.msg(msg, {time: 1500, icon:2, shift: 6});
            }
        },
        error : function(r) {
            layer.close(loadingIndex);
        }
    });
  }
	  function logout() {
	      window.location.href = "${APP_PATH}/logout.do";
	  }
  </script>
</body>
</html>