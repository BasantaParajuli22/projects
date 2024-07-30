let block = document.getElementById("div-inside");
let gameOverDisplay = document.getElementById("game_over");
let restartDisplay = document.getElementById("restart");
let positions = [];

// Generate random positions based on viewport size=
function generateRandomPositions(numPositions) {
    let viewportWidth = window.innerWidth;
    let viewportHeight = window.innerHeight;
    for (let i = 0; i < numPositions; i++) {
        //generate random number as x:left and y:top
        // by subtracting the block's width and height from the viewport width n height.
        let xleft = Math.random() * (viewportWidth - block.offsetWidth);
        let ytop = Math.random() * (viewportHeight - block.offsetHeight);
        positions.push({xleft: xleft, ytop: ytop});//storing as objects
    }
}
// Initialize positions
generateRandomPositions(10);

let scoreAdd = 0;
let currentIndex = 0;
//if click me button is pressed random position style is applied
block.addEventListener("click", function() {
    let currentPos = positions[currentIndex];
    block.style.left = `${currentPos.xleft}px`;
    block.style.top = `${currentPos.ytop}px`;
    currentIndex = (currentIndex + 1) % positions.length;//looping 
    scoreAdd += 1;//adding score
    console.log(scoreAdd);  
    document.getElementById("score").innerText = `Score: ${scoreAdd}`;  
    event.stopPropagation(); // to prevent the block click event from triggering the document click event.
});

document.addEventListener("click", function(event) {
    // Check if the click target is not the block
    if (event.target !== block && event.target !== gameOverDisplay && event.target !== restartDisplay) {
        //document.getElementById("game_over").innerHTML = "GAMe_over";
        showgameOverDisplay();
        restartDisplay.style.display = "block";
    }
});  

function showgameOverDisplay(){//game over function
    block.style.display = "none";
    gameOverDisplay.style.display = "block";
    restartDisplay.style.display = "block";
}

restartDisplay.addEventListener("click", function() {//if restart is pressed
    showrestartDisplay();
}); 
//reset function
function showrestartDisplay(){
    scoreAdd = 0;
    currentIndex = 0;
    document.getElementById("score").innerText = `Score: ${scoreAdd}`;
    // Reset block visibility and position
    block.style.display = "block";
    gameOverDisplay.style.display = "none";
    restartDisplay.style.display = "none";
    // Move the block to the first position
    let currentPos = positions[0];
    block.style.left = `0px`;
    block.style.top = `0px`;
}


// generates random numbers if screen is resized
window.addEventListener("resize", function() {
    positions = [];
    generateRandomPositions(10);
    currentIndex = 0;
}); 