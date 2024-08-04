document.getElementById('textInput').addEventListener('input', function(event) {
    const text = event.target.value;//taking input
    //filter(Boolean)  if it starts or ends with spaces, splitting it might create empty strings in the resulting array. to remove any empty strings that might have been created
    //split(/\s+/) splits the text by one or more whitespace characters, so multiple spaces between words are treated as a single delimiter
    const word = text.trim().split(/\s+/).filter(Boolean);
    let wordCount = word.length;
    const charCount = text.length;//counts space too
    
    document.getElementById('wordCount').textContent = wordCount;
    document.getElementById('charCount').textContent = charCount;
});

//using split and trim :)

//Remove Falsy Values:
let values = [0, 1, false, true, "   ", "", "non-empty"];
let result = values.filter(Boolean);
console.log(result);  // [1, true, '   ', 'non-empty']

//Remove Empty Strings:
let words = ["apple", "   ", "banana", " ", "orange"]; 
let result2 = words.filter(word =>  word.trim() !== "" );//"  " becomes "" after trimming, so it’s filtered out.
console.log(result2);

//Split and Remove Empty Strings:
let text = "   apple   banana  orange   ";
let result3  = text.trim().split(/\s+/).filter(Boolean);//split by one or more spaces
console.log(result3);


//A delimiter is a character or symbol used in computer code that separates words, data, or characters
let text2 = "  apple,  banana,,orange";
let result4 = text2.trim().split(",").filter(item => item !== "");
console.log(result4);// ['apple', '  banana', 'orange']