function getFactors() {
    let nameVar = document.getElementById("factors").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
           document.getElementById("getfactors").innerHTML =
           this.responseText;
    };
    xhttp.open("GET", "/factors?value="+nameVar);
    xhttp.send();
}

function getPrimes() {
    let nameVar = document.getElementById("primes").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
           document.getElementById("getprimes").innerHTML =
           this.responseText;
    };
    xhttp.open("GET", "/primes?value="+nameVar);
    xhttp.send();
}