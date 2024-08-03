const slides = document.querySelectorAll(".slides img");
let slideIndex = 0;
let intervalTime = 0;

// initialslide();
document.addEventListener("DOMContentLoaded",initialslide());//initial slide will work after document is fully loaded
function initialslide(){
    slides[slideIndex].classList.add("displayBlock");
    intervalTime = setInterval(nextSlide,3000);
}

function displaySlide(){
    if(slideIndex < 0){
        slideIndex = slides.length-1;
    }else if(slideIndex >= slides.length){
        slideIndex = 0;
    }
    if(slideIndex < slides.length){
        slides.forEach(slide => {
            //removing displayBlock if u want to view next slide
            slide.classList.remove("displayBlock");
        });
    }
    //adding displayBlock to next one
    slides[slideIndex].classList.add("displayBlock");
}

function prevSlide(){
    clearInterval(intervalTime);//will never start interval 
    slideIndex--;
    displaySlide(slideIndex);
}
function nextSlide(){
    clearInterval(intervalTime);
    intervalTime = setInterval(nextSlide, 3000);  // Restart the interval
    slideIndex++;
    displaySlide(slideIndex);
    
}

