async function getJson(url) {
    let response = await fetch(url); //'http://localhost:8080/blazon/15'
    console.log(response);
    if (response.ok) {
        return(await response.json());
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

getJson('http://localhost:8080/blazon/1')
    .then(obj => document.getElementById('description').innerHTML = obj.description);
getJson('http://localhost:8080/blazon/1')
    .then(obj => document.getElementById('hash').innerHTML = obj.hash);
getJson('http://localhost:8080/blazon/1')
    .then(obj => document.getElementById('owners').setAttribute("href", "http://localhost:8080/owners.html?&" + obj.id));
