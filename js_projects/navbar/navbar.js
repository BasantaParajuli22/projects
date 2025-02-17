console.log("Script loaded!");

//when clicking button toggling links to be shown or hidden
document.querySelector('.menu-button').addEventListener('click',function(e){
    
    console.log("helloo ");
     
    // Stop event from reaching the body click handler
    e.stopPropagation();

    const links = document.querySelector('.nav-links');
    links.classList.toggle('active');
   
});

//when outside of navbarlinks clicked
document.body.addEventListener('click',()=>{
 
    const links = document.querySelector('.nav-links');

    //if links contains active classList removing it to hide links
    if(links.classList.contains('active')){
        links.classList.remove('active');
    }
});