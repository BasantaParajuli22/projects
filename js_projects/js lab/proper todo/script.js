// Set up event listeners
document.addEventListener('DOMContentLoaded', () => {
  //calling greeting and loadTasks function after document is loaded completely
  setGreeting();
  loadTasks();
  document.getElementById('taskInput').addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
      handleTaskSubmission(event);//call function if enter is pressed
    }
  });
   // Event listener for the Add Task button
   document.getElementById('addTaskButton').addEventListener('click', handleTaskSubmission);

});


// Display greeting based on time of day
function setGreeting() {
  const hours = new Date().getHours();
  const greeting = document.getElementById('greeting');
  if (hours < 12) {
    greeting.textContent = 'Good Morning';
  } else if (hours < 18) {
    greeting.textContent = 'Good Afternoon';
  } else {
    greeting.textContent = 'Good Evening';
  }
}

// Load tasks from local storage which were saved
function loadTasks() {
  const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
  tasks.forEach(task => addTaskToDOM(task));
}

// Add task to DOM
function addTaskToDOM(task) {
  const taskList = document.getElementById('taskList');

  const listItem = document.createElement('li');//creating list for new added task
  listItem.setAttribute('data-id', task.id); // Set task ID on <li> for easy targeting
  
  const taskInput = document.createElement('input');//creating taskInput field to easily edit it
  const editBtn = document.createElement('button');//crating edit button
  const deleteBtn = document.createElement('button');
 
  taskInput.type = 'text';//setting content type of input to text
  taskInput.value = task.text;//adding value in taskinput field

  editBtn.textContent = 'Edit';
  deleteBtn.textContent = 'Delete';

 // editBtn.classList.add('edit');
  editBtn.onclick = () => editTask(taskInput, editBtn);//calling editTask() if click
 // deleteBtn.classList.add('delete');
  deleteBtn.onclick = () => deleteTask(task.id);//calling deleteTask() if click

  listItem.appendChild(taskInput);//adding taskInput to ListItem
  listItem.appendChild(editBtn);//adding edit button
  listItem.appendChild(deleteBtn);//adding delete button
  taskList.appendChild(listItem);//adding all to taskList
}


// Save task to local storage
function saveTask(task) {
 // JSON.parse(...) converts this JSON string back into a JavaScript array
  const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
  //adds the new task to the tasks array:
  tasks.push(task);
  //JSON.stringify(tasks) converts the updated tasks array back into a JSON string
  //setting the JSON tasks into local storage
  localStorage.setItem('tasks', JSON.stringify(tasks));
}

// Handle task submission
function handleTaskSubmission(event) {
  event.preventDefault();//doesnot let form peform default behaviour
  const taskInput = document.getElementById('taskInput');//taking value from (html input)
  const taskText = taskInput.value.trim();
  if (taskText) {//if taskText has some values 
    taskInput.value = '';//clear input form 
    addTask(taskText);//call function
  }
}

// Add a new task to the DOM and local storage
function addTask(taskText) {
  const task = { text: taskText,
    id : new Date().getTime()//getting time as id
   }; //he task object only has one property, text, which holds the taskText.
  //calling to add task in web document and local storage
  addTaskToDOM(task);
  saveTask(task);
}

function deleteTask(taskId){

  const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
  
  //deleting task which id matches taskId
  //by filtering tasks 
  //and not including that id in local storage
  //saving updated tasks
  const updatedtasks =  tasks.filter(task => task.id !== taskId);
  localStorage.setItem('tasks',JSON.stringify(updatedtasks));
  
  // Remove from DOM
  const taskList = document.getElementById('taskList');
  const taskItem = taskList.querySelector(`li[data-id='${taskId}']`);  // Find the task item using data-id
  if(taskItem){
    taskList.removeChild(taskItem);
  }
}