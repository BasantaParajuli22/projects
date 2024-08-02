const recipes = [//An array of recipe objects with title, ingredients, and instructions.
    {
        title: "Spaghetti Carbonara",
        ingredients: ["Spaghetti", "Eggs", "Parmesan cheese", "Pancetta", "Garlic", "Salt", "Pepper"],
        instructions: "Cook spaghetti. In a pan, cook pancetta and garlic. Mix eggs and cheese, then combine with spaghetti and pancetta."
    },
    {
        title: "Chicken Salad",
        ingredients: ["Chicken breast", "Lettuce", "Tomatoes", "Cucumber", "Olive oil", "Lemon juice", "Salt", "Pepper"],
        instructions: "Cook chicken and slice it. Mix with lettuce, tomatoes, and cucumber. Dress with olive oil and lemon juice."
    },
    {
        title: "Rice",
        ingredients:["rice","water","ghee"],
        instructions:"mix all and cook "
    }
];


function displayRecipes(){
    let recipeList = document.getElementById('recipe-list');
    recipeList.innerHTML = '';

    recipes.forEach(recipe =>{
        let recipediv = document.createElement('div');
        recipediv.className = "recipee";

        recipediv.innerHTML = `
           <h1> ${recipe.title}</h1><br>
           <div class ="Ingredients"> Ingredients: ${recipe.ingredients }</div>
           <div class ="instructions"> Instructions: ${recipe.instructions}</div>
        `;
        recipeList.appendChild(recipediv);
    });
}
displayRecipes(recipes); // Initial display of recipes 

//filtering recipe with search-input
function searchrecipe(searchInput){
    const recipeFilter = recipes.filter(recipe =>
        recipe.title.toLowerCase().includes(searchInput.toLowerCase())//if recipe.title includes searchInput it returns true
    );
    displayRecipes(recipeFilter);
}

//if search input recieves input 
document.getElementById('search-input').addEventListener("input",(event)=>{
    searchrecipe( event.target.value);
});




// function displayRecipes(recipes) {
//     const recipeList = document.getElementById('recipe-list');
//     recipeList.innerHTML = '';
//     //for each array object(recipes) and recipe is like index
//     recipes.forEach(recipe => {
//         //create a div element to display all values inside it for every object
//         const recipeDiv = document.createElement('div');
//         recipeDiv.className = 'recipee';
//         // In map() Iterates over each ingredient in the array and returns a new array where each ingredient is wrapped in a <li> element.
//         //.join(''): Converts the array of <li> elements into a single string without any separators.
//         recipeDiv.innerHTML = `
//             <h2>${recipe.title}</h2>
//             <div class="ingredients">Ingredients:
//                 <ul>${recipe.ingredients.map(ingredient => `<li>${ingredient}</li>`).join('')}</ul>
//             </div>
//             <div class="instructions">Instructions:<p>${recipe.instructions}</p></div>
//         `;
//         recipeList.appendChild(recipeDiv);
//     });
// }
