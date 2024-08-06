//game logic 
function playGame (input){
    let ai_input = "";
    ai_input = aiPlay();
    let finalResult = " ";

    if(input === ai_input ){
        finalResult = "draw";
        addDrawScore();
    }
    else if((input === "scissors" &&  ai_input === "rock") || (input === "paper" &&  ai_input ==="scissors" )||(input === "rock" &&  ai_input ==="paper" )){
        finalResult = "lose";
        addScore();
    }
    else if((input === "rock" &&  ai_input === "scissors") || (input === "scissors" &&  ai_input === "paper" )||(input === "paper" &&  ai_input ==="rock" )){
        finalResult = "win";
        addMyScore();
    }
    document.getElementById("result").innerHTML = finalResult;
}

//computer choice functions
function aiPlay(){
    choice = ["rock", "paper", "scissors"];
    let choiceIndex = Math.floor(Math.random()*3);
    let  aiInput = choice[choiceIndex]
    return aiInput;
}

//score systems
let getAIscore = "" ;
function addScore(){
    let score = localStorage.getItem("aiScore",getAIscore);
    score++;
    localStorage.setItem("aiScore",score);
   document.getElementById("aiScore").innerHTML = `<h2> ${score}::: <br> </h2>`;
}
let getMyscore = "" ;
function addMyScore(){
    let myScore = localStorage.getItem("myScore",getMyscore);
    myScore++;
    localStorage.setItem("myScore",myScore);
    document.getElementById("myScore").innerHTML =`<h2> ${myScore}::: <br> </h2>`;
}

let getDrawscore = "" ;
function addDrawScore(){
    let drawScore = localStorage.getItem("drawScore",getDrawscore);
    drawScore++;
    localStorage.setItem("drawScore",drawScore);
    document.getElementById("drawScore").innerHTML =`<h2> ${drawScore} <br> </h2> `;
}

//resetting scores to 0
function resetScore(){
    let resetScore = 0; 
    localStorage.setItem("aiScore",resetScore);
    localStorage.setItem("myScore",resetScore);
    localStorage.setItem("drawScore",resetScore);

    document.getElementById("aiScore").innerHTML = `<h2> ${resetScore}::: <br> </h2>`;
    document.getElementById("myScore").innerHTML =`<h2> ${resetScore}::: <br> </h2>`;
    document.getElementById("drawScore").innerHTML =`<h2> ${resetScore} <br> </h2> `;
}
