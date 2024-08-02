
var string ="";
var buttons = document.querySelectorAll(".button");//selects all elements that have the class button.
//Creates an array from an iterable buttons // for every button pressed 
Array.from(buttons).forEach(function(button){
  //used to attach an event listener to a button element
  button.addEventListener("click",function(e){

    if((e.target.innerHTML) === "="){//if = is pressed
      try{
        string = eval(string);// if string is "2+2", eval(string) will return 4 then assigned back to string.
        document.querySelector("input").value = string; 
      }catch(error){
        document.querySelector("input").value = "error"; 
      }
    }else if((e.target.innerHTML) === "c"){//if c is pressed
      string = "";
      document.querySelector("input").value = ""; 
    }else{
      string = string + e.target.innerHTML;//adding to everything of innerHTML to string except // c = //
      document.querySelector("input").value = string; //updating input value
    }

  });
});
