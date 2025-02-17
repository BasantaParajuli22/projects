
const questions = document.querySelectorAll('.faq-question');
questions.forEach(question  =>{

    question.addEventListener('click',()=>{
        
        question.parentElement.classList.toggle('active');
    });
});