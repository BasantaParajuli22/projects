

//future date not changing 
const future = new Date();
const futureDate = future.setDate(future.getDate() +2);//adding +10 days

// console.log(typeof(now));
// console.log(typeof(future));
// console.log(typeof(futureDate));
// console.log(typeof(distance));

//for Date object we can 
// const hours = now.getHours();
// const minutes = now.getMinutes();
// const seconds = now.getSeconds();


//because distance is number 

function updateCountdownClock(){

const now = new Date();//current time changes 

const distance = futureDate - now;

const days = Math.floor(distance / (1000 * 60 * 60 * 24));
const hours =  Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
const minutes =  Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60 ));
const seconds =  Math.floor((distance % (1000 * 60)) / (1000));

document.getElementById("days").innerHTML = days;
document.getElementById("hours").innerHTML= hours;
document.getElementById("minutes").innerHTML= `${minutes}`;
document.getElementById("seconds").innerHTML= `${seconds}`;


  // Update the DOM with the calculated values
  document.getElementById("days").innerHTML = days < 10 ? `0${days}` : days;
  document.getElementById("hours").innerHTML = hours < 10 ? `0${hours}` : hours;
  document.getElementById("minutes").innerHTML = minutes < 10 ? `0${minutes}` : minutes;
  document.getElementById("seconds").innerHTML = seconds < 10 ? `0${seconds}` : seconds;

}

const interval = setInterval(updateCountdownClock,1000);

updateCountdownClock();