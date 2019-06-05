<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/feed">SocialNetwork</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/feed">Feed</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profil</a>
            </li>
            <li>
                <form class="form-inline my-2 my-lg-0" action="/search">
                    <input class="form-control mr-sm-2" name="q" type="text">
                    <button class="btn" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </li>
        </ul>
        <ul class="navbar-nav">
            <button class="btn" id="logoutbtn">Logout</button>
        </ul>
    </div>
</nav>