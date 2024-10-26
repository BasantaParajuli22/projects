// let time=new Date();
// console.log(time);



// let dateTime=new Date();

// var hrs=dateTime.getHours();
// var min=dateTime.getMinutes();
// var sec=dateTime.getSeconds();
// document.write(`Hours: ${hrs} `);
// document.write(`Minutes: ${min} `);
// document.write(`Seconds: ${sec} `);

displayTime();
function displayTime()
{
    var dateTime=new Date();
    var hrs=dateTime.getHours();
    var min=dateTime.getMinutes();
    var sec=dateTime.getSeconds();
     var milsec=dateTime.getMilliseconds();
    if(hrs>=12)
    {
        session.innerHTML="PM";
    }else{
        session.innerHTML="AM";
    }
    if(hrs>12){
        hrs=hrs-12;
    }

    document.getElementById("hours").innerHTML=hrs;
    document.getElementById("minutes").innerHTML=min;
    document.getElementById("seconds").innerHTML=sec;
    document.getElementById("milliseconds").innerHTML=milsec;
    
}
setInterval(displayTime,1000)


