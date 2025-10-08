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

// Adding event listeners
document.addEventListener('DOMContentLoaded', function() { 
const form = document.getElementById('userForm');        
const statusDiv = document.getElementById('status');      

form.addEventListener('submit', function(event) {
event.preventDefault(); // prevent page reload 

const name = document.getElementById('name').value.trim(); 
const email = document.getElementById('email').value.trim(); 
const age = parseInt(document.getElementById('age').value.trim(), 10);
  });
});








