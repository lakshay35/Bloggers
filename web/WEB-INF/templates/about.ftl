<!DOCTYPE html>
<html>
<title>BLoggers</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
    .w3-bar-block .w3-bar-item {padding:20px}
    .menu {
        width: 20px;
        height: 3px;
        background-color: black;
        margin: 3px 0;
    }
</style>
<body>

<!-- Sidebar (hidden by default) -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
    <a href="javascript:void(0)" onclick="w3_close()"
       class="w3-bar-item w3-button">Close Menu</a>
    <#if name?has_content>
        <form action="Blog" method="get">
            <button name="logoutButton" class="w3-bar-item w3-button">Sign Out</button>
            <button name="aboutButton" class="w3-bar-item w3-button">About</button>
            <button name="homepageButton" class="w3-bar-item w3-button">Home</button>
        </form>
    <#else>
        <a href="signin.html" class="w3-bar-item w3-button">Sign In</a>
        <form action="Blog" method="get">
            <button name="aboutButton" class="w3-bar-item w3-button">About</button>
        </form>
        <a href="index.html" class="w3-bar-item w3-button">Home</a>
    </#if>
</nav>

<!-- Top menu -->
<div class="w3-top">
    <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <#if name?has_content>
        <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()"><div class="menu"></div><div class="menu"></div><div class="menu"></div></div>
        <div class="w3-right w3-padding-16"><span style="text-decoration: none">Hello, ${name}</span></div>
        <div class="w3-center w3-padding-16">About</div>
    <#else>
        <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()"><div class="menu"></div><div class="menu"></div><div class="menu"></div></div>
        <div class="w3-right w3-padding-16"><span style="text-decoration: none">B</span></div>
        <div class="w3-center w3-padding-16">About</div>
    </#if>
    </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

    <div>
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        <ul>
            <li>Lorem</li>
            <li>Ipsum</li>
            <li>Dimsum</li>
        </ul>
        More Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        More Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
        Lorem ipsum dimsum I want to blog about dimsum cause I have become disum by eating lorem ipsum dimsum.
    </div>
    <hr id="about">

    <!-- Footer -->
    <footer class="w3-row-padding w3-padding-32">
        <div class="w3-third">
            <h3>FOOTER</h3>
            <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </div>

        <div class="w3-third w3-serif">
            <h3>POPULAR TAGS</h3>
            <p>
                <span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">New York</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dinner</span>
                <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Salmon</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">France</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Drinks</span>
                <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Ideas</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Flavors</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Cuisine</span>
                <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Chicken</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dressing</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fried</span>
                <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fish</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Duck</span>
            </p>
        </div>
    </footer>

    <!-- End page content -->
</div>

<script>
    // Script to open and close sidebar
    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
    }

    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
    }
</script>

</body>
</html>
