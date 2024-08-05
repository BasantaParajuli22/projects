let index = 0;
array = ["black","red","white"];
array2 = ["black","red","white","green","yellow"];
document.querySelector("#colorButton").addEventListener("click",function(){
//sequnece color change
  if(index >= array.length){
    index = 0;
  }
  let newColor = array[index];
  index++;

  document.body.style.backgroundColor = newColor; 

//using random
  // using query selector 
  let randomIndex = Math.floor(Math.random()*array2.length);
  let newTextColor = array2[randomIndex];
  let singleContainer = document.querySelector(".container");
  singleContainer.style.color = newTextColor; 

  //using querySelectorAll
  let randomIndex2 = Math.floor(Math.random()*array2.length);
  let newTextColor2 = array2[randomIndex2];
  let allContainer = document.querySelectorAll(".container2");
 
  allContainer.forEach(element => {
    element.style.color = newTextColor2; 
  });

});

// function randomIndex(){
//   let randomIndex = Math.floor(Math.random()*array2.length);
//   return randomIndex;
// }

//notes::::
// querySelector:

// Returns the first element that matches the specified selector(s).
// It's used when you need to select and manipulate a single element.

//      VS  ///

// querySelectorAll:

// Returns a static NodeList (an array-like collection) of all elements that match the specified selector(s).
// It's used when you want to select and manipulate multiple elements at once.