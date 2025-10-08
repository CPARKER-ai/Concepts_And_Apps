console.log("Welcome to my JavaScript Advanced Website"); 

console.log("Repo URL: https://github.com/CPARKER-ai/Concepts_And_Apps/tree/PA02");

// Strings
let identification = "Jonathan Crambell"; 
let idNumber = "300403789"; 
let todaysDate = "10-7-2025"; 

// Variables
let x = 10; 
let y = 20; 
let z = x*y; 
console.log("Multiply:", z);
const b = 21; 

// Boolean
let equalVariables = (y === b);
console.log("Are y and b equal?", equalVariables); 
let registeredAdult = true;
let hasID = false;
let eligibletoEnter = registeredAdult && hasID;
console.log("Can enter?", eligibletoEnter);


// Arrays 
const cars = ["Buick", "Volvo", "BMW"];

// JS Objects 
const car = {type:"Fiat", model:"500", color:"white"};

// Null and Undefined 
let identifier = null; 
let unknownID; 

// BuildURL function definition - for Decomposition 
function buildURL(baseURL, params = {}) {
  const url = new URL(baseURL);
  Object.keys(params).forEach(key => {
    if (params[key] !== undefined && params[key] !== null) {
      url.searchParams.append(key, params[key]);
    }
  });
  return url.toString();
}

// Adding event listeners
document.addEventListener('DOMContentLoaded', function() { 
  const form = document.getElementById('userForm');        
  const statusDiv = document.getElementById('status');  
  const emailInput = document.getElementById('email');
// Updated Array Variables
  const id = ["idCard", "passport", "insuranceCard", "studentID", "driversLicense", "debitCardStatement"]; 
  renderAuthenticationForms(id);

  const baseURL = 'https://api.example.com/items';
  const params = { category: 'identification', page: 1 };
  const url = buildURL(baseURL, params);

  // Input event listener for email input
  emailInput.addEventListener('input', function(event) {
    console.log("Email input changed to:", event.target.value);
  });

  // Submit event listener for form
  form.addEventListener('submit', function(event) {
    event.preventDefault(); // prevent page reload 
    const name = document.getElementById('name').value.trim(); 
    const email = emailInput.value.trim(); 
    const age = parseInt(document.getElementById('age').value.trim(), 10);
    const formData = { name, email, age }; 

  // including Fetch
  fetch(url)
  .then(response => {
    if (!response.ok) throw new Error(`Error: ${response.status}`);
    return response.json();
  })
  .then(data => renderList(data))
  .catch(handleError); 
  
  fetch('https://example.com/api/submit', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(formData),
  })
  .then(response => response.json())
  .then(data => {
    
    // Updated state status
    statusDiv.textContent = "Form submitted successfully! Server says: " + data.message;
  })
  .catch(error => {
    statusDiv.textContent = "Error submitting form: " + error.message;
  });
});
 // Render the authentication forms list on page load

function renderList(data) {
  console.log("Fetched data:", data);
}

function handleError(error) {
  console.error("Fetch error:", error.message);
}
  });

// Creating the conditional array function for the 6 item loop for id authentication
function renderAuthenticationForms(array) { 
  const container = document.getElementById("Authentication"); 
  container.innerHTML = ""; 

  for (let i = 0; i < array.length; i++) {
    const li = document.createElement("li"); 
    li.textContent = array[i]; 
    container.appendChild(li); 
  }
} 





