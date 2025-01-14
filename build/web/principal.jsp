<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JOTAPLASTWEB</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <style>
    .circulo {
      width: 50px;
      height: 50px;
      border-radius: 50%;
    }

    .carousel {
      margin-top: 106px;
    }

    header {
      height: 50px;
    }

    .navbar {
      height: 56px;
    }

    .navbar-brand {
      display: flex;
      align-items: center;
    }

    .navbar .navbar-brand img {
      margin: auto 0;
    }
  </style>
</head>

<body>
  <div class="fixed-top">
    <!-- ENCABEZADO -->
    <header class="container-fluid bg-info">
        <p class="text-center fs-5 p-2 mb-0">Envío Gratis en Piedecuesta Contáctenos +57-3152397474</p>
    </header>
    <!-- MENÚ -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="http://127.0.0.1:5501/index.html">
                <img src="LOGO1.jpg" class="circulo" alt="Bootstrap" width="30" height="30">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="http://127.0.0.1:5501/index.html">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ofertas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://127.0.0.1:5501/quienessomos.html#">¿Quiénes somos?</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Categorías
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Hogar</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Negocio</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Aseo</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Eventos</a></li>
                            <!-- Más categorías aquí -->
                        </ul>
                    </li>
                </ul>
                <form class="d-flex" role="buscar">
                    <input class="form-control me-2" type="buscar" placeholder="¿Qué Buscas?" aria-label="Buscar">
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                </form>
                <button type="button" class="btn btn-warning ms-2">
                    <span style="font-size: 20px;"><i class="bi bi-cart4"></i></span>
                </button>
                <!-- Ícono de Usuario -->
                <div class="dropdown ms-3">
                    <a href="#" class="d-flex align-items-center text-dark text-decoration-none dropdown-toggle"
                        id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="userimg.jpg" alt="user" width="40" height="40" class="rounded-circle">
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="dropdownUser">
                        <li>
                            <img src="userimg.jpg" alt="user" width="80" height="80" class="rounded-circle">
                        </li>
                        <li><a class="dropdown-item">${NOMBRE}</a></li>
                        <li><a class="dropdown-item">${CORREO}</a></li>
                        <li><a class="dropdown-item">Desea Salir?</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a href="index.jsp" class="dropdown-item">Salir</a></li>
                        <li><a href="Controlador?accion=eliminar" class="dropdown-item">Novedades usuarios</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>


  <!--======================== CARRUSEL =======================-->
  <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
    <!--======================== RAYITAS DE ABAJO =======================-->
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
        aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="10000">
        <img src="ProductosN1.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Soluciones Prácticas para Tu Día a Día</h5>
          <p>Descubre cómo nuestros productos pueden mejorar tu entorno.</p>
        </div>
      </div>
      <div class="carousel-item" data-bs-interval="2000">
        <img src="Promociones.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <button type="button" class="btn btn-info">Más Información</button>
        </div>
      </div>
      <div class="carousel-item">
        <img src="imagen3 carrusel.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
            <a href="http://127.0.0.1:5501/pantalla2.html" class="btn btn-info">Más Información</a>
        </div>
    </div>    
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>

  <!--======================== UBICACIÓN =======================-->
  <div>
    <div class="row">
      <div class="col-lg-4 col-md-12 col-12">
        <div>
          <img src="logo ubicacion.jpg" alt="Nosotros" class="img-fluid">
        </div>
      </div>
      <div class="col-lg-8 col-md-12 ps-lg-5 mt-md-5">
        <h2>Encuéntranos en Piedecuesta</h2>
        <p class="fs-2">Te invitamos a visitarnos y descubrir nuestra amplia gama de productos desechables de calidad.
          Nuestro equipo estará encantado de asesorarte y ayudarte a encontrar las soluciones perfectas para tu hogar o
          negocio. ¡Ven y comprueba por ti mismo por qué somos la mejor opción en productos desechables!</p>
        <a class="btn btn-info"
          href="https://www.google.com/maps/place/Cra.+6+%231A-33,+Piedecuesta,+Santander/@6.9913688,-73.0552432,17z/data=!3m1!4b1!4m6!3m5!1s0x8e6847a629568503:0xa6d04eed1d88c400!8m2!3d6.9913688!4d-73.0526683!16s%2Fg%2F11fsmwzwzq?entry=ttu"
          role="button" target="_blank">Más Información</a>
      </div>
    </div>
  </div>
  <!--======================== PRODUCTOS =======================-->
  <section>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="section-header text-center pb-5">
            <h2>Nuestros Productos</h2>
            <p class="fs-3">¡Bienvenido a Nuestros Productos! Descubre nuestra amplia gama de artículos de calidad que
              mejorarán tu hogar y negocio.</p>
          </div>
        </div>
      </div>
      <h2>Más Vendidos:</h2>
      <div class="row justify-content-center">
        <div class="col-md-3">
        <div class="card ms-4 mb-4 mt-4 pb-2" style="width: 18rem;">
          <img src="Bolsa 5kg.jpg" class="card-img-top" alt="...">
          <div class="card-body text-center">
            <h5 class="card-title">Bolsa 5kg 100 unds.</h5>
            <p class="card-text">$10.000</p>
            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
          </div>
        </div>
        </div>
        <div class="col-md-3">
        <div class="card ms-4 mb-4 mt-4 pb-2" style="width: 18rem;">
          <img src="Vinipel 100 mts.jpg" class="card-img-top" alt="...">
          <div class="card-body text-center">
            <h5 class="card-title">Vinipel 100 mts</h5>
            <p class="card-text">$35.000</p>
            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
          </div>
        </div>
        </div>
        <div class="col-md-3">
        <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
          <img src="vasos 50 unids.jpg" class="card-img-top" alt="...">
          <div class="card-body text-center">
            <h5 class="card-title">Vasos Plásticos 50 unds.</h5>
            <p class="card-text">$15.000</p>
            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
          </div>
        </div>
        </div>
        <div class="col-md-3">
        <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
          <img src="Portas 2 div 200 unds.jpg" class="card-img-top" alt="...">
          <div class="card-body text-center">
            <h5 class="card-title">Portas 2 div. 200 unds.</h5>
            <p class="card-text">$98.000</p>
            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
          </div>
        </div>
        </div>
        <div class="col-md-3">
        <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
          <img src="Portas 2 div 200 unds.jpg" class="card-img-top" alt="...">
          <div class="card-body text-center">
            <h5 class="card-title">Portas 2 div. 100 unds.</h5>
            <p class="card-text">$50.000</p>
            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
          </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
            <img src="aluminio 100m.jpg" class="card-img-top" alt="...">
            <div class="card-body text-center">
              <h5 class="card-title">Aluminio 100 mts</h5>
              <p class="card-text">$28.000</p>
              <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
            </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
              <img src="palillos 100.jpg" class="card-img-top" alt="...">
              <div class="card-body text-center">
                <h5 class="card-title">Palillos 100 unds.</h5>
                <p class="card-text">$7.000</p>
                <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
              </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                <img src="servilletas x300.jpg" class="card-img-top" alt="...">
                <div class="card-body text-center">
                  <h5 class="card-title">Servilletas 300 unds.</h5>
                  <p class="card-text">$4.500</p>
                  <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                </div>
                </div>
              </div>
              <div>
                <h2>Ofertas de la Semana:</h2>
              </div>
              <div class="col-md-3">
                <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                  <img src="nevera icopor.jpg" class="card-img-top" alt="...">
                  <div class="card-body text-center">
                    <h5 class="card-title">Nevera Icopor 30KG</h5>
                    <p class="text-decoration-line-through mb-0">$20.000 </p><p class="card-text mt-0 text-danger fs-2">$18.000</p>
                    <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                  </div>
                  </div>
                </div>
                <div class="col-md-3">
                <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                  <img src="platos icopor x20.jpg" class="card-img-top" alt="...">
                  <div class="card-body text-center">
                    <h5 class="card-title">Platos 20 unds.</h5>
                    <p class="text-decoration-line-through mb-0">$10.000 </p><p class="card-text mt-0 text-danger fs-2">$9.000</p>
                    <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                  </div>
                  </div>
                </div>
                  <div class="col-md-3">
                    <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                      <img src="bolsa 30KG x100.jpg" class="card-img-top" alt="...">
                      <div class="card-body text-center">
                        <h5 class="card-title">Bolsa 30KG 100 unds.</h5>
                        <p class="text-decoration-line-through mb-0">$20.000 </p><p class="card-text mt-0 text-danger fs-2">$18.000</p>
                        <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                      </div>
                      </div>
                    </div>
                    <div class="col-md-3">
                <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                  <img src="porta sopa x20.jpg" class="card-img-top" alt="...">
                  <div class="card-body text-center">
                    <h5 class="card-title">Porta Sopa 20 unds.</h5>
                    <p class="text-decoration-line-through mb-0">$12.000 </p><p class="card-text mt-0 text-danger fs-2">$10.800</p>
                    <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                  </div>
                  </div>
                </div>
                <div>
                  <h2>Para el Hogar:</h2>
                </div>
                <div class="col-md-3">
                  <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                    <img src="Bolsa manija 15kg x100.jpg" class="card-img-top" alt="...">
                    <div class="card-body text-center">
                      <h5 class="card-title">Bolsa 15 KG 100 unds.</h5>
                      <p class="card-text">$14.000</p>
                      <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                    </div>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                      <img src="papel familia x12.jpg" class="card-img-top" alt="...">
                      <div class="card-body text-center">
                        <h5 class="card-title">Papel Higiénico 12 unds.</h5>
                        <p class="card-text">$9.000</p>
                        <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                      </div>
                      </div>
                    </div>
                    <div class="col-md-3">
                      <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                        <img src="toallas de cocina.jpg" class="card-img-top" alt="...">
                        <div class="card-body text-center">
                          <h5 class="card-title">Toallas Cocina 44 unds.</h5>
                          <p class="card-text">$10.000</p>
                          <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                        </div>
                        </div>
                      </div>
                      <div class="col-md-3">
                        <div class="card ms-4 mb-4 mt-4  pb-2" style="width: 18rem;">
                          <img src="escoba recogedor.jpg" class="card-img-top" alt="...">
                          <div class="card-body text-center">
                            <h5 class="card-title">Escoba y Recogedor</h5>
                            <p class="card-text">$8.000</p>
                            <a href="#" class="btn btn-warning">Añadir <i class="bi bi-cart4"></i></a>
                          </div>
                          </div>
                        </div>
      </div>
    </div>
  </section>
  <footer class="footer mt-auto py-3 bg-info">
    <div class="container text-center">
      <span class="text-muted">© 2024 JOTAPLAST. Todos los derechos reservados.</span>
    </div>
  </footer>
</div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>

</html>
