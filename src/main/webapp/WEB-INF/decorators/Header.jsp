<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- A grey horizontal navbar that becomes vertical on small screens -->
    <nav class="navbar navbar-expand-md bg-dark navbar-dark navbar-fixed-top" style="position: fixed; width: 100%; top: 0; z-index: 100;">
        <!-- Brand -->
        <a class="navbar-brand" href="#">
            <img src="Images/WhatsappImage.jpeg" width="50px" height="50px">
        </a>


        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon justify-content-end"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-fixed-top navbar-collapse justify-content-end" id="collapsibleNavbar" position="fixed">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#home" id="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#aboutus">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Facility</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contactus">Contact Us</a>
                </li>
            </ul>
            <form class="" action="#">
                <button class="btn btn-outline-success" type="submit">Login</button>
            </form>
        </div>

    </nav>


