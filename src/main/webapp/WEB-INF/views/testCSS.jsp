<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<html>
<head>
<title>NEWEST</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">

</head>
<style type="text/css">
body {
	font: 73% helvetica, arial, sans-serif;
	line-height: 1.8em;
	background: #fff url(images/02.gif) repeat;
	color: #666;
}
/*BANNER PROPERTIES*/
#banner {
	width: 100%;
	height: 150px;
	background: #bbd9ee url(images/banner.jpg) top center no-repeat;
}

#banner h1 {
	margin: 0 0 0 250px;
	line-height: 1.8em;
	letter-spacing: 3px;
	font-size: 2em;
	color: #fff;
}

#banner p {
	float: right;
	margin: 10px 10px 0 0;
	padding-top: 10px;
	color: #ff9933;
}
/*TOP NAVIGATION*/
div#menu {
	float: left;
	width: 100%;
	padding-top: 0;
	background: #bbd9ee;
}

ul#nav,ul#nav li {
	list-style-type: none;
	margin: 0;
	padding: 0
}

ul#nav {
	margin-left: 250px;
	width: 500px;
}

ul#nav li {
	float: left;
	margin-right: 3px;
	text-align: center;
}

ul#nav a {
	float: left;
	width: 7em;
	padding: 5px 0;
	background: #ff9933;
	text-decoration: none;
	color: #fff;
}

ul#nav a:hover {
	background: #e7f1f8;
	color: #666;
}

ul#nav li.activelink a,ul#nav li.activelink a:hover {
	background: #fff;
	color: #003;
}
/*MAIN CONTAINER*/
#container {
	width: 770px;
	margin: 0 auto;
	padding: 0;
}

#box {
	padding: 10px;
	border: 1px solid #ff9933;
	background: #e7f1f8;
}

#box h2 {
	font-size: 2em;
	color: #06a;
}
/*CONTENT_LEFT*/
#content {
	width: 490px;
	float: left;
	margin: 50px 0 0 0;
	padding: 0 0 30px 10px;
}

#content h1 {
	font-size: 1.5em;
	letter-spacing: 3px;
	text-transform: uppercase;
	color: #06a;
}
/*CONTENT_RIGHT*/
#content_right {
	width: 200px;
	float: right;
	margin: 50px 10px 0 0;
	padding-bottom: 30px;
}
/*FOOTER*/
#footer {
	clear: both;
	height: 50px;
	padding: 5px;
	border-top: 3px solid #ff9933;
	background: #bbd9ee;
}
/*TYPOGRAPHY*/
blockquote {
	font-weight: bold;
	font-style: italic;
	color: #b29b35;
}

.small {
	color: #ff9933;
	font-size: 0.8em;
}

.big {
	font-weight: bold;
	font-size: 1.2em;
	color: #ff9933;
}
/*IMAGES*/
.imgright {
	float: left;
	margin: 10px;
	padding: 10px;
}
/*CURVED CORNERS*/
dl.curved {
	background: #bbd9ee url(images/c_tl.gif) top left no-repeat;
	margin: 15px 0;
	padding: 0;
	width: 100%;
}

dl.curved dt {
	background: transparent url(images/c_tr.gif) top right no-repeat;
	padding: 10px;
	text-align: center;
	font-weight: bold;
	color: #fff;
}

dl.curved dd {
	background: #eee url(images/c_bl.gif) bottom left no-repeat;
	padding: 0;
	margin: 0;
}

dl.curved dd p {
	margin: 0;
	padding: 10px;
	line-height: 1.53em;
}

dl.curved dd p.last {
	background: transparent url(images/c_br.gif) bottom right no-repeat;
}
/*LINK PROPERTIES*/
a img {
	border: none;
}

a:link,a:visited {
	color: #286e87;
	background: inherit;
	text-decoration: none;
}

a:hover {
	text-decoration: none;
	color: #999;
	background: inherit;
}

