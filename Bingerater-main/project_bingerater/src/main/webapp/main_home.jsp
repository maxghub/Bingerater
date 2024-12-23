<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<title>MyMovieRate</title>

<style>
	*{
	    padding: 0;
	    margin: 0;
	}
	body{
	    font-family: Arial, Helvetica, sans-serif;
	    font-weight: 500;
	}
	
	#top
	{
	    display: flex;
	    background-color: black;
	    align-items: center;
	    height: 90px;
	    justify-content: space-between;
	    padding: 0 3rem;
	
	}
	div input{
		height: 30px;
		width: 300px;
	}
	div button{
		height: 20px;
		width:  70px;
	}
	nav ul{
	    display: flex;
	}
	#logo{
	    height: 30px;
	    width: 70px;
	    align-items: center;
	}
	
	li a{
	    color: beige;
	}
	nav ul li{
	    color:white;
	    list-style-type: none ;
	    margin: 10px;
	
	
	}
	
	
	#main{
	    display: flex;
	    background-color: green;
	    align-items: center;
	    padding-left: 25rem;
	    height: 50px;
	    padding: 0 3rem;
	    text-decoration-color: blue;
	   
	}
	.hello{
	    align-items: center;
	    /*padding-left: 0rem;*/
	    size: 100px;
	}
	div img{
	    display: inline-block ;
	    vertical-align:top;
	    /*float: left ;*/
	    width: 270px;
	    height: 400px;
	    float: left;
	    /*margin-right: 2px;*/
	    margin-top: 0px;
	}
	
	#main1{
	    display: flex;
	    background-color: green;
	    align-items: center;
	    padding-left: 25rem;
	    height: 50px;
	    padding: 0 3rem;
	    text-decoration-color: blue;
	   
	}
	.hello1{
	    align-items: center;
	    /*padding-left: 30rem;*/
	    size: 25px;
	}
	
	
	#main2{
	    display: flex;
	    background-color: green;
	    align-items: center;
	    padding-left: 25rem;
	    height: 50px;
	    padding: 0 3rem;
	    text-decoration-color: blue;
	   
	}
	.hello2{
	    align-items: center;
	    /*padding-left: 30rem;*/
	    size: 25px;
	}
	
	
	#main3{
	    display: flex;
	    background-color: green;
	    align-items: center;
	    padding-left: 25rem;
	    height: 50px;
	    padding: 0 3rem;
	    text-decoration-color: blue;
	   
	}
	.hello3{
	    align-items: center;
	    /*padding-left: 30rem;*/
	    size: 25px;
	}
	
	
	footer{
	    display: flex;
	    justify-content: space-between;
	    padding: 2rem 3rem;
	    background-color: black;
	    align-items: center;
	}
	footer div ul{
	    display: flex;
	    list-style-type: none;
	    justify-content: space-between;
	    align-items: center;
	   
	}
	footer div ul li i{
	    color: white;
	    font-size: 2rem;
	    border: 1px solid white;
	    padding: 0.5rem;
	    margin: 0.5rem;
	    border-radius: 15%;
	    align-items: center;
	
	}

</style>
</head>
<body>
<!-- Header -->
    <header>
    	<form action="moviereq">
	        <div id="top">
	          <div id="logo" >
	          	  <!-- His 
	              <input type="text" placeholder="search movie" size="20px" for="ma">
	              <button id="ma">search</button >-->
	              <!-- Mine -->
	              <input type="text" name="mov_var" placeholder="Search Movie"/>
				  <button id="ma">search</button >
	              
	          </div>
	        </div>
        </form>
    </header>
        <div id="main">
        <h1 class="hello" >In Theators</h1>
        </div>
        <div>
            <img src="images/in_theators/bp.png">
            <img src="images/in_theators/fb.png">
            <img src="images/in_theators/kf.png">
            <img src="images/in_theators/kfg2.png">
            <img src="images/in_theators/rrr.png">
        </div>


        <div id="main1">
            <h1 class="hello1" >Popular Anime</h1>
         </div>
         <div>
             <img src="images/popular_anime/naruto_uzamaki.png">
             <img src="images/popular_anime/aot.png">
             <img src="images/popular_anime/death_note.png">
             <img src="images/popular_anime/demon_slayer.png">
             <img src="images/popular_anime/full_metal_alchemist.png">
         </div>


         <div id="main2">
            <h1 class="hello2" >Upcoming Movies</h1>
         </div>
         <div>
             <img src="images/upcoming_movies/bhool_bhulaiyaa.png">
             <img src="images/upcoming_movies/hropanti_2.png">
             <img src="images/upcoming_movies/madness_of_multiverse.png">
             <img src="images/upcoming_movies/top_gun.png">
             <img src="images/upcoming_movies/prithavi_raj.png">
         </div>


         <div id="main3">
            <h1 class="hello3" >Recommended Web Series</h1>
         </div>
         <div>
             <img src="images/web_series/dark.png">
             <img src="images/web_series/goblin.png">
             <img src="images/web_series/bands_of_brothers.png">
             <img src="images/web_series/moon_knight.png">
             <img src="images/web_series/peaky_blinder.png">
         </div>

         <!-- footer -->
         <footer>
            <div>
                <ul id="icon">
                    <li><i class="fa-brands fa-facebook-f"></i></li>
                    <li><i class="fa-brands fa-instagram"></i></li>
                    <li><i class="fa-brands fa-linkedin"></i></li>
                    <li><i class="fa-brands fa-pinterest"></i></li>
                    <li><i class="fa-brands fa-youtube"></i></li>
                </ul>
            </div>
        </footer>
</body>
</html>