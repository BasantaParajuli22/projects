

function showContent(contentNum) {

   //first hidding all contents (contentNum is 1 or 2 or 3)
   // and displaying contents of  content1 or content2 content3  at last 
    
   //hiding all contents 
   const contents = document.querySelectorAll('.content');
    contents.forEach(content =>{
        content.classList.remove('active');
    });

    //hiding all buttons active class 
    const buttons = document.querySelectorAll('.tab-button');
    buttons.forEach(button =>{
       button.classList.remove('active');
    });

    //showing content of content1 or content2 or content3
    document.getElementById(`content${contentNum}`).classList.add('active'); 
    //active button
    document.getElementById(`btn${contentNum}`).classList.add('active'); 
}

showContent(2);