#navlist li {
	list-style-image: url(images/right.gif);
	background: inherit;
	color: #ff9933;
	margin: 5px 0 0 0;
	padding-left: 10px;
}
</style>
<body>
	<div id="banner">
		<p>
			<a href="http://www.free-css.com/"><img src="images/home.gif"
				alt="homepage"></a> | <a href="mailto:denise@mitchinson.net"><img
				src="images/mail.gif" alt="contact"></a>
		</p>
		<h1>Your Company Name ...</h1>
	</div>
	<div id="menu">
		<ul id="nav">
			<li id="home"><a href="http://www.free-css.com/">Home</a></li>
			<li id="who" class="activelink"><a
				href="http://www.free-css.com/">About</a></li>
			<li id="prod"><a href="http://www.free-css.com/">Product</a></li>
			<li id="serv"><a href="http://www.free-css.com/">Services</a></li>
			<li id="cont"><a href="http://www.free-css.com/">Contact us</a></li>
		</ul>
	</div>
	<div id="container">
		<div id="content">
			<h1>
				Welcome to <span style="font-weight: bold; color: #C4DA64;">StopWatch</span>
				Template
			</h1>
			<p class="big">
				Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Praesent
				rhoncus molestie dui. Proin euismod dignissim justo. Curabitur id
				urna non lorem egestas viverra. Aenean feugiat nisl et urna.
				Suspendisse vestibulum. Duis ligula ante, porttitor id, tempor a,
				tincidunt sed, dolor. Aliquam feugiat sollicitudin tellus. <a
					href="http://www.free-css.com/">This is a link to nowhere.</a>
				Aenean augue arcu, venenatis sed, pulvinar non, hendrerit nec, odio.
				Duis ligula. Nulla in urna eu tellus auctor convallis. Nam elementum
				posuere enim.
			</p>
			<div id="box">
				<h2>
					<img src="images/last.gif" alt="ad"> Advertise Your Site Here
				</h2>
				<blockquote>
					This template has been tested in Mozilla and IE7 and validates as
					HTML 4.01 Strict using valid CSS. Icons are courtesy of <a
						href="http://www.exploding-boy.com/2005/09/13/explodingboy-pixel-icons/"
						title="exploding-boy">Exploding Boy</a><br /> For more FREE CSS
					templates visit <a href="http://www.mitchinson.net"
						title="my website">my website</a>.
				</blockquote>
				<p>Duis autem vel eum iriure dolor in hendrerit in vulputate
					velit esse molestie consequat, vel illum dolore eu feugiat nulla
					facilisis at vero eros et accumsan et iusto odio dignissim qui
					blandit praesent luptatum zzril delenit augue duis dolore te
					feugait nulla facilisi.</p>
			</div>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Praesent rhoncus molestie dui. Proin euismod dignissim justo.
				Curabitur id urna non lorem egestas viverra. Aenean feugiat nisl et
				urna. Suspendisse vestibulum. Duis ligula ante, porttitor id, tempor
				a, tincidunt sed, dolor. Aliquam feugiat sollicitudin tellus. Aenean
				augue arcu, venenatis sed, pulvinar non, hendrerit nec, odio. Duis
				ligula. Nulla in urna eu tellus auctor convallis. Nam elementum
				posuere enim.</p>
			<p>Praesent enim nulla, lacinia vel, accumsan ut, facilisis eget,
				ligula. Sed suscipit, nisi id semper varius, justo turpis pretium
				orci, in cursus lorem nunc id ipsum. Curabitur ipsum.</p>
		</div>
		<div id="content_right">
			<dl class="curved">
				<dt>RECOMMENDED LINKS</dt>
				<dd>
					<br />
					<ul id="navlist">
						<li><a href="http://www.free-css.com/">Snapp Happy</a></li>
						<li><a href="http://www.free-css.com/">Open Designs</a></li>
						<li><a href="http://www.free-css.com/">Andreas Viklund</a></li>
						<li><a href="http://www.free-css.com/">James Koster</a></li>
						<li><a href="http://www.free-css.com/">CSS play</a></li>
						<li><a href="http://www.free-css.com/">Listamatic</a></li>
					</ul>
					<p class="last">&nbsp;</p>
				</dd>
			</dl>
			<dl class="curved">
				<dt>
					CURVED CORNERS<span class="small"> by Stu Nicholls</span>
				</dt>
				<dd>
					<p>Ok, finally a four corner box with no extra markup.</p>
					<p>No javascript and absolutely no hacks.</p>
					<p class="last">
						Examples at <a href="http://www.cssplay.co.uk">&#0187; CSS
							Play</a>
					</p>
				</dd>
			</dl>
			<dl class="curved">
				<dt>MORE INFORMATION</dt>
				<dd>
					<p>Nulla in urna eu tellus auctor convallis.</p>
					<p class="last">Morbi sodales vehicula nisi. Donec id tortor.</p>
				</dd>
			</dl>
		</div>
	</div>
	<div id="footer">
		<p>
			<a href="http://www.free-css.com/">homepage</a> | <a
				href="mailto:denise@mitchinson.net">contact</a> | &copy; 2007 Anyone
			| Design by <a href="http://www.mitchinson.net">
				www.mitchinson.net</a> | Licensed under a <a rel="license"
				href="http://creativecommons.org/licenses/by/3.0/">Creative
				Commons Attribution 3.0 License</a>
		</p>
	</div>
</body>
</html>
